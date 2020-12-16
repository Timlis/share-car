package com.ruoyi.car.service.impl;

import java.util.List;

import com.ruoyi.car.domain.CarModel;
import com.ruoyi.car.mapper.CarModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.car.mapper.CarBaseInfoMapper;
import com.ruoyi.car.domain.CarBaseInfo;
import com.ruoyi.car.service.ICarBaseInfoService;

/**
 * 基本信息Service业务层处理
 *
 * @author timlis
 * @date 2020-12-02
 */
@Service
public class CarBaseInfoServiceImpl implements ICarBaseInfoService {
    @Autowired
    private CarBaseInfoMapper carBaseInfoMapper;

    @Autowired
    private CarModelMapper carModelMapper;

    /**
     * 查询基本信息
     *
     * @param id 基本信息ID
     * @return 基本信息
     */
    @Override
    public CarBaseInfo selectCarBaseInfoById(Long id) {
        CarBaseInfo carBaseInfo = carBaseInfoMapper.selectCarBaseInfoById(id);
        //每辆具体车绑定一个车型
        carBaseInfo.setCarModel(carModelMapper.selectCarModelById(carBaseInfo.getModelId()));
        return carBaseInfo;
    }

    /**
     * 查询基本信息列表
     *
     * @param carBaseInfo 基本信息
     * @return 基本信息
     */
    @Override
    public List<CarBaseInfo> selectCarBaseInfoList(CarBaseInfo carBaseInfo) {
        List<CarBaseInfo> carBaseInfos = carBaseInfoMapper.selectCarBaseInfoList(carBaseInfo);
        carBaseInfos.forEach(carInfo -> carInfo.setCarModel(carModelMapper.selectCarModelById(carInfo.getModelId())));
        return carBaseInfos;
    }

    /**
     * 新增基本信息
     *
     * @param carBaseInfo 基本信息
     * @return 结果
     */
    @Override
    public int insertCarBaseInfo(CarBaseInfo carBaseInfo) {
        CarModel carModel = carModelMapper.selectCarModelById(carBaseInfo.getModelId());
        carModel.setCarNumber(carBaseInfoMapper.CountCarByModelId(carBaseInfo.getModelId()) + 1);
        carModelMapper.updateCarModel(carModel);
        return carBaseInfoMapper.insertCarBaseInfo(carBaseInfo);
    }

    /**
     * 修改基本信息
     *
     * @param carBaseInfo 基本信息
     * @return 结果
     */
    @Override
    public int updateCarBaseInfo(CarBaseInfo carBaseInfo) {
        return carBaseInfoMapper.updateCarBaseInfo(carBaseInfo);
    }

    /**
     * 批量删除基本信息
     *
     * @param ids 需要删除的基本信息ID
     * @return 结果
     */
    @Override
    public int deleteCarBaseInfoByIds(Long[] ids) {
        return carBaseInfoMapper.deleteCarBaseInfoByIds(ids);
    }

    /**
     * 删除基本信息信息
     *
     * @param id 基本信息ID
     * @return 结果
     */
    @Override
    public int deleteCarBaseInfoById(Long id) {
        return carBaseInfoMapper.deleteCarBaseInfoById(id);
    }
}
