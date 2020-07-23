package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.Role;
import com.aaa.model.RoleMenu;
import com.aaa.service.RoleMenuService;
import com.aaa.service.RoleService;
import com.aaa.utils.DateUtils;
import com.aaa.vo.RoleSelecter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author LQY
 * @date 2020-07-16 11:36
 */
@RestController
public class RoleController extends CommonController<Role> {

    @Autowired
    private RoleService roleService;

    @Override
    public BaseService<Role> getBaseService() {
        return roleService;
    }

    /**
     * 查看全部角色
     * @return
     */
    @GetMapping("/selectList")
    public ResultData selectList(){
        List<Role> roles = roleService.selectAll();
        if(roles != null){
            return selectSuccess(roles);
        }
        return selectFailed();
    }

    /**
     * 模糊查询
     * @param roleSelecter
     * @return
     */
    @PostMapping("/selectOne")
    public ResultData selectOne(@RequestBody RoleSelecter roleSelecter){
        List<Role> roles = roleService.selectOne(roleSelecter);
        if(roles != null && roles.size() > 0){
            return selectRoleSuccess(roleSelecter);
        }
        return selectRoleError();
    }
    /**
     * 查看详细信息
     * @param role
     * @return
     */
    @PostMapping("/selectOneBath")
    public Role selectOneRole(@RequestBody Role role){
        Role selectOne = roleService.selectOne(role);
        return selectOne;
    }

    /**
     * 新增角色
     * @param role
     * @return
     */
    @PutMapping("/insert")
    public ResultData<Role> insertRole(@RequestBody Role role){
        role.setCreateTime(DateUtils.getCurrentDate());
        Integer add = roleService.add(role);
        if (0 < add && null != add){
            return addDataSuccess();
        }
        return addDataFailed();
    }

    /**
     * 删除角色,并将角色的权限删除
     * @param ids
     * @return
     */

    @PostMapping ("/deleteRole")
    public ResultData deleteRole(@RequestBody List<Integer> ids){
        Integer integer = roleService.deleteBathRole(ids);
        if (integer > 0){
            return delDataSuccess();
        }
        return delDataFailed();
    }



}
