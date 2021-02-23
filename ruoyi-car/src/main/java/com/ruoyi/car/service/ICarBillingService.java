package com.ruoyi.car.service;

import java.util.List;
import com.ruoyi.car.domain.CarBilling;

/**
 * 计费管理Service接口
 * 
 * @author timlis
 * @date 2021-01-29
 */
public interface ICarBillingService 
{
    /**
     * 查询计费管理
     * 
     * @param modelId 计费管理ID
     * @return 计费管理
     */
    public CarBilling selectCarBillingById(Long modelId);

    /**
     * 查询计费管理列表
     * 
     * @param carBilling 计费管理
     * @return 计费管理集合
     */
    public List<CarBilling> selectCarBillingList(CarBilling carBilling);

    /**
     * 新增计费管理
     * 
     * @param carBilling 计费管理
     * @return 结果
     */
    public int insertCarBilling(CarBilling carBilling);

    /**
     * 新增或修改
     * @param carBilling
     * @return
     */
    public int replaceCarBilling(CarBilling carBilling);

    /**
     * 修改计费管理
     * 
     * @param carBilling 计费管理
     * @return 结果
     */
    public int updateCarBilling(CarBilling carBilling);

    /**
     * 批量删除计费管理
     * 
     * @param modelIds 需要删除的计费管理ID
     * @return 结果
     */
    public int deleteCarBillingByIds(Long[] modelIds);

    /**
     * 删除计费管理信息
     * 
     * @param modelId 计费管理ID
     * @return 结果
     */
    public int deleteCarBillingById(Long modelId);
}
