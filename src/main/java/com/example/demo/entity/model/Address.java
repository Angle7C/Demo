package com.example.demo.entity.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Address implements Serializable {
    /**
     * 地址ID
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "地址ID")
    private String addressId;

    /**
     * 用户ID
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "用户ID")
    private String userId;

    /**
     * 地址
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "地址")
    private String address;

    /**
     * 详细地址
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "详细地址")
    private String detiledInfo;

    /**
     * 手机
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "手机")
    private String phone;

    /**
     * 是不是默认
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "是不是默认")
    private Boolean defaultAddress;

    private static final long serialVersionUID = 1L;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetiledInfo() {
        return detiledInfo;
    }

    public void setDetiledInfo(String detiledInfo) {
        this.detiledInfo = detiledInfo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(Boolean defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", addressId=").append(addressId);
        sb.append(", userId=").append(userId);
        sb.append(", address=").append(address);
        sb.append(", detiledInfo=").append(detiledInfo);
        sb.append(", phone=").append(phone);
        sb.append(", defaultAddress=").append(defaultAddress);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}