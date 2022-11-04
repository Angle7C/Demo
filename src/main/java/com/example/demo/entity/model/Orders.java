package com.example.demo.entity.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Orders implements Serializable {
    /**
     * 订单ID
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "订单ID")
    private String ordersId;

    /**
     * 商品ID
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "商品ID")
    private String goodsId;

    /**
     * 用户ID
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "用户ID")
    private String userId;

    /**
     * 数量
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "数量")
    private Double num;

    /**
     * 订单时间
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "订单时间")
    private Date times;

    /**
     * 总价
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "总价")
    private Double totalValue;

    private static final long serialVersionUID = 1L;

    public String getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(String ordersId) {
        this.ordersId = ordersId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ordersId=").append(ordersId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", userId=").append(userId);
        sb.append(", num=").append(num);
        sb.append(", times=").append(times);
        sb.append(", totalValue=").append(totalValue);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}