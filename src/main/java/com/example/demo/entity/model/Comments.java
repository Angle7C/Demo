package com.example.demo.entity.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Comments implements Serializable {
    /**
     * 评论ID
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "评论ID")
    private String commentsId;

    /**
     * 用户ID
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "用户ID")
    private String userId;

    /**
     * 商品ID
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "商品ID")
    private String goodsId;

    /**
     * 内容
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "内容")
    private String content;

    /**
     * 评论时间
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "评论时间")
    private Date times;

    private static final long serialVersionUID = 1L;

    public String getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(String commentsId) {
        this.commentsId = commentsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", commentsId=").append(commentsId);
        sb.append(", userId=").append(userId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", content=").append(content);
        sb.append(", times=").append(times);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}