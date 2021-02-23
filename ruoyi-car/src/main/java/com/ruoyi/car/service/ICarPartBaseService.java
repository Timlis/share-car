package com.ruoyi.car.service;

import java.util.List;
import com.ruoyi.car.domain.CarPartBase;

/**
 * 停车场的基本信息Service接口
 * 
 * @author timlis
 * @date 2020-12-19
 */
public interface ICarPartBaseService 
{

    public CarPartBase selectCarPartBaseById(Integer id);

    public List<CarPartBase> selectCarPartBaseList(CarPartBase carPartBase);

    public int replaceCarPartBase(CarPartBase carPartBase);

    public int deleteCarPartBaseByIds(Integer[] ids);

    public int deleteCarPartBaseById(Integer id);
}
