package com.ruoyi.car.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ruoyi.car.domain.CarBaseInfo;
import com.ruoyi.car.mapper.CarBaseInfoMapper;
import com.ruoyi.car.service.ICarBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.car.mapper.CarPartSpaceMapper;
import com.ruoyi.car.domain.CarPartSpace;
import com.ruoyi.car.service.ICarPartSpaceService;


@Service
public class CarPartSpaceServiceImpl implements ICarPartSpaceService {
    @Autowired
    private CarPartSpaceMapper carPartSpaceMapper;

    @Autowired
    private ICarBaseInfoService carBaseInfoService;

    @Override
    public CarPartSpace selectCarPartSpaceById(Long partId,Long id) {
        return carPartSpaceMapper.selectCarPartSpaceById(partId,id);
    }

    @Override
    public List<CarPartSpace> selectCarPartSpaceList(CarPartSpace carPartSpace) {
        return carPartSpaceMapper.selectCarPartSpaceList(carPartSpace);
    }

    @Override
    public List<CarPartSpace> selectCarPartSpaceByPartId(Long partId) {
        CarPartSpace carPartSpace = new CarPartSpace();
        carPartSpace.setPartId(partId);
        List<CarPartSpace> carPartSpaces = carPartSpaceMapper.selectCarPartSpaceList(carPartSpace);
        carPartSpaces.forEach(
                carPartSpace1 -> {
                    if (carPartSpace1.getCarId() != null) {
                        carPartSpace1.setCarBaseInfo(carBaseInfoService.selectCarBaseInfoById(carPartSpace1.getCarId()));
                    }
                });
        return carPartSpaces;
    }

    @Override
    public int replaceCarPartSpace(CarPartSpace carPartSpace) {
        return carPartSpaceMapper.replaceCarPartSpace(carPartSpace);
    }

    @Override
    public Integer getFreeSpaceCount(Long partId) {
        return carPartSpaceMapper.getFreeSpaceCount(partId);
    }

    @Override
    public List<CarBaseInfo> selectCarByPartId(Long partId) {
        List<Long> carNumbersList = carPartSpaceMapper.selectCarIdsByPartId(partId);
        List<CarBaseInfo> carBaseInfoList = new ArrayList<>();
        for (Long l : carNumbersList) {
            CarBaseInfo carBaseInfo = carBaseInfoService.selectCarBaseInfoById(l);
            //筛选当前可租出的车辆
            if (carBaseInfo.getState() == 0 && (carBaseInfo.getUseState() == 0 || carBaseInfo.getUseState() == 1)){
                carBaseInfoList.add(carBaseInfo);
            }
        }
        return carBaseInfoList;
    }
}
