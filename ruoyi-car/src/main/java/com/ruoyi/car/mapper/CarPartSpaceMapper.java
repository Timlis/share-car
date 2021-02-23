package com.ruoyi.car.mapper;

import java.util.List;

import com.ruoyi.car.domain.CarBaseInfo;
import com.ruoyi.car.domain.CarPartSpace;

/**
 * 停车位信息Mapper接口
 * 
 * @author timlis
 * @date 2021-01-08
 */
public interface CarPartSpaceMapper 
{
    public CarPartSpace selectCarPartSpaceById(Long partId,Long id);

    public List<CarPartSpace> selectCarPartSpaceList(CarPartSpace carPartSpace);

    public int replaceCarPartSpace(CarPartSpace carPartSpace);

    Integer getFreeSpaceCount(Long partId);

    List<Long> selectCarIdsByPartId(Long partId);
}
