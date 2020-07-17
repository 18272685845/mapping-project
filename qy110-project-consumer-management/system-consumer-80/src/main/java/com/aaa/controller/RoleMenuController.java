package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.model.RoleMenu;
import com.aaa.service.SpringCloudService;
import com.aaa.vo.RoleMenuVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 王登辉
 * @date 2020/7/17
 *     权限的添加、删除
**/
@RestController
@RequestMapping("/rolemenu")
@Api(value = "角色权限的修改模块",tags = "权限的修改模块")
public class RoleMenuController {

    @Autowired
    private SpringCloudService springCloudService;

    /**
     *      修改角色权限
     * @param roleMenuVo
     * @return
     */
    @PostMapping("/updatePer")
    @ApiOperation(value = "修改角色权限",notes = "<span style='color:red;'>描述：</span>修改角色权限")
    public ResultData updatePer(@RequestBody RoleMenuVo roleMenuVo){
        return springCloudService.updatePer(roleMenuVo);
    }
}
