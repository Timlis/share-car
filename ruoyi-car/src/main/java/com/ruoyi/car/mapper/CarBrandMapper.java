package com.ruoyi.car.mapper;

import java.util.List;
import com.ruoyi.car.domain.CarBrand;

/**
 * 品牌管理Mapper接口
 * 
 * @author timlis
 * @date 2020-12-01
 */
public interface CarBrandMapper 
{
    /**
     * 查询品牌管理
     * 
     * @param id 品牌管理ID
     * @return 品牌管理
     */
    public CarBrand selectCarBrandById(Long id);

    /**
     * 查询品牌管理列表
     * 
     * @param carBrand 品牌管理
     * @return 品牌管理集合
     */
    public List<CarBrand> selectCarBrandList(CarBrand carBrand);

    /**
     * 新增品牌管理
     * 
     * @param carBrand 品牌管理
     * @return 结果
     */
    public int insertCarBrand(CarBrand carBrand);

    /**
     * 修改品牌管理
     * 
     * @param carBrand 品牌管理
     * @return 结果
     */
    public int updateCarBrand(CarBrand carBrand);

    /**
     * 删除品牌管理
     * 
     * @param id 品牌管理ID
     * @return 结果
     */
    public int deleteCarBrandById(Long id);

    /**
     * 批量删除品牌管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCarBrandByIds(Long[] ids);
}
