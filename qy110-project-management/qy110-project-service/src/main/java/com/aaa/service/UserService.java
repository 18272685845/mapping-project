package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.UserMapper;
import com.aaa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService  extends BaseService<User> {
    @Autowired
    private UserMapper userMapper;

    public List<User> selectAllUser(){
       return userMapper.selectAllUser();
    }
}
