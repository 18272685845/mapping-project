package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.model.Principal;
import com.aaa.service.SpringCloudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 郭航宇
 * @Date 8:50 2020/7/18
 * Description:
 **/

@RestController
@RequestMapping("/principal")
@Api(value = "单位负责人模块",tags = "单位负责人模块")
public class PrincipalController {
    @Autowired
    private SpringCloudService springCloudService;

    /**
     * 根据用户id查询单位负责人
     * @param userId
     * @return
     */
    @GetMapping("/selectPrincipalById")
    @ApiOperation(value = "根据用户id查询单位负责人",notes = "<span style='color:red;'>描述：</span>根据用户id查询单位负责人")
    public ResultData selectPrincipalById(@RequestParam("userId") Integer userId){
        return springCloudService.selectPrincipalById(userId);
    }
    /**
     * 根据id编号查询单位负责人附件信息
     * @param id
     * @return
     */
    @GetMapping("/selectPrincipalByResource")
    @ApiOperation(value = "根据id编号查询单位负责人附件信息",notes = "<span style='color:red;'>描述：</span>根据id编号查询单位负责人附件信息")
    public ResultData selectPrincipalByResource(@RequestParam("id") Long id){
        return springCloudService.selectPrincipalByResource(id);
    }
    /**
     * 修改单位负责人信息
     * @return
     */
    @PostMapping("/updatePrincipal")
    @ApiOperation(value = "修改单位负责人信息",notes = "<span style='color:red;'>描述：</span>修改单位负责人信息")
    public ResultData updatePrincipal(@RequestBody Principal principal){
        return springCloudService.updatePrincipal(principal);
    }

    /**
     * 增加单位负责人
     * @param principal
     * @return
     */
    @PostMapping("/addPrincipal")
    @ApiOperation(value = "增加单位负责人",notes = "<span style='color:red;'>描述：</span>增加单位负责人")
    public ResultData addPrincipal(@RequestBody Principal principal){
        return springCloudService.addPrincipal(principal);
    }
    /**
     * 删除单位负责人
     * @param principal
     * @return
     */
    @PostMapping("/deletePrincipal")
    @ApiOperation(value = "删除单位负责人",notes = "<span style='color:red;'>描述：</span>删除单位负责人")
    public ResultData deletePrincipal(@RequestBody Principal principal){
        return springCloudService.deletePrincipal(principal);
    }
}
