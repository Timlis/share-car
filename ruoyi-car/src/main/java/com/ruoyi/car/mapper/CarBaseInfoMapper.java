package com.ruoyi.car.mapper;

import java.util.List;
import com.ruoyi.car.domain.CarBaseInfo;

/**
 * 基本信息Mapper接口
 * 
 * @author timlis
 * @date 2020-12-02
 */
public interface CarBaseInfoMapper 
{

    public CarBaseInfo selectCarBaseInfoById(Long id);

    public Long CountCarByModelId(Long model_id);

    public List<CarBaseInfo> selectCarBaseInfoList(CarBaseInfo carBaseInfo);

    public int replaceCarBaseInfo(CarBaseInfo carBaseInfo);

    public int deleteCarBaseInfoById(Long id);

    public int deleteCarBaseInfoByIds(Long[] ids);

    CarBaseInfo selectCarBaseInfoByCarNumber(String carNumber);
}
