package com.ruoyi.car.service;

import java.util.List;
import com.ruoyi.car.domain.CarModel;

/**
 * 车型管理Service接口
 * 
 * @author timlis
 * @date 2020-12-02
 */
public interface ICarModelService 
{
    /**
     * 查询车型管理
     * 
     * @param id 车型管理ID
     * @return 车型管理
     */
    public CarModel selectCarModelById(Long id);

    /**
     * 查询车型管理列表
     * 
     * @param carModel 车型管理
     * @return 车型管理集合
     */
    public List<CarModel> selectCarModelList(CarModel carModel);

    /**
     * 根据车品牌id查询所有车型
     * @param brandId 车品牌id
     * @return
     */
    public List<CarModel> selectCarModelListByBrandId(Long brandId);

    /**
     * 新增车型管理
     * 
     * @param carModel 车型管理
     * @return 结果
     */
    public int insertCarModel(CarModel carModel);

    /**
     * 修改车型管理
     * 
     * @param carModel 车型管理
     * @return 结果
     */
    public int updateCarModel(CarModel carModel);

    /**
     * 批量删除车型管理
     * 
     * @param ids 需要删除的车型管理ID
     * @return 结果
     */
    public int deleteCarModelByIds(Long[] ids);

    /**
     * 删除车型管理信息
     * 
     * @param id 车型管理ID
     * @return 结果
     */
    public int deleteCarModelById(Long id);
}
