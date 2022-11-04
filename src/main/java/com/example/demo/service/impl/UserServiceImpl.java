package com.example.demo.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.ObjectUtil;
import com.example.demo.entity.model.User;
import com.example.demo.entity.model.UserExample;
import com.example.demo.entity.model.UserPermission;
import com.example.demo.exception.MyException;
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
    public UserDetails hasUser(String userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        if (ObjectUtil.isEmpty(user)) {
            return null;
        }
        UserPermission userPermission=new UserPermission();
        userPermission.setUserId(user.getUserId());
        userPermission.setPassWord(user.getPassword());
        userPermission.setAuthoritySet(user.getSet());
        return  userPermission;
    }

    @Override
    public User selectUser(String userId) {
        User user=userMapper.selectByPrimaryKey(userId);
        return user;
    }

    @Override
    public Boolean addUser(User user) {
        userMapper.insert(user);
        return true;
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
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if(Validator.isEmail(username)){
            criteria.andEmailEqualTo(username);
        }else{
            criteria.andNameEqualTo(username);
        }
        criteria.andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(userExample);
        if(users.size()<1) throw new MyException(110,"没有这个用户");
        User user = users.get(0);
        return jwtTokenUtil.getToken(user);
    }
}
