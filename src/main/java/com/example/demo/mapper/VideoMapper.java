package com.example.demo.mapper;

import com.example.demo.entity.model.Video;
import com.example.demo.entity.model.VideoExample;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoMapper {
    long countByExample(VideoExample example);

    int deleteByExample(VideoExample example);

    int deleteByPrimaryKey(String videoId);

    int insert(Video row);

    int insertSelective(Video row);

    List<Video> selectByExample(VideoExample example);

    Video selectByPrimaryKey(String videoId);

    int updateByExampleSelective(@Param("row") Video row, @Param("example") VideoExample example);

    int updateByExample(@Param("row") Video row, @Param("example") VideoExample example);

    int updateByPrimaryKeySelective(Video row);

    int updateByPrimaryKey(Video row);
}