package com.ruoyi.car.service.impl;

import java.util.List;

import com.ruoyi.car.domain.CarPartSpace;
import com.ruoyi.car.service.ICarPartSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.car.mapper.CarPartBaseMapper;
import com.ruoyi.car.domain.CarPartBase;
import com.ruoyi.car.service.ICarPartBaseService;

import javax.annotation.Resource;

/**
 * 停车场的基本信息Service业务层处理
 * 
 * @author timlis
 * @date 2020-12-19
 */
@Service
public class CarPartBaseServiceImpl implements ICarPartBaseService 
{
    @Resource
    private CarPartBaseMapper carPartBaseMapper;

    @Autowired
    private ICarPartSpaceService carPartSpaceService;

    @Override
    public CarPartBase selectCarPartBaseById(Integer id)
    {
        return carPartBaseMapper.selectCarPartBaseById(id);
    }

    @Override
    public List<CarPartBase> selectCarPartBaseList(CarPartBase carPartBase)
    {
        return carPartBaseMapper.selectCarPartBaseList(carPartBase);
    }

    @Override
    public int replaceCarPartBase(CarPartBase carPartBase)
    {
        int i = carPartBaseMapper.replaceCarPartBase(carPartBase);
        for (Integer integer = 1; integer <= carPartBase.getTotalNums(); integer++) {
            carPartSpaceService.replaceCarPartSpace(new CarPartSpace(carPartBase.getId().longValue(),integer.longValue()));
        }
        return i;
    }

    @Override
    public int deleteCarPartBaseByIds(Integer[] ids)
    {
        return carPartBaseMapper.deleteCarPartBaseByIds(ids);
    }

    @Override
    public int deleteCarPartBaseById(Integer id)
    {
        return carPartBaseMapper.deleteCarPartBaseById(id);
    }
}
