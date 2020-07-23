package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.RoleMenu;
import com.aaa.service.RoleMenuService;
import com.aaa.vo.RoleMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 王登辉
 * @date 2020/7/17
 * 
**/
@RestController
public class RoleMenuController extends CommonController<RoleMenu>{
    @Autowired
    private RoleMenuService roleMenuService;
    @Override
    public BaseService<RoleMenu> getBaseService() {
        return roleMenuService;
    }
    
    /**
     *      修改角色权限
     * @param
     * @return
     */
    @PostMapping("/updatePer")
    public ResultData updatePer(@RequestBody RoleMenuVo roleMenuVo) {
        Integer integer = roleMenuService.UpdatePer(roleMenuVo.getRoleid(), roleMenuVo.getMenuid());
        if (integer > 0){
            return updateDataSuccess("修改成功");
        }else{
            return updateDataFailed("修改失败");
        }
    }
}
