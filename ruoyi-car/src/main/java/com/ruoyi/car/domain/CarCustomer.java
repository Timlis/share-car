package com.ruoyi.car.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客户管理对象 car_customer
 * 
 * @author Timlis
 * @date 2020-11-24
 */
public class CarCustomer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 用户姓名 */
    @Excel(name = "用户姓名")
    private String name;

    /** 用户身份证 */
    @Excel(name = "用户身份证")
    private String idCard;

    /** 用户电话 */
    @Excel(name = "用户电话")
    private String phone;

    /** 用户性别 */
    @Excel(name = "用户性别")
    private Integer sex;

    /** 用户年龄 */
    @Excel(name = "用户年龄")
    private Long age;

    /** 获取驾照时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "获取驾照时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date driverDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setIdCard(String idCard) 
    {
        this.idCard = idCard;
    }

    public String getIdCard() 
    {
        return idCard;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setSex(Integer sex) 
    {
        this.sex = sex;
    }

    public Integer getSex() 
    {
        return sex;
    }
    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }
    public void setDriverDate(Date driverDate) 
    {
        this.driverDate = driverDate;
    }

    public Date getDriverDate() 
    {
        return driverDate;
    }

    public CarCustomer() {
    }

    public CarCustomer(Long id, String name, String idCard, String phone, Integer sex, Long age, Date driverDate) {
        this.id = id;
        this.name = name;
        this.idCard = idCard;
        this.phone = phone;
        this.sex = sex;
        this.age = age;
        this.driverDate = driverDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("idCard", getIdCard())
            .append("phone", getPhone())
            .append("sex", getSex())
            .append("age", getAge())
            .append("driverDate", getDriverDate())
            .toString();
    }
}
