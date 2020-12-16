package com.ruoyi.car.mapper;

import java.util.List;
import com.ruoyi.car.domain.CarModel;

/**
 * 车型管理Mapper接口
 * 
 * @author timlis
 * @date 2020-12-02
 */
public interface CarModelMapper 
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
     * 删除车型管理
     * 
     * @param id 车型管理ID
     * @return 结果
     */
    public int deleteCarModelById(Long id);

    /**
     * 批量删除车型管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCarModelByIds(Long[] ids);

    /**
     * 根据车品牌id查询所有车型
     * @param brandId 车品牌id
     * @return
     */
    List<CarModel> selectCarModelListByBrandId(Long brandId);
}
