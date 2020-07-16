package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.service.SpringCloudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
@Api(value = "菜单管理模块",tags = "菜单管理模块")
public class MenuController {
    @Autowired
    private SpringCloudService springCloudService;

    /**
     * 查询所有菜单
     * @param userid
     * @return
     */

    @GetMapping("/selectAllMenu")
    @ApiOperation(value = "查询所有菜单",notes = "<span style='color:red;'>描述：</span>查询所有菜单")
    public ResultData  selectAllMenu(@RequestParam Long userid){
        return springCloudService.selectAllMenu(userid);
    }
}
