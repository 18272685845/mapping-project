package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.RoleMenuMapper;
import com.aaa.model.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LQY
 * @date 2020-07-16 12:00
 */
@Service
public class RoleMenuService extends BaseService<RoleMenu> {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    /**
     * 删除rolemenu表内信息
     * @param roleMenusList
     * @return
     */
    public Integer batchDeleteRoleMenuByRoleId(List<Integer> roleMenusList){
        System.out.println("roleMenusListroleMenusListroleMenusListroleMenusList"+roleMenusList);
        return  roleMenuMapper.batchDeleteRoleMenuByRoleId(roleMenusList);
    }

    /**
     * 添加角色权限信息
     * @param roleMenuList
     * @return
     */
    public Integer insertRoleMenuByRoleId(List<RoleMenu> roleMenuList){
        return roleMenuMapper.insertRoleMenuByRoleId(roleMenuList);
    }
}
