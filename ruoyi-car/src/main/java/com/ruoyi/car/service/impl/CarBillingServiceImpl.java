package com.ruoyi.car.service.impl;

import java.util.List;

import com.ruoyi.car.mapper.CarModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.car.mapper.CarBillingMapper;
import com.ruoyi.car.domain.CarBilling;
import com.ruoyi.car.service.ICarBillingService;

/**
 * 计费管理Service业务层处理
 * 
 * @author timlis
 * @date 2021-01-29
 */
@Service
public class CarBillingServiceImpl implements ICarBillingService 
{
    @Autowired
    private CarBillingMapper carBillingMapper;

    @Autowired
    private CarModelMapper carModelMapper;

    /**
     * 查询计费管理
     * 
     * @param modelId 计费管理ID
     * @return 计费管理
     */
    @Override
    public CarBilling selectCarBillingById(Long modelId)
    {
        CarBilling carBilling = carBillingMapper.selectCarBillingById(modelId);
        carBilling.setBrandId(carModelMapper.selectCarModelById(modelId).getBrandId());
        return carBilling;
    }

    /**
     * 查询计费管理列表
     * 
     * @param carBilling 计费管理
     * @return 计费管理
     */
    @Override
    public List<CarBilling> selectCarBillingList(CarBilling carBilling)
    {
        return carBillingMapper.selectCarBillingList(carBilling);
    }

    /**
     * 新增计费管理
     * 
     * @param carBilling 计费管理
     * @return 结果
     */
    @Override
    public int insertCarBilling(CarBilling carBilling)
    {
        return carBillingMapper.insertCarBilling(carBilling);
    }

    /**
     * 修改计费管理
     * 
     * @param carBilling 计费管理
     * @return 结果
     */
    @Override
    public int updateCarBilling(CarBilling carBilling)
    {
        return carBillingMapper.updateCarBilling(carBilling);
    }


    /**
     * 新增或修改
     * @param carBilling
     * @return
     */
    public int replaceCarBilling(CarBilling carBilling){
        return carBillingMapper.replaceCarBilling(carBilling);
    }

    /**
     * 批量删除计费管理
     * 
     * @param modelIds 需要删除的计费管理ID
     * @return 结果
     */
    @Override
    public int deleteCarBillingByIds(Long[] modelIds)
    {
        return carBillingMapper.deleteCarBillingByIds(modelIds);
    }

    /**
     * 删除计费管理信息
     * 
     * @param modelId 计费管理ID
     * @return 结果
     */
    @Override
    public int deleteCarBillingById(Long modelId)
    {
        return carBillingMapper.deleteCarBillingById(modelId);
    }
}
