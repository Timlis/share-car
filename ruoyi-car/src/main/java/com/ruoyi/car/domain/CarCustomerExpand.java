package com.ruoyi.car.domain;


import com.ruoyi.common.annotation.Excel;


import java.math.BigDecimal;

/**
 * 用户扩展信息对象 car_customer_expand
 * 
 * @author timlis
 * @date 2020-11-28
 */
public class CarCustomerExpand extends CarCustomer
{
    private static final long serialVersionUID = 1L;


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
    private BigDecimal nowBalance;

    /** 信用积分 */
    @Excel(name = "信用积分")
    private Long creditScore;

    //用户总里程
    @Excel(name = "总里程")
    private Long totalMileage;

    public Long getTotalMileage() {
        return totalMileage;
    }

    public void setTotalMileage(Long totalMileage) {
        this.totalMileage = totalMileage;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
    public void setNowBalance(BigDecimal nowBalance)
    {
        this.nowBalance = nowBalance;
    }

    public BigDecimal getNowBalance()
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


    public void updateTotalMileage(Long mileage){
        setTotalMileage(getTotalMileage() + mileage);
    }

    public void updateUseTimes(Long times){
        setUseTimes(getUseTimes() + times);
    }

    public void updateNowBalance(BigDecimal balance){
        setNowBalance(getNowBalance().subtract(balance));
    }

    public void updateCreditScore(Long creditScore){

        setCreditScore(getCreditScore() + creditScore);
    }

}
