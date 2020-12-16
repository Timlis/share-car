package com.ruoyi.car.domain;

public class CountNums {
    private Integer countCustomer;
    private Integer countCar;
    private Integer countMoney;
    private Integer countOrder;

    public Integer getCountCustomer() {
        return countCustomer;
    }

    public void setCountCustomer(Integer countCustomer) {
        this.countCustomer = countCustomer;
    }

    public Integer getCountCar() {
        return countCar;
    }

    public void setCountCar(Integer countCar) {
        this.countCar = countCar;
    }

    public Integer getCountMoney() {
        return countMoney;
    }

    public void setCountMoney(Integer countMoney) {
        this.countMoney = countMoney;
    }

    public Integer getCountOrder() {
        return countOrder;
    }

    public void setCountOrder(Integer countOrder) {
        this.countOrder = countOrder;
    }

    public CountNums() {
    }

    public CountNums(Integer countCustomer, Integer countCar, Integer countMoney, Integer countOrder) {
        this.countCustomer = countCustomer;
        this.countCar = countCar;
        this.countMoney = countMoney;
        this.countOrder = countOrder;
    }
}
