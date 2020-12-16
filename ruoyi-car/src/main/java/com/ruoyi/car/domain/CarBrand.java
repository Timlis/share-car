package com.ruoyi.car.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 品牌管理对象 car_brand
 * 
 * @author timlis
 * @date 2020-12-01
 */
public class CarBrand extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 品牌 */
    @Excel(name = "品牌")
    private String brand;

    /** 品牌图标地址 */
    @Excel(name = "品牌图标地址")
    private String brandPic;

    /** 品牌对对多种车型*/
    private List<CarModel> modelList;

    public List<CarModel> getModelList() {
        return modelList;
    }

    public void setModelList(List<CarModel> modelList) {
        this.modelList = modelList;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBrand(String brand) 
    {
        this.brand = brand;
    }

    public String getBrand() 
    {
        return brand;
    }
    public void setBrandPic(String brandPic) 
    {
        this.brandPic = brandPic;
    }

    public String getBrandPic() 
    {
        return brandPic;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("brand", getBrand())
            .append("brandPic", getBrandPic())
            .toString();
    }
}
