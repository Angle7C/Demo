package com.example.demo.entity.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Images implements Serializable {
    /**
     * 图片ID
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "图片ID")
    private String imageId;

    /**
     * 相对路径
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "相对路径")
    private String path;

    private static final long serialVersionUID = 1L;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", imageId=").append(imageId);
        sb.append(", path=").append(path);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}