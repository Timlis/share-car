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
    /**
     * 查询用户扩展信息
     * 
     * @param id 用户扩展信息ID
     * @return 用户扩展信息
     */
    public CarCustomerExpand selectCarCustomerExpandById(Long id);

    /**
     * 查询用户扩展信息列表
     * 
     * @param carCustomerExpand 用户扩展信息
     * @return 用户扩展信息集合
     */
    public List<CarCustomerExpand> selectCarCustomerExpandList(CarCustomerExpand carCustomerExpand);

    /**
     * 新增用户扩展信息
     * 
     * @param carCustomerExpand 用户扩展信息
     * @return 结果
     */
    public int insertCarCustomerExpand(CarCustomerExpand carCustomerExpand);

    /**
     * 修改用户扩展信息
     * 
     * @param carCustomerExpand 用户扩展信息
     * @return 结果
     */
    public int updateCarCustomerExpand(CarCustomerExpand carCustomerExpand);

    /**
     * 删除用户扩展信息
     * 
     * @param id 用户扩展信息ID
     * @return 结果
     */
    public int deleteCarCustomerExpandById(Long id);

    /**
     * 批量删除用户扩展信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCarCustomerExpandByIds(Long[] ids);
}
