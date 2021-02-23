package com.ruoyi.car.domain;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 计费管理对象 car_billing
 * 
 * @author timlis
 * @date 2021-01-29
 */
public class CarBilling extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Long modelId;

    @Excel(name = "每公里花费")
    private Double kmCost;

    @Excel(name = "每分钟花费")
    private Double minCost;

    @Excel(name = "当包日的时候，每天计费")
    private Double dayCost;

    private Long brandId;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public void setModelId(Long modelId)
    {
        this.modelId = modelId;
    }

    public Long getModelId() 
    {
        return modelId;
    }
    public void setKmCost(Double kmCost) 
    {
        this.kmCost = kmCost;
    }

    public Double getKmCost() 
    {
        return kmCost;
    }
    public void setMinCost(Double minCost) 
    {
        this.minCost = minCost;
    }

    public Double getMinCost() 
    {
        return minCost;
    }
    public void setDayCost(Double dayCost) 
    {
        this.dayCost = dayCost;
    }

    public Double getDayCost() 
    {
        return dayCost;
    }

}
