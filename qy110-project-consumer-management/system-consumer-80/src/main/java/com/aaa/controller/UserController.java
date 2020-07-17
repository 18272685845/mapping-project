package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.service.SpringCloudService;
import com.aaa.vo.PageVo;
import com.aaa.vo.UpdateOrAddUserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "用户管理模块",tags = "用户管理模块")
public class UserController {

    @Autowired
    private SpringCloudService springCloudService;

    /**
     * 分页查询所有用户信息
     * @return
     */
    @PostMapping("/selectPageAllUser")
    @ApiOperation(value = "分页查询用户信息",notes = "<span style='color:red;'>描述：</span>分页查询所有用户信息")
    public ResultData selectPageAllUser(@RequestBody PageVo pageVo){
        System.out.println(pageVo.toString());
        return springCloudService.selectPageAllUser(pageVo);
    }
    /**
     * 查询所有角色
     * @return
     */
    @GetMapping("/selectAllRole")
    @ApiOperation(value = "查询所有角色",notes = "<span style='color:red;'>描述：</span>查询所有角色")
    public ResultData selectAllRole(){
        return springCloudService.selectAllRole();
    }

    /**
     * 根据用户id查询所对应的角色
     */
    @GetMapping("/selectByIdUserRole")
    @ApiOperation(value = "根据用户id查询所对应的角色",notes = "<span style='color:red;'>描述：</span>根据用户id查询所对应的角色")
    public ResultData selectByIdUserRole(@RequestParam("id") Integer id){
        System.out.println(id);
        return springCloudService.selectByIdUserRole(id);
    }

    /**
     * 根据id批量删除用户
     * @param ids
     * @return
     */
    @PostMapping("/deleteBatchUser")
    @ApiOperation(value = "根据id批量删除用户",notes = "<span style='color:red;'>描述：</span>根据id批量删除用户")
    public ResultData deleteBatchUser (@RequestBody List<Integer> ids){
        return springCloudService.deleteBatchUser(ids);
    }


    /**
     * 根据用户id修改用户信息
     * @return
     */
    @PostMapping("/updateUser")
    @ApiOperation(value = "根据用户id修改用户信息",notes = "<span style='color:red;'>描述：</span>根据用户id修改用户信息")
    public ResultData updateUser(@RequestBody UpdateOrAddUserVo updateUserVo){
        return springCloudService.updateUser(updateUserVo);
    }

    /**
     * 新增用户
     * @param addUserVo
     * @return
     */
    @PostMapping("/addUser")
    @ApiOperation(value = "新增用户",notes = "<span style='color:red;'>描述：</span>新增用户")
    public ResultData addUser(@RequestBody UpdateOrAddUserVo addUserVo){
        return springCloudService.addUser(addUserVo);
    }

    /**
     * 获取用户的字典表状态
     * @return
     */
    @GetMapping("/getUserStatus")
    @ApiOperation(value = "获取用户的字典表状态",notes = "<span style='color:red;'>描述：</span>获取用户的字典表状态")
    public ResultData getUserStatus(){
        return springCloudService.getUserStatus();
    }

    /**
     * 获取用户字典表性别值
     * @return
     */
    @GetMapping("/getUserSsex")
    public ResultData getUserSsex(){
        return springCloudService.getUserSsex();
    }


}
