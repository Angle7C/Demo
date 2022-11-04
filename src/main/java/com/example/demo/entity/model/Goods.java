package com.example.demo.entity.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.TableGenerator;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class Goods implements Serializable {
    /**
     * 商品ID
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "商品ID")
    @TableId(type= IdType.AUTO)
    private String goodId;

    /**
     * 商品名
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "商品名")
    private String goodName;

    /**
     * 库存
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "库存")
    private Double num;

    /**
     * 价格
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "价格")
    private Double goodValue;

    /**
     * 描述
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "描述")
    private String info;

    /**
     * 商品类型
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "商品类型")
    private String types;

    /**
     * 产区
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "产区")
    private String zone;

    private static final long serialVersionUID = 1L;

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public Double getGoodValue() {
        return goodValue;
    }

    public void setGoodValue(Double goodValue) {
        this.goodValue = goodValue;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodId=").append(goodId);
        sb.append(", goodName=").append(goodName);
        sb.append(", num=").append(num);
        sb.append(", goodValue=").append(goodValue);
        sb.append(", info=").append(info);
        sb.append(", types=").append(types);
        sb.append(", zone=").append(zone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}