package com.ruoyi.car.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.car.domain.CarModel;
import com.ruoyi.car.domain.CarPartSpace;
import com.ruoyi.car.mapper.CarModelMapper;
import com.ruoyi.car.service.ICarModelService;
import com.ruoyi.car.service.ICarPartSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.car.mapper.CarBaseInfoMapper;
import com.ruoyi.car.domain.CarBaseInfo;
import com.ruoyi.car.service.ICarBaseInfoService;

import javax.annotation.Resource;

/**
 * 基本信息Service业务层处理
 *
 * @author timlis
 * @date 2020-12-02
 */
@Service
public class CarBaseInfoServiceImpl implements ICarBaseInfoService {
    @Resource
    private CarBaseInfoMapper carBaseInfoMapper;

    @Autowired
    private ICarModelService carModelService;

    @Autowired
    private ICarPartSpaceService carPartSpaceService;

    private Long setCurEndurance(CarBaseInfo carBaseInfo) {
        return (carBaseInfo.getCarModel().getEndurance() / carBaseInfo.getCarModel().getBattery()) * carBaseInfo.getCurBattery();
    }

    @Override
    public CarBaseInfo selectCarBaseInfoById(Long id) {
        CarBaseInfo carBaseInfo = carBaseInfoMapper.selectCarBaseInfoById(id);
        //每辆具体车绑定一个车型
        carBaseInfo.setCarModel(carModelService.selectCarModelById(carBaseInfo.getModelId()));
        carBaseInfo.setCurEndurance(setCurEndurance(carBaseInfo));
        return carBaseInfo;
    }

    @Override
    public CarBaseInfo selectCarBaseInfoByCarNumber(String CarNumber) {
        CarBaseInfo carBaseInfo = carBaseInfoMapper.selectCarBaseInfoByCarNumber(CarNumber);
        //每辆具体车绑定一个车型
        carBaseInfo.setCarModel(carModelService.selectCarModelById(carBaseInfo.getModelId()));
        carBaseInfo.setCurEndurance(setCurEndurance(carBaseInfo));
        return carBaseInfo;
    }

    @Override
    public List<CarBaseInfo> selectCarBaseInfoList(CarBaseInfo carBaseInfo) {
        List<CarBaseInfo> carBaseInfos = carBaseInfoMapper.selectCarBaseInfoList(carBaseInfo);
        carBaseInfos.forEach(carInfo -> {
            carInfo.setCarModel(carModelService.selectCarModelById(carInfo.getModelId()));
            carInfo.setCurEndurance(setCurEndurance(carInfo));
        });
        return carBaseInfos;
    }

    @Override
    public int replaceCarBaseInfo(CarBaseInfo carBaseInfo) {
        CarBaseInfo carBaseInfoOld;

        if (carBaseInfo.getId() == null){
            CarModel carModel = carModelService.selectCarModelById(carBaseInfo.getModelId());
            carModel.setCarNumber(carBaseInfoMapper.CountCarByModelId(carBaseInfo.getModelId()) + 1);
            carModelService.updateCarModel(carModel);
        }else {
            carBaseInfoOld = carBaseInfoMapper.selectCarBaseInfoById(carBaseInfo.getId());
            if (carBaseInfoOld.getPartId() != null){
                CarPartSpace carPartSpace = carPartSpaceService.selectCarPartSpaceById(carBaseInfoOld.getPartId(), carBaseInfoOld.getSpaceId());
                carPartSpace.updateSpaceFree();
                carPartSpaceService.replaceCarPartSpace(carPartSpace);
            }
        }

        int i = carBaseInfoMapper.replaceCarBaseInfo(carBaseInfo);

        if (carBaseInfo.getPartId() != null){
            CarPartSpace partSpace = carPartSpaceService.selectCarPartSpaceById(carBaseInfo.getPartId(), carBaseInfo.getSpaceId());
            partSpace.updateSpaceBusy(null,carBaseInfoMapper.selectCarBaseInfoByCarNumber(carBaseInfo.getCarNumber()).getId());
            carPartSpaceService.replaceCarPartSpace(partSpace);
        }

        return i;
    }

    @Override
    public int deleteCarBaseInfoByIds(Long[] ids) {
        return carBaseInfoMapper.deleteCarBaseInfoByIds(ids);
    }

    @Override
    public int deleteCarBaseInfoById(Long id) {
        return carBaseInfoMapper.deleteCarBaseInfoById(id);
    }
}
