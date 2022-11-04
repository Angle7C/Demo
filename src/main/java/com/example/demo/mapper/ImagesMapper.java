package com.example.demo.mapper;

import com.example.demo.entity.model.Images;
import com.example.demo.entity.model.ImagesExample;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImagesMapper {
    long countByExample(ImagesExample example);

    int deleteByExample(ImagesExample example);

    int deleteByPrimaryKey(String imageId);

    int insert(Images row);

    int insertSelective(Images row);

    List<Images> selectByExample(ImagesExample example);

    Images selectByPrimaryKey(String imageId);

    int updateByExampleSelective(@Param("row") Images row, @Param("example") ImagesExample example);

    int updateByExample(@Param("row") Images row, @Param("example") ImagesExample example);

    int updateByPrimaryKeySelective(Images row);

    int updateByPrimaryKey(Images row);
}