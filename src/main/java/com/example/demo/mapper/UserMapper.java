package com.example.demo.mapper;

import com.example.demo.entity.model.User;
import com.example.demo.entity.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User row);

    int insertSelective(User row);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("row") User row, @Param("example") UserExample example);

    int updateByExample(@Param("row") User row, @Param("example") UserExample example);
}