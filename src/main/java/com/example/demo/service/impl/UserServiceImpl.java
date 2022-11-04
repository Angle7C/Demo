package com.example.demo.service.impl;

import cn.hutool.jwt.JWTUtil;
import com.example.demo.entity.dto.AdminUserDetails;
import com.example.demo.entity.model.User;
import com.example.demo.entity.model.UserExample;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.example.demo.utils.JwtTokenUtil;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Override
    public UserDetails hasUser(String userName) {
//        var example= new UserExample();
//        example.createCriteria().andUserNameEqualTo(userName);
//        User user=userMapper.selectByExample(example).get(0);
//        UserDetails userDetails= new AdminUserDetails(user.getUserName(),user.getUserPassword(),null);
//        return userDetails;
        return  null;
    }

    @Override
    public User selectUser(String userId) {
        User user=userMapper.selectByPrimaryKey(userId);
        return user;
    }

    @Override
    public Boolean addUser(User user) {

        return null;
    }

    @Override
    public Boolean updateUser(User user) {
        return null;
    }

    @Override
    public Boolean removeUser(String userId) {
        return null;
    }

    @Override
    public String login(String username, String password) {
       return null;
    }
}
