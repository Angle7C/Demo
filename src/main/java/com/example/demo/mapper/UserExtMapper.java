package com.example.demo.mapper;

import com.example.demo.entity.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserExtMapper {
    public Integer selectEmailOrNameAndPassword(User user);
}
