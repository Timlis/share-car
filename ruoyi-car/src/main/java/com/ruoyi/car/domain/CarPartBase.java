package com.ruoyi.car.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 停车场的基本信息对象 car_part_base
 * 
 * @author timlis
 * @date 2020-12-19
 */
public class CarPartBase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Integer id;

    /** 车场名 */
    private String name;

    /** 经度 */
    @Excel(name = "经度")
    private String longitude;

    /** 纬度 */
    @Excel(name = "纬度")
    private String latitude;

    /** 总数量 */
    @Excel(name = "总数量")
    private Integer totalNums;



    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLongitude(String longitude)
    {
        this.longitude = longitude;
    }

    public String getLongitude()
    {
        return longitude;
    }
    public void setLatitude(String latitude)
    {
        this.latitude = latitude;
    }

    public String getLatitude()
    {
        return latitude;
    }
    public void setTotalNums(Integer totalNums)
    {
        this.totalNums = totalNums;
    }

    public Integer getTotalNums()
    {
        return totalNums;
    }




    @Override
    public String toString() {
        return "CarPartBase{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", totalNums=" + totalNums +
                '}';
    }
}
