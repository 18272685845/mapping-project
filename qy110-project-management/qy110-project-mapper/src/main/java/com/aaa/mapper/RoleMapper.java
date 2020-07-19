package com.aaa.mapper;

import com.aaa.model.Role;
import com.aaa.vo.RoleSelecter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
/**
 * @auther LQY
 * @date 2020-07-16
 **/
@Repository
public interface RoleMapper extends Mapper<Role> {
    /**
     * 根据角色名或者创建时间查找
     * @param roleSelecter
     * @return
     */
    List<Role> selectByNameOrTime(RoleSelecter roleSelecter);

    /**
     * 批量删除角色
     * @param ids
     * @return
     */
    Integer deleteBathRole(List<Integer> ids);

}