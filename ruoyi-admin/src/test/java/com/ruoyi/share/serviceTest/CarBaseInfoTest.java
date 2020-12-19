package com.ruoyi.share.serviceTest;

import com.ruoyi.car.domain.CarBaseInfo;
import com.ruoyi.car.service.ICarBaseInfoService;
import com.ruoyi.share.ShareCarTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarBaseInfoTest extends ShareCarTest {

    @Autowired
    private ICarBaseInfoService carBaseInfoService;

    @Test
    public void testQueryAllCarNum() {
        List<CarBaseInfo> carBaseInfoList = carBaseInfoService.selectCarBaseInfoList(new CarBaseInfo());
        carBaseInfoList.forEach(carBaseInfo -> System.out.println(carBaseInfo.getCarNumber()));
    }
}
