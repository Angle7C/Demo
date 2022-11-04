package com.example.demo.service;

import cn.hutool.Hutool;
import cn.hutool.core.lang.Validator;
import com.example.demo.entity.model.User;
import com.example.demo.entity.model.UserExample;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.Resource;

public interface UserService {

    default UserDetails hasUser(String userId){

        return null;
    }
    default User selectUser(String userId){
        return null;
    }
    default Boolean addUser(User user){
        return false;
    }
    default Boolean updateUser(User user){
        return false;
    }
    default Boolean removeUser(String userId){
        return false;
    }
    default String login(String username,String password){

        return null;
    }
}
