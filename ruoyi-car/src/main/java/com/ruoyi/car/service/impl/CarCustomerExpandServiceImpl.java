package com.ruoyi.car.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.car.mapper.CarCustomerExpandMapper;
import com.ruoyi.car.domain.CarCustomerExpand;
import com.ruoyi.car.service.ICarCustomerExpandService;

/**
 * 用户扩展信息Service业务层处理
 * 
 * @author timlis
 * @date 2020-11-28
 */
@Service
public class CarCustomerExpandServiceImpl implements ICarCustomerExpandService 
{
    @Autowired
    private CarCustomerExpandMapper carCustomerExpandMapper;

    @Override
    public CarCustomerExpand selectCarCustomerExpandById(Long id)
    {
        return carCustomerExpandMapper.selectCarCustomerExpandById(id);
    }

    @Override
    public List<CarCustomerExpand> selectCarCustomerExpandList(CarCustomerExpand carCustomerExpand)
    {
        return carCustomerExpandMapper.selectCarCustomerExpandList(carCustomerExpand);
    }

    @Override
    public int replaceCarCustomerExpand(CarCustomerExpand carCustomerExpand)
    {
        return carCustomerExpandMapper.replaceCarCustomerExpand(carCustomerExpand);
    }

    @Override
    public int deleteCarCustomerExpandByIds(Long[] ids)
    {
        return carCustomerExpandMapper.deleteCarCustomerExpandByIds(ids);
    }

    @Override
    public int deleteCarCustomerExpandById(Long id)
    {
        return carCustomerExpandMapper.deleteCarCustomerExpandById(id);
    }
}
