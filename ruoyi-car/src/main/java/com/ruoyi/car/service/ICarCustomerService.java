package com.ruoyi.car.service;

import java.util.List;
import com.ruoyi.car.domain.CarCustomer;
import com.ruoyi.car.domain.CarCustomerExpand;

/**
 * 客户管理Service接口
 * 
 * @author Timlis
 * @date 2020-11-24
 */
public interface ICarCustomerService 
{
    /**
     * 查询客户管理
     * 
     * @param id 客户管理ID
     * @return 客户管理
     */
    public CarCustomer selectCarCustomerById(Long id);

    /**
     * 查询客户所有信息
     *
     * @param id 客户管理ID
     * @return 客户管理
     */
    public CarCustomerExpand selectCarCustomerAllById(Long id);

    /**
     * 查询客户管理列表
     * 
     * @param carCustomer 客户管理
     * @return 客户管理集合
     */
    public List<CarCustomer> selectCarCustomerList(CarCustomer carCustomer);

    /**
     * 新增客户管理
     * 
     * @param carCustomer 客户管理
     * @return 结果
     */
    public int insertCarCustomer(CarCustomer carCustomer);

    /**
     * 修改客户管理
     * 
     * @param carCustomer 客户管理
     * @return 结果
     */
    public int updateCarCustomer(CarCustomer carCustomer);

    /**
     * 批量删除客户管理
     * 
     * @param ids 需要删除的客户管理ID
     * @return 结果
     */
    public int deleteCarCustomerByIds(Long[] ids);

    /**
     * 删除客户管理信息
     * 
     * @param id 客户管理ID
     * @return 结果
     */
    public int deleteCarCustomerById(Long id);
}
