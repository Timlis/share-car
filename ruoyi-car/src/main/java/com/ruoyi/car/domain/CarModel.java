package com.ruoyi.car.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 车型管理对象 car_model
 * 
 * @author timlis
 * @date 2020-12-02
 */
public class CarModel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 品牌id */
    @Excel(name = "品牌id")
    private Long brandId;

    /** 品牌名 */
    @Excel(name = "所属品牌")
    private String brandName;

    /** 型号 */
    @Excel(name = "型号")
    private String model;

    /** 车款图片 */
    @Excel(name = "车款图片")
    private String modelPic;

    /** 限座/人 */
    @Excel(name = "限座/人")
    private Integer capacity;

    /** 电池容量/千瓦时 */
    @Excel(name = "电池容量/千瓦时")
    private Long battery;

    /** 发行价/万元 */
    @Excel(name = "发行价/万元")
    private BigDecimal firstPrice;

    /** 数量 */
    @Excel(name = "数量")
    private Long carNumber;

    /** 续航/公里 */
    @Excel(name = "续航/公里")
    private Long endurance;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBrandId(Long brandId) 
    {
        this.brandId = brandId;
    }

    public Long getBrandId() 
    {
        return brandId;
    }
    public void setModel(String model) 
    {
        this.model = model;
    }

    public String getModel() 
    {
        return model;
    }
    public void setModelPic(String modelPic) 
    {
        this.modelPic = modelPic;
    }

    public String getModelPic() 
    {
        return modelPic;
    }
    public void setCapacity(Integer capacity) 
    {
        this.capacity = capacity;
    }

    public Integer getCapacity() 
    {
        return capacity;
    }
    public void setBattery(Long battery) 
    {
        this.battery = battery;
    }

    public Long getBattery() 
    {
        return battery;
    }
    public void setFirstPrice(BigDecimal firstPrice) 
    {
        this.firstPrice = firstPrice;
    }

    public BigDecimal getFirstPrice() 
    {
        return firstPrice;
    }
    public void setCarNumber(Long carNumber) 
    {
        this.carNumber = carNumber;
    }

    public Long getCarNumber() 
    {
        return carNumber;
    }
    public void setEndurance(Long endurance) 
    {
        this.endurance = endurance;
    }

    public Long getEndurance() 
    {
        return endurance;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("brandId", getBrandId())
            .append("model", getModel())
            .append("modelPic", getModelPic())
            .append("capacity", getCapacity())
            .append("battery", getBattery())
            .append("firstPrice", getFirstPrice())
            .append("carNumber", getCarNumber())
            .append("endurance", getEndurance())
            .toString();
    }
}
