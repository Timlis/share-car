package com.ruoyi.car.service;

import java.util.List;
import com.ruoyi.car.domain.CarBaseInfo;

/**
 * 基本信息Service接口
 * 
 * @author timlis
 * @date 2020-12-02
 */
public interface ICarBaseInfoService 
{
    /**
     * 查询基本信息
     * 
     * @param id 基本信息ID
     * @return 基本信息
     */
    public CarBaseInfo selectCarBaseInfoById(Long id);

    /**
     * 查询基本信息列表
     * 
     * @param carBaseInfo 基本信息
     * @return 基本信息集合
     */
    public List<CarBaseInfo> selectCarBaseInfoList(CarBaseInfo carBaseInfo);

    /**
     * 新增基本信息
     * 
     * @param carBaseInfo 基本信息
     * @return 结果
     */
    public int insertCarBaseInfo(CarBaseInfo carBaseInfo);

    /**
     * 修改基本信息
     * 
     * @param carBaseInfo 基本信息
     * @return 结果
     */
    public int updateCarBaseInfo(CarBaseInfo carBaseInfo);

    /**
     * 批量删除基本信息
     * 
     * @param ids 需要删除的基本信息ID
     * @return 结果
     */
    public int deleteCarBaseInfoByIds(Long[] ids);

    /**
     * 删除基本信息信息
     * 
     * @param id 基本信息ID
     * @return 结果
     */
    public int deleteCarBaseInfoById(Long id);
}
