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
     *      获取所有菜单
     * @param menu
     * @return
     */
    @PostMapping("/selectAllMenu")
    @ApiOperation(value = "获取所有菜单",notes = "<span style='color:red;'>描述：</span>获取所有菜单")
    public ResultData selectMenuById(@RequestBody Menu menu){
        return springCloudService.selectMenuById(menu);
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
    @ApiOperation(value = "删除菜单",notes = "<span style='color:red;'>描述：</span>删除菜单")
    public ResultData deleteMenu(@RequestBody List<Integer> ids){
        System.out.println(ids.toString());
        return springCloudService.deleteMenu(ids);
    }
}

