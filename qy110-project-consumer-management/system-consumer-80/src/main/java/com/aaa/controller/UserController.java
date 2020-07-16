package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.service.SpringCloudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(value = "用户管理模块",tags = "用户管理模块")
public class UserController {

    @Autowired
    private SpringCloudService springCloudService;

    /**
     * 查询所有用户信息
     * @return
     */
    @GetMapping("/selectAllUser")
    @ApiOperation(value = "查询所有用户",notes = "<span style='color:red;'>描述：</span>查询所有用户")
    public ResultData selectAllUser(){
        return springCloudService.selectAllUser();
    }
}
