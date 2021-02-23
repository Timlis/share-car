package com.ruoyi.car.service;

import java.util.List;
import com.ruoyi.car.domain.CarCustomerExpand;

/**
 * 用户扩展信息Service接口
 * 
 * @author timlis
 * @date 2020-11-28
 */
public interface ICarCustomerExpandService 
{

    public CarCustomerExpand selectCarCustomerExpandById(Long id);

    public List<CarCustomerExpand> selectCarCustomerExpandList(CarCustomerExpand carCustomerExpand);

    public int replaceCarCustomerExpand(CarCustomerExpand carCustomerExpand);

    public int deleteCarCustomerExpandByIds(Long[] ids);

    public int deleteCarCustomerExpandById(Long id);
}
