package com.ruoyi.car.service.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.List;

import com.ruoyi.car.domain.*;
import com.ruoyi.car.mapper.CarBaseInfoMapper;
import com.ruoyi.car.mapper.CarBillingMapper;
import com.ruoyi.car.mapper.CarCustomerMapper;
import com.ruoyi.car.service.*;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.car.mapper.CarOrderMapper;

import javax.annotation.Resource;

/**
 * 车辆订单Service业务层处理
 *
 * @author timlis
 * @date 2021-01-29
 */
@Service
public class CarOrderServiceImpl implements ICarOrderService {
    @Resource
    private CarOrderMapper carOrderMapper;

    @Autowired
    private ICarCustomerService carCustomerService;

    @Autowired
    private ICarBaseInfoService carBaseInfoService;

    @Autowired
    private ICarBillingService carBillingService;

    @Autowired
    private ICarPartSpaceService carPartSpaceService;

    @Autowired
    private ICarCustomerExpandService carCustomerExpandService;


    private void setCarAndCustomer(CarOrder carOrder) {
        if (carOrder.getCarId() != null) {
            carOrder.setCar(carBaseInfoService.selectCarBaseInfoById(carOrder.getCarId()));
        }
        if (carOrder.getCustomerId() != null) {
            carOrder.setCustomer(carCustomerService.selectCarCustomerById(carOrder.getCustomerId()));
        }
    }

    @Override
    public CarOrder selectCarOrderById(Long orderId) {
        CarOrder carOrder = carOrderMapper.selectCarOrderById(orderId);
        setCarAndCustomer(carOrder);
        return carOrder;
    }

    @Override
    public List<CarOrder> selectCarOrderList(CarOrder carOrder) {
        List<CarOrder> carOrderList = carOrderMapper.selectCarOrderList(carOrder);
        carOrderList.forEach(carOrder1 ->
                setCarAndCustomer(carOrder1)
        );
        return carOrderList;
    }

    @Override
    public int replaceCarOrder(CarOrder carOrder) {
        return carOrderMapper.replaceCarOrder(carOrder);
    }

    @Override
    public int deleteCarOrderByIds(Long[] orderIds) {
        return carOrderMapper.deleteCarOrderByIds(orderIds);
    }

    @Override
    public int countInAndOutByPartId(Integer partId, Integer status) {
        return carOrderMapper.countInAndOutByPartId(partId,status);
    }

    @Override
    public int deleteCarOrderById(Long orderId) {
        return carOrderMapper.deleteCarOrderById(orderId);
    }

    @Override
    public int rentCar(CarOrder carOrder) {

        //改变车辆状态为使用中
        CarBaseInfo car = carBaseInfoService.selectCarBaseInfoById(carOrder.getCarId());
        car.setUseState(3L);

        //更新停车场数据
        CarPartSpace space = carPartSpaceService.selectCarPartSpaceById(car.getPartId(), car.getSpaceId());
        space.updateSpaceFree();

        car.setPartId(null);
        car.setSpaceId(null);

        String date = DateUtils.parseDateToStr("YYYYMMddHHmmss", carOrder.getStartTime());
        //订单ID生产由时间+用户ID+车ID组成
        carOrder.setOrderId(Long.parseLong(date) + carOrder.getCustomerId() + carOrder.getCarId());
        carOrder.setState(0);

        carBaseInfoService.replaceCarBaseInfo(car);
        carPartSpaceService.replaceCarPartSpace(space);
        return carOrderMapper.replaceCarOrder(carOrder);
    }

    @Override
    public int returnCar(CarOrder carOrder) {

        CarOrder order = selectCarOrderById(carOrder.getOrderId());
        CarBaseInfo car = order.getCar();
        CarModel model = car.getCarModel();
        CarBilling billing = carBillingService.selectCarBillingById(model.getId());
        CarPartSpace partSpace = carPartSpaceService.selectCarPartSpaceById(carOrder.getEndPlaceId(), carOrder.getSpaceId());
        CarCustomerExpand customerExpand = carCustomerExpandService.selectCarCustomerExpandById(carOrder.getCustomerId());

        Long mileage = (model.getEndurance() / model.getBattery()) * (car.getCurBattery() - carOrder.getCurBattery());
        System.out.println("mileage is :" + mileage);
        BigDecimal cost = new BigDecimal(
                ((carOrder.getEndTime().getTime() - carOrder.getStartTime().getTime()) / 1000 / 60) * billing.getMinCost()
                        + mileage * billing.getKmCost());
        System.out.println("cost is :" + cost);

        order.setMileage(mileage);
        order.setCost(cost);
        order.setEndTime(carOrder.getEndTime());
        order.setEndPlaceId(carOrder.getEndPlaceId());
        order.setState(1);

        car.setCurBattery(carOrder.getCurBattery());
        car.setTotalMileage(car.getTotalMileage() + mileage);
        car.setTotalTime(car.getTotalTime() + ((carOrder.getEndTime().getTime() - carOrder.getStartTime().getTime()) / 1000 / 60));
        car.setPartId(carOrder.getEndPlaceId());
        car.setSpaceId(carOrder.getSpaceId());
        car.setUseState(0L);

        partSpace.updateSpaceBusy(order, order.getCarId());

        customerExpand.updateUseTimes((carOrder.getEndTime().getTime() - carOrder.getStartTime().getTime()) / 1000 / 60);
        customerExpand.updateTotalMileage(mileage);
        customerExpand.updateNowBalance(cost);
        System.out.println("cost long value is :" + cost.longValue());
        customerExpand.updateCreditScore(cost.longValue());

        carBaseInfoService.replaceCarBaseInfo(car);
        carPartSpaceService.replaceCarPartSpace(partSpace);
        carCustomerExpandService.replaceCarCustomerExpand(customerExpand);

        return carOrderMapper.replaceCarOrder(order);
    }
}
