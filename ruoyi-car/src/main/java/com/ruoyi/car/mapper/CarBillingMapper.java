package com.ruoyi.car.mapper;

import java.util.List;
import com.ruoyi.car.domain.CarBilling;

/**
 * 计费管理Mapper接口
 * 
 * @author timlis
 * @date 2021-01-29
 */
public interface CarBillingMapper 
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
     * 修改计费管理
     * 
     * @param carBilling 计费管理
     * @return 结果
     */
    public int updateCarBilling(CarBilling carBilling);

    /**
     * 删除计费管理
     * 
     * @param modelId 计费管理ID
     * @return 结果
     */
    public int deleteCarBillingById(Long modelId);

    /**
     * 批量删除计费管理
     * 
     * @param modelIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCarBillingByIds(Long[] modelIds);


    /**
     * 新增或修改
     * @param carBilling
     * @return
     */
    int replaceCarBilling(CarBilling carBilling);
}
