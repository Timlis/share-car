package com.ruoyi.car.mapper;

import java.util.List;
import com.ruoyi.car.domain.CarOrder;

/**
 * 车辆订单Mapper接口
 * 
 * @author timlis
 * @date 2021-01-29
 */
public interface CarOrderMapper 
{

     CarOrder selectCarOrderById(Long orderId);

     List<CarOrder> selectCarOrderList(CarOrder carOrder);

     int countInAndOutByPartId(Integer partId, Integer status);

     int replaceCarOrder(CarOrder carOrder);

     int insertCarOrder(CarOrder carOrder);

     int updateCarOrder(CarOrder carOrder);

     int deleteCarOrderById(Long orderId);

     int deleteCarOrderByIds(Long[] orderIds);
}
