package com.ruoyi.car.service;

import java.util.List;
import com.ruoyi.car.domain.CarOrder;

/**
 * 车辆订单Service接口
 * 
 * @author timlis
 * @date 2021-01-29
 */
public interface ICarOrderService 
{

    CarOrder selectCarOrderById(Long orderId);

    List<CarOrder> selectCarOrderList(CarOrder carOrder);

    int replaceCarOrder(CarOrder carOrder);

    int deleteCarOrderByIds(Long[] orderIds);

    int countInAndOutByPartId(Integer partId, Integer status);

    int deleteCarOrderById(Long orderId);

    int rentCar(CarOrder carOrder);

    int returnCar(CarOrder carOrder);


}
