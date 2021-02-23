package com.ruoyi.car.mapper;

import java.util.List;
import com.ruoyi.car.domain.CarCustomerExpand;

/**
 * 用户扩展信息Mapper接口
 * 
 * @author timlis
 * @date 2020-11-28
 */
public interface CarCustomerExpandMapper 
{

    public CarCustomerExpand selectCarCustomerExpandById(Long id);

    public List<CarCustomerExpand> selectCarCustomerExpandList(CarCustomerExpand carCustomerExpand);

    public int replaceCarCustomerExpand(CarCustomerExpand carCustomerExpand);

    public int deleteCarCustomerExpandById(Long id);

    public int deleteCarCustomerExpandByIds(Long[] ids);
}
