package com.aaa.service;


import com.aaa.base.BaseService;
import com.aaa.mapper.RoleMenuMapper;
import com.aaa.model.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 王登辉
 * @date 2020/7/17
 *      修改角色的权限
**/
@Service
public  class RoleMenuService extends BaseService<RoleMenu> {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    /**
     * 修改权限
     *
     * @param roleId
     * @param menuId
     * @return
     */
    private Integer sum;

    public Integer UpdatePer(Integer roleId, Integer[] menuId) {
        Integer integer = roleMenuMapper.deletPer(roleId);
        if (integer > 0) {
            for (Integer menu : menuId) {
                sum = roleMenuMapper.addPer(roleId, menu);
            }
            return sum;
        }
        return null;
    }

    /**
     * 删除rolemenu表内信息
     *
     * @param roleMenusList
     * @return
     */
    public Integer batchDeleteRoleMenuByRoleId(List<Integer> roleMenusList) {
        System.out.println("roleMenusListroleMenusListroleMenusListroleMenusList" + roleMenusList);
        return roleMenuMapper.batchDeleteRoleMenuByRoleId(roleMenusList);
    }

    /**
     * 添加角色权限信息
     *
     * @param roleMenuList
     * @return
     */
    public Integer insertRoleMenuByRoleId(List<RoleMenu> roleMenuList) {
        return roleMenuMapper.insertRoleMenuByRoleId(roleMenuList);
    }


}
