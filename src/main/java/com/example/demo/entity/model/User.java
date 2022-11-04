package com.example.demo.entity.model;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable {
    /**
     * 用户ID
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "用户ID")
    private String userId;

    /**
     * 用户名
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "用户名")
    private String name;

    /**
     * 密码
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 图像ID
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "图像ID")
    private String imageId;

    /**
     * 权限
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "权限")
    private String roles;

    /**
     * 性别
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "性别")
    private String sex;

    /**
     * 邮箱
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    private static final long serialVersionUID = 1L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", name=").append(name);
        sb.append(", password=").append(password);
        sb.append(", imageId=").append(imageId);
        sb.append(", roles=").append(roles);
        sb.append(", sex=").append(sex);
        sb.append(", email=").append(email);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public Set<GrantedAuthority> getSet(){
        Set<GrantedAuthority> set=new HashSet<>();
        Arrays.stream(this.roles.split(",")).forEach((item)->{
            set.add(new SimpleGrantedAuthority(item));
        });
        return set;

    }
}