package com.example.demo.service;

import com.example.demo.entity.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    default UserDetails hasUser(String userName){
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
