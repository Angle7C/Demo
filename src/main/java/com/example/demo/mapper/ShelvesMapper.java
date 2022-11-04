package com.example.demo.mapper;

import com.example.demo.entity.model.Shelves;
import com.example.demo.entity.model.ShelvesExample;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShelvesMapper {
    long countByExample(ShelvesExample example);

    int deleteByExample(ShelvesExample example);

    int deleteByPrimaryKey(Integer shelvesId);

    int insert(Shelves row);

    int insertSelective(Shelves row);

    List<Shelves> selectByExample(ShelvesExample example);

    Shelves selectByPrimaryKey(Integer shelvesId);

    int updateByExampleSelective(@Param("row") Shelves row, @Param("example") ShelvesExample example);

    int updateByExample(@Param("row") Shelves row, @Param("example") ShelvesExample example);

    int updateByPrimaryKeySelective(Shelves row);

    int updateByPrimaryKey(Shelves row);
}