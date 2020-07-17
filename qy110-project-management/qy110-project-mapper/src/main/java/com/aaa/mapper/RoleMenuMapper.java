package com.aaa.mapper;

import com.aaa.model.RoleMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @auther LQY
 * @date 2020-07-16
 **/
@Repository
public interface RoleMenuMapper extends Mapper<RoleMenu> {

    /**
     * 删除角色的权限信息
     * @param ids
     * @return
     */
    Integer batchDeleteRoleMenuByRoleId(List<Integer> ids);

    /**
     * 添加角色权限信息
     * @param roleMenuList
     * @return
     */
    Integer insertRoleMenuByRoleId(List<RoleMenu> roleMenuList);
}