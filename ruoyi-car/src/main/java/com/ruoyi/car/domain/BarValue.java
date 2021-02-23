package com.ruoyi.car.domain;

public class BarValue {
    private String name;
    private Float[] data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float[] getData() {
        return data;
    }

    public void setData(Float[] data) {
        this.data = data;
    }

    public BarValue() {
    }

    public BarValue(String name, Float[] data) {
        this.name = name;
        this.data = data;
    }
}
