package com.ruoyi.car.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 停车位信息对象 car_part_space
 * 
 * @author timlis
 * @date 2021-01-08
 */
public class CarPartSpace extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Long partId;

    private Long spaceId;

    private Long carId;

    /** 状态，0:空闲，1:有车，2:被预定 */
    private Integer state;

    private Date startTime;

    private CarBaseInfo carBaseInfo;

    public CarPartSpace(){}

    public CarPartSpace(Long partId, Long spaceId) {
        this.partId = partId;
        this.spaceId = spaceId;
    }

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    public Long getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Long spaceId) {
        this.spaceId = spaceId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public CarBaseInfo getCarBaseInfo() {
        return carBaseInfo;
    }

    public void setCarBaseInfo(CarBaseInfo carBaseInfo) {
        this.carBaseInfo = carBaseInfo;
    }

    //将该车位设置位无车状态
    public void updateSpaceFree(){
        setStartTime(null);
        setState(0);
        setCarId(null);
    }

    public void updateSpaceBusy(CarOrder order,Long carId){
        if (order != null){
            setStartTime(order.getEndTime());
            setCarId(carId);
            setState(1);
        }else {
            setStartTime(new Date());
            setCarId(carId);
            setState(1);
        }
    }
}
