package com.example.demo.entity.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Video implements Serializable {
    /**
     * 视频ID
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "视频ID")
    private String videoId;

    /**
     * 相对路径
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "相对路径")
    private String path;

    private static final long serialVersionUID = 1L;

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
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
        sb.append(", videoId=").append(videoId);
        sb.append(", path=").append(path);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}