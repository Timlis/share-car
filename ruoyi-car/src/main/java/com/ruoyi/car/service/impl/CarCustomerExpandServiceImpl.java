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

    /**
     * 查询用户扩展信息
     * 
     * @param id 用户扩展信息ID
     * @return 用户扩展信息
     */
    @Override
    public CarCustomerExpand selectCarCustomerExpandById(Long id)
    {
        return carCustomerExpandMapper.selectCarCustomerExpandById(id);
    }

    /**
     * 查询用户扩展信息列表
     * 
     * @param carCustomerExpand 用户扩展信息
     * @return 用户扩展信息
     */
    @Override
    public List<CarCustomerExpand> selectCarCustomerExpandList(CarCustomerExpand carCustomerExpand)
    {
        return carCustomerExpandMapper.selectCarCustomerExpandList(carCustomerExpand);
    }

    /**
     * 新增用户扩展信息
     * 
     * @param carCustomerExpand 用户扩展信息
     * @return 结果
     */
    @Override
    public int insertCarCustomerExpand(CarCustomerExpand carCustomerExpand)
    {
        return carCustomerExpandMapper.insertCarCustomerExpand(carCustomerExpand);
    }

    /**
     * 修改用户扩展信息
     * 
     * @param carCustomerExpand 用户扩展信息
     * @return 结果
     */
    @Override
    public int updateCarCustomerExpand(CarCustomerExpand carCustomerExpand)
    {
        return carCustomerExpandMapper.updateCarCustomerExpand(carCustomerExpand);
    }

    /**
     * 批量删除用户扩展信息
     * 
     * @param ids 需要删除的用户扩展信息ID
     * @return 结果
     */
    @Override
    public int deleteCarCustomerExpandByIds(Long[] ids)
    {
        return carCustomerExpandMapper.deleteCarCustomerExpandByIds(ids);
    }

    /**
     * 删除用户扩展信息信息
     * 
     * @param id 用户扩展信息ID
     * @return 结果
     */
    @Override
    public int deleteCarCustomerExpandById(Long id)
    {
        return carCustomerExpandMapper.deleteCarCustomerExpandById(id);
    }
}
