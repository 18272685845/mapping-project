package com.aaa.controller;

import com.aaa.annotation.LoginAnnotation;
import com.aaa.base.ResultData;
import com.aaa.model.User;
import com.aaa.service.SpringCloudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Api(value = "登陆模块",tags = "登陆模块")
public class LoginController {

    @Autowired
    private SpringCloudService springCloudService;

    /**
     * 登陆操作
     * @param user
     * @return
     */
    @PostMapping("/doLogin")
    @LoginAnnotation(opeationType = "登陆操作", opeationName ="用户登陆" )
    @ApiOperation(value = "登陆操作",notes = "<span style='color:red;'>描述：</span>登陆操作")
    public ResultData doLogin(@RequestBody User user){
        return springCloudService.doLogin(user);
    }

}
