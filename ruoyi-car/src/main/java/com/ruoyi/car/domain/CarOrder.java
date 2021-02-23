package com.ruoyi.car.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 车辆订单对象 car_order
 * 
 * @author timlis
 * @date 2021-01-29
 */
public class CarOrder
{
    private static final long serialVersionUID = 1L;

    private Long orderId;

    @Excel(name = "车辆id")
    private Long carId;

    @Excel(name = "用户id")
    private Long customerId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "订单开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "订单结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    @Excel(name = "开始地点停车场")
    private Long startPlaceId;

    @Excel(name = "结束地点停车场")
    private Long endPlaceId;

    @Excel(name = "金额/元")
    private BigDecimal cost;

    @Excel(name = "里程/km")
    private Long mileage;

    private Integer state;

    private Long curBattery;

    private Long spaceId;

    private CarBaseInfo car;

    private CarCustomer customer;

    public Long getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Long spaceId) {
        this.spaceId = spaceId;
    }

    public CarBaseInfo getCar() {
        return car;
    }

    public Long getCurBattery() {
        return curBattery;
    }

    public void setCurBattery(Long curBattery) {
        this.curBattery = curBattery;
    }

    public void setCar(CarBaseInfo car) {
        this.car = car;
    }

    public CarCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(CarCustomer customer) {
        this.customer = customer;
    }

    public void setOrderId(Long orderId)
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setCarId(Long carId) 
    {
        this.carId = carId;
    }

    public Long getCarId() 
    {
        return carId;
    }
    public void setCustomerId(Long customerId) 
    {
        this.customerId = customerId;
    }

    public Long getCustomerId() 
    {
        return customerId;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }
    public void setStartPlaceId(Long startPlaceId) 
    {
        this.startPlaceId = startPlaceId;
    }

    public Long getStartPlaceId() 
    {
        return startPlaceId;
    }
    public void setEndPlaceId(Long endPlaceId) 
    {
        this.endPlaceId = endPlaceId;
    }

    public Long getEndPlaceId() 
    {
        return endPlaceId;
    }
    public void setCost(BigDecimal cost) 
    {
        this.cost = cost;
    }

    public BigDecimal getCost() 
    {
        return cost;
    }
    public void setMileage(Long mileage) 
    {
        this.mileage = mileage;
    }

    public Long getMileage() 
    {
        return mileage;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "CarOrder{" +
                "orderId=" + orderId +
                ", carId=" + carId +
                ", customerId=" + customerId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", startPlaceId=" + startPlaceId +
                ", endPlaceId=" + endPlaceId +
                ", cost=" + cost +
                ", mileage=" + mileage +
                ", state=" + state +
                ", curBattery=" + curBattery +
                ", spaceId=" + spaceId +
                ", car=" + car +
                ", customer=" + customer +
                '}';
    }
}
