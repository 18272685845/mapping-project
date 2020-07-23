package com.aaa.mapper;



import com.aaa.model.RoleMenu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author 王登辉
 * @date 2020/7/17
 *      角色权限的修改
**/
@Repository
public interface RoleMenuMapper extends Mapper<RoleMenu> {
    /**
     *      删除所有权限
     * @param roleId
     * @param
     * @return
     */
    @Insert("insert into t_role_menu values(#{ROLE_ID},#{MENU_ID})")
    Integer addPer(@Param("ROLE_ID") Integer roleId, @Param("MENU_ID") Integer menuId);

    /**
     *      添加权限
     * @param roleId
     * @return
     */
    @Delete("delete from t_role_menu where ROLE_ID=(#{ROLE_ID})")
    Integer deletPer(@Param("ROLE_ID") Integer roleId);

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

