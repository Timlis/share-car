package com.ruoyi.car.mapper;

import java.util.List;
import com.ruoyi.car.domain.CarPartBase;

/**
 * 停车场的基本信息Mapper接口
 * 
 * @author timlis
 * @date 2020-12-19
 */
public interface CarPartBaseMapper 
{

    public CarPartBase selectCarPartBaseById(Integer id);

    public List<CarPartBase> selectCarPartBaseList(CarPartBase carPartBase);

    public int replaceCarPartBase(CarPartBase carPartBase);

    public int deleteCarPartBaseById(Integer id);

    public int deleteCarPartBaseByIds(Integer[] ids);
}
