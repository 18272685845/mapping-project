package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.model.Role;
import com.aaa.service.SpringCloudService;
import com.aaa.vo.RoleSelecter;
import feign.Param;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LQY
 * @date 2020-07-16 15:11
 */
@RestController
@RequestMapping("/role")
@Api(value = "角色管理模块",tags = "角色管理接口")
public class RoleController {

    @Autowired
    private SpringCloudService springCloudService;

    /**
     * 查看全部角色
     * @return
     */
    @GetMapping("/selectList")
    @ApiOperation(value = "查询角色",notes = "<span style='color:red;'>描述：</span>查询角色")
    public ResultData selectList(){
        return springCloudService.selectList();
    }

    /**
     * 模糊查询
     * @param roleSelecter
     * @return
     */
    @PostMapping("/selectOne")
    @ApiOperation(value = "模糊查询",notes = "<span style='color:red;'>描述：</span>模糊查询")
    public ResultData selectOne(RoleSelecter roleSelecter){
        return springCloudService.selectOne(roleSelecter);
    }

    /**
     * 查看详细信息
     * @param role
     * @return
     */
    @PostMapping("/selectOneBath")
    @ApiOperation(value = "查看详细信息",notes = "<span style='color:red;'>描述：</span>查看详细信息")
    public ResultData selectOneRole(Role role){
        return springCloudService.selectOneRole(role);
    }

    /**
     * 新增角色
     * @param role
     * @return
     */
    @PutMapping("/insert")
    @ApiOperation(value = "新增角色",notes = "<span style='color:red;'>描述：</span>新增角色")
    public ResultData insertRole(@RequestBody Role role){
        return springCloudService.insertRole(role);
    }

    /**
     * 删除角色,并将角色的权限删除
     * @param ids
     * @return
     */

    @PostMapping ("/deleteRole")
    @ApiOperation(value = "批量删除角色",notes = "<span style='color:red;'>描述：</span>批量删除角色")
    public ResultData deleteRole(@RequestBody List<Integer> ids){
        if(ids!= null && ids.size() >0){
            return springCloudService.deleteRole(ids);
        }
        return null;
    }


}
