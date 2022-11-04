package com.example.demo.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.ObjectUtil;
import com.example.demo.entity.model.User;
import com.example.demo.entity.model.UserExample;
import com.example.demo.entity.model.UserPermission;
import com.example.demo.exception.MyException;
import com.example.demo.exception.enums.ErrorEnums;
import com.example.demo.mapper.UserExtMapper;
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
    private UserExtMapper userExtMapper;
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
        Assert.isNull(user,()->{
            throw new MyException(ErrorEnums.FIND_NULL.getCode(),"没有找到用户");
        });
        return user;
    }

    @Override
    public Boolean addUser(User user) {
        user.setUserId(UUID.fastUUID().toString());
        UserExample userExample = new UserExample();
        Assert.isFalse(0!=userExtMapper.selectEmailOrNameAndPassword(user),ErrorEnums.ADD_ERROR.getMessage());
        userMapper.insert(user);
        return true;
    }
    @Override
    public Boolean updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
        return true;
    }

    @Override
    public Boolean removeUser(String userId) {
        userMapper.deleteByPrimaryKey(userId);
        return true;
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
