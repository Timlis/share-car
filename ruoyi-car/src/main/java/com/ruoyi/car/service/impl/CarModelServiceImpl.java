package com.ruoyi.car.service.impl;

import java.util.List;

import com.ruoyi.car.mapper.CarBaseInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.car.mapper.CarModelMapper;
import com.ruoyi.car.domain.CarModel;
import com.ruoyi.car.service.ICarModelService;

/**
 * 车型管理Service业务层处理
 * 
 * @author timlis
 * @date 2020-12-02
 */
@Service
public class CarModelServiceImpl implements ICarModelService 
{
    @Autowired
    private CarModelMapper carModelMapper;


    /**
     * 查询车型管理
     * 
     * @param id 车型管理ID
     * @return 车型管理
     */
    @Override
    public CarModel selectCarModelById(Long id)
    {
        return carModelMapper.selectCarModelById(id);
    }

    /**
     * 查询车型管理列表
     * 
     * @param carModel 车型管理
     * @return 车型管理
     */
    @Override
    public List<CarModel> selectCarModelList(CarModel carModel)
    {
        return carModelMapper.selectCarModelList(carModel);
    }

    /**
 * 根据车品牌id查询所有车型
 * @param brandId 车品牌id
 * @return
 */
    @Override
    public List<CarModel> selectCarModelListByBrandId(Long brandId) {
        return carModelMapper.selectCarModelListByBrandId(brandId);
    }

    /**
     * 新增车型管理
     * 
     * @param carModel 车型管理
     * @return 结果
     */
    @Override
    public int insertCarModel(CarModel carModel)
    {

        return carModelMapper.insertCarModel(carModel);
    }

    /**
     * 修改车型管理
     * 
     * @param carModel 车型管理
     * @return 结果
     */
    @Override
    public int updateCarModel(CarModel carModel)
    {
        return carModelMapper.updateCarModel(carModel);
    }

    /**
     * 批量删除车型管理
     * 
     * @param ids 需要删除的车型管理ID
     * @return 结果
     */
    @Override
    public int deleteCarModelByIds(Long[] ids)
    {
        return carModelMapper.deleteCarModelByIds(ids);
    }

    /**
     * 删除车型管理信息
     * 
     * @param id 车型管理ID
     * @return 结果
     */
    @Override
    public int deleteCarModelById(Long id)
    {
        return carModelMapper.deleteCarModelById(id);
    }
}
