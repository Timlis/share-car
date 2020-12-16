package com.ruoyi.car.mapper;

import java.util.List;
import com.ruoyi.car.domain.CarCustomer;
import com.ruoyi.car.domain.CarCustomerExpand;

/**
 * 客户管理Mapper接口
 * 
 * @author Timlis
 * @date 2020-11-24
 */
public interface CarCustomerMapper 
{
    /**
     * 查询客户管理
     * 
     * @param id 客户管理ID
     * @return 客户管理
     */
    public CarCustomer selectCarCustomerById(Long id);

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
     * 删除客户管理
     * 
     * @param id 客户管理ID
     * @return 结果
     */
    public int deleteCarCustomerById(Long id);

    /**
     * 批量删除客户管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCarCustomerByIds(Long[] ids);

    /**
     * 查询客户所有信息
     * @param id
     * @return
     */
    CarCustomerExpand selectCarCustomerAllById(Long id);
}
