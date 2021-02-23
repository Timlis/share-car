package com.ruoyi.car.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 基本信息对象 car_base_info
 *
 * @author timlis
 * @date 2020-12-02
 */
public class CarBaseInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    private Long id;

    /**
     * 车牌号
     */
    @Excel(name = "车牌号")
    private String carNumber;

    /**
     * 品牌id
     */
    @Excel(name = "品牌id")
    private Long brandId;

    /**
     * 车型id
     */
    @Excel(name = "车型id")
    private Long modelId;

    /**
     * 购入时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "购入时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date buyTime;

    /**
     * 当前电量/千瓦时
     */
    @Excel(name = "当前电量/千瓦时")
    private Long curBattery;

    /**
     * 购入价格
     */
    @Excel(name = "购入价格")
    private BigDecimal buyPrice;

    /**
     * 使用状态
     */
    @Excel(name = "使用状态")
    private Long useState;

    /**
     * 图片地址
     */
    @Excel(name = "图片地址")
    private String pic;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private Long state;

    private Long partId;

    private Long spaceId;

    /**
     * 总里程/公里
     */
    @Excel(name = "总里程/公里")
    private Long totalMileage;

    /**
     * 总使用时长
     */
    @Excel(name = "总使用时长")
    private Long totalTime;

    private CarModel carModel;

    //当前剩余续航，计算公式得出
    private Long curEndurance;

    public Long getCurEndurance() {
        return curEndurance;
    }

    public void setCurEndurance(Long curEndurance) {
        this.curEndurance = curEndurance;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Long getModelId() {
        return modelId;
    }


    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    public Long getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Long spaceId) {
        this.spaceId = spaceId;
    }

    public void setCurBattery(Long curBattery) {
        this.curBattery = curBattery;
    }

    public Long getCurBattery() {
        return curBattery;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setUseState(Long useState) {
        this.useState = useState;
    }

    public Long getUseState() {
        return useState;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic() {
        return pic;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public Long getState() {
        return state;
    }

    public void setTotalMileage(Long totalMileage) {
        this.totalMileage = totalMileage;
    }

    public Long getTotalMileage() {
        return totalMileage;
    }

    public void setTotalTime(Long totalTime) {
        this.totalTime = totalTime;
    }

    public Long getTotalTime() {
        return totalTime;
    }

    @Override
    public String toString() {
        return "CarBaseInfo{" +
                "id=" + id +
                ", carNumber='" + carNumber + '\'' +
                ", brandId=" + brandId +
                ", modelId=" + modelId +
                ", buyTime=" + buyTime +
                ", curBattery=" + curBattery +
                ", buyPrice=" + buyPrice +
                ", useState=" + useState +
                ", pic='" + pic + '\'' +
                ", state=" + state +
                ", partId=" + partId +
                ", spaceId=" + spaceId +
                ", totalMileage=" + totalMileage +
                ", totalTime=" + totalTime +
                ", carModel=" + carModel +
                ", curEndurance=" + curEndurance +
                '}';
    }
}
