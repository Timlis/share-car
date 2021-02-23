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

    public CarBaseInfo selectCarBaseInfoById(Long id);

    public CarBaseInfo selectCarBaseInfoByCarNumber(String CarNumber);

    public List<CarBaseInfo> selectCarBaseInfoList(CarBaseInfo carBaseInfo);

    public int replaceCarBaseInfo(CarBaseInfo carBaseInfo);

    public int deleteCarBaseInfoByIds(Long[] ids);

    public int deleteCarBaseInfoById(Long id);
}
