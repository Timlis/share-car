package com.ruoyi.car.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户扩展信息对象 car_customer_expand
 * 
 * @author timlis
 * @date 2020-11-28
 */
public class CarCustomerExpand extends CarCustomer
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long customerId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String customerName;

    /** 是否缴纳押金 */
    @Excel(name = "是否缴纳押金")
    private String isPay;

    /** 驾照分数 */
    @Excel(name = "驾照分数")
    private Long carScore;

    /** 用车总时长/分钟 */
    @Excel(name = "用车总时长/分钟")
    private Long useTimes;

    /** 违章次数 */
    @Excel(name = "违章次数")
    private Long violationsNum;

    /** 当前余额 */
    @Excel(name = "当前余额")
    private Long nowBalance;

    /** 信用积分 */
    @Excel(name = "信用积分")
    private Long creditScore;


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCustomerId(Long customerId) 
    {
        this.customerId = customerId;
    }

    public Long getCustomerId() 
    {
        return customerId;
    }
    public void setIsPay(String isPay) 
    {
        this.isPay = isPay;
    }

    public String getIsPay() 
    {
        return isPay;
    }
    public void setCarScore(Long carScore) 
    {
        this.carScore = carScore;
    }

    public Long getCarScore() 
    {
        return carScore;
    }
    public void setUseTimes(Long useTimes) 
    {
        this.useTimes = useTimes;
    }

    public Long getUseTimes() 
    {
        return useTimes;
    }
    public void setViolationsNum(Long violationsNum) 
    {
        this.violationsNum = violationsNum;
    }

    public Long getViolationsNum() 
    {
        return violationsNum;
    }
    public void setNowBalance(Long nowBalance) 
    {
        this.nowBalance = nowBalance;
    }

    public Long getNowBalance() 
    {
        return nowBalance;
    }
    public void setCreditScore(Long creditScore) 
    {
        this.creditScore = creditScore;
    }

    public Long getCreditScore() 
    {
        return creditScore;
    }

    public CarCustomerExpand() {
    }

    public CarCustomerExpand(CarCustomer carCustomer) {
        super(carCustomer.getId(),carCustomer.getName(),
                carCustomer.getIdCard(),carCustomer.getPhone(),
                carCustomer.getSex(),carCustomer.getAge(),
                carCustomer.getDriverDate());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("customerId", getCustomerId())
            .append("isPay", getIsPay())
            .append("carScore", getCarScore())
            .append("useTimes", getUseTimes())
            .append("violationsNum", getViolationsNum())
            .append("nowBalance", getNowBalance())
            .append("creditScore", getCreditScore())
            .toString();
    }
}
