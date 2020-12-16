package com.ruoyi.car.service.impl;

import java.util.List;

import com.ruoyi.car.mapper.CarModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.car.mapper.CarBrandMapper;
import com.ruoyi.car.domain.CarBrand;
import com.ruoyi.car.service.ICarBrandService;

/**
 * 品牌管理Service业务层处理
 * 
 * @author timlis
 * @date 2020-12-01
 */
@Service
public class CarBrandServiceImpl implements ICarBrandService 
{
    @Autowired
    private CarBrandMapper carBrandMapper;

    @Autowired
    private CarModelMapper carModelMapper;

    /**
     * 查询品牌管理
     * 
     * @param id 品牌管理ID
     * @return 品牌管理
     */
    @Override
    public CarBrand selectCarBrandById(Long id)
    {
        CarBrand carBrand = carBrandMapper.selectCarBrandById(id);
        carBrand.setModelList(carModelMapper.selectCarModelListByBrandId(id));
        return carBrand;
    }

    /**
     * 查询品牌管理列表
     * 
     * @param carBrand 品牌管理
     * @return 品牌管理
     */
    @Override
    public List<CarBrand> selectCarBrandList(CarBrand carBrand)
    {
        return carBrandMapper.selectCarBrandList(carBrand);
    }

    /**
     * 新增品牌管理
     * 
     * @param carBrand 品牌管理
     * @return 结果
     */
    @Override
    public int insertCarBrand(CarBrand carBrand)
    {
        return carBrandMapper.insertCarBrand(carBrand);
    }

    /**
     * 修改品牌管理
     * 
     * @param carBrand 品牌管理
     * @return 结果
     */
    @Override
    public int updateCarBrand(CarBrand carBrand)
    {
        return carBrandMapper.updateCarBrand(carBrand);
    }

    /**
     * 批量删除品牌管理
     * 
     * @param ids 需要删除的品牌管理ID
     * @return 结果
     */
    @Override
    public int deleteCarBrandByIds(Long[] ids)
    {
        return carBrandMapper.deleteCarBrandByIds(ids);
    }

    /**
     * 删除品牌管理信息
     * 
     * @param id 品牌管理ID
     * @return 结果
     */
    @Override
    public int deleteCarBrandById(Long id)
    {
        return carBrandMapper.deleteCarBrandById(id);
    }
}
