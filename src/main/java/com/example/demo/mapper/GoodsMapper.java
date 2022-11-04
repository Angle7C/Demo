package com.example.demo.mapper;

import com.example.demo.entity.model.Goods;
import com.example.demo.entity.model.GoodsExample;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsMapper {
    long countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(String goodId);

    int insert(Goods row);

    int insertSelective(Goods row);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(String goodId);

    int updateByExampleSelective(@Param("row") Goods row, @Param("example") GoodsExample example);

    int updateByExample(@Param("row") Goods row, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods row);

    int updateByPrimaryKey(Goods row);
}