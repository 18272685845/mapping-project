package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.RoleMapper;
import com.aaa.mapper.RoleMenuMapper;
import com.aaa.model.Role;
import com.aaa.model.RoleMenu;
import com.aaa.vo.RoleSelecter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LQY
 * @date 2020-07-16 11:16
 */
@Service
public class RoleService extends BaseService<Role> {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    /**
     * 模糊查询
     * @param roleSelecter
     * @return
     */
    public List<Role> selectOne(@RequestBody RoleSelecter roleSelecter){
        List<Role> roles = roleMapper.selectByNameOrTime(roleSelecter);
        return roles;
    }

    /**
     * 批量删除role
     * @param ids
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteBathRole(@RequestBody List<Integer> ids){
        Integer delete = 0;
        delete = roleMapper.deleteBathRole(ids);
        if(delete > 0 && null != delete){
            try {
                delete = roleMenuMapper.batchDeleteRoleMenuByRoleId(ids);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        if(delete != null && delete > 0){
            return delete;
        }
        return null;
    }
}
