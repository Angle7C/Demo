package com.example.demo.service;

import com.example.demo.entity.model.User;
import com.example.demo.exception.MyException;
import com.example.demo.exception.enums.ErrorEnums;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.Resource;

public interface UserService {

    default UserDetails hasUser(String userId){

        return null;
    }
    default User selectUser(String userId){
        throw new MyException(ErrorEnums.FIND_NULL);
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
