package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.model.Menu;
import com.aaa.service.SpringCloudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 王登辉
 * @date 2020/7/16
 *
**/
@RestController
@RequestMapping("/menu")
@Api(value = "菜单管理模块",tags = "菜单管理模块")
public class MenuController {

    @Autowired
    private SpringCloudService springCloudService;
    /**
     *  查询所有菜单
     * @return
     */
    @GetMapping("/selectAllMenu")
    @ApiOperation(value = "查询所有菜单",notes = "<span style='color:red;'>描述：</span>查询所有菜单")
    private ResultData selectAllMenu(){
        return springCloudService.selectAllMenu();
    }

    /**
     *      修改菜单
     * @param menu
     * @return
     */
    @PostMapping("/updateMenu")
    @ApiOperation(value = "修改菜单",notes = "<span style='color:red;'>描述：</span>修改菜单")
    ResultData updateMenu(@RequestBody Menu menu){
        return springCloudService.updateMenu(menu);
    }

    /**
     *      添加菜单
     * @param menu
     * @return
     */
    @PostMapping("/insertMenu")
    @ApiOperation(value = "添加菜单",notes = "<span style='color:red;'>描述：</span>添加菜单")
    public ResultData insertMenu(@RequestBody Menu menu){
        return springCloudService.insertMenu(menu);
    }

    /**
     *      删除菜单
     * @param ids
     * @return
     */
    @PostMapping("/deleteMenu")
    public ResultData deleteMenu(@RequestBody List<Integer> ids){
        System.out.println(ids.toString());
        return springCloudService.deleteMenu(ids);
    }
}

