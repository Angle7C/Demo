package com.example.demo.entity.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Shelves implements Serializable {
    /**
     * 订单 ID
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "订单 ID")
    private Integer shelvesId;

    /**
     * 商品ID
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "商品ID")
    private Integer goodsId;

    /**
     * 折扣
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "折扣")
    private String discount;

    /**
     * 数量
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "数量")
    private Double num;

    /**
     * 上架时间
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "上架时间")
    private Date times;

    /**
     * 介绍贴图
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "介绍贴图")
    private String imageIds;

    private static final long serialVersionUID = 1L;

    public Integer getShelvesId() {
        return shelvesId;
    }

    public void setShelvesId(Integer shelvesId) {
        this.shelvesId = shelvesId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    public String getImageIds() {
        return imageIds;
    }

    public void setImageIds(String imageIds) {
        this.imageIds = imageIds;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", shelvesId=").append(shelvesId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", discount=").append(discount);
        sb.append(", num=").append(num);
        sb.append(", times=").append(times);
        sb.append(", imageIds=").append(imageIds);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}