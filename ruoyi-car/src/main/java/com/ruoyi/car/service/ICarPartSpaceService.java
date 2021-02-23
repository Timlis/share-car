package com.ruoyi.car.service;

import java.util.List;

import com.ruoyi.car.domain.CarBaseInfo;
import com.ruoyi.car.domain.CarPartSpace;

/**
 * 停车位信息Service接口
 * 
 * @author timlis
 * @date 2021-01-08
 */
public interface ICarPartSpaceService 
{

    CarPartSpace selectCarPartSpaceById(Long partId,Long spaceId);

    List<CarPartSpace> selectCarPartSpaceList(CarPartSpace carPartSpace);

    List<CarPartSpace> selectCarPartSpaceByPartId(Long partId);

    int replaceCarPartSpace(CarPartSpace carPartSpace);

    Integer getFreeSpaceCount(Long partId);

    List<CarBaseInfo> selectCarByPartId(Long partId);
}
