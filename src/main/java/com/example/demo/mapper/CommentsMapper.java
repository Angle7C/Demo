package com.example.demo.mapper;

import com.example.demo.entity.model.Comments;
import com.example.demo.entity.model.CommentsExample;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentsMapper {
    long countByExample(CommentsExample example);

    int deleteByExample(CommentsExample example);

    int deleteByPrimaryKey(String commentsId);

    int insert(Comments row);

    int insertSelective(Comments row);

    List<Comments> selectByExample(CommentsExample example);

    Comments selectByPrimaryKey(String commentsId);

    int updateByExampleSelective(@Param("row") Comments row, @Param("example") CommentsExample example);

    int updateByExample(@Param("row") Comments row, @Param("example") CommentsExample example);

    int updateByPrimaryKeySelective(Comments row);

    int updateByPrimaryKey(Comments row);
}