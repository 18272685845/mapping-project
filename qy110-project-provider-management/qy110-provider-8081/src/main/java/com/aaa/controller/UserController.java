package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.User;
import com.aaa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController extends CommonController<User> {

    @Autowired
    private UserService userService;
    @Override
    public BaseService<User> getBaseService() {
        return userService;
    }
    /**
     * 查询所有用户信息
     * @return
     */
    @GetMapping("/selectAllUser")
    public ResultData selectAllUser(){
        List<User> userList = userService.selectAllUser();
        if (userList != null ){
            return selectSuccess(userList);
        }
        return selectFailed();
    }
}
