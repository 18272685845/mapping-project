package com.aaa.mapper;

import com.aaa.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @Author 郭航宇
 * @Date 10:50 2020/7/16
 * Description:
 **/

@Repository
public interface UserMapper extends Mapper<User> {

    /**
     * 查询所有用户
     * @return
     */
    public List<User> selectAllUser();

    /**
     * 查询所有角色
     * @return
     */
    public List<HashMap> selectAllRole();



    /**
     * 根据用户id查询所对应的角色
     * @return
     */
    public List<Integer> selectByIdUserRole(@Param("id") Integer id);

    /**
     * 多选批量删除用户
     * @return ids
     */
    public Integer deleteBatchUser(List<Integer> ids);

    /**
     * 根据用户id删除其所有角色
     * @return
     */
    public Integer deleteUserIdByRole(List<Integer> ids);

    /**
     * 添加用户角色
     * @return
     */
    public Integer insertUserRole(HashMap hashMap);


    /**
     * 查看用户名是否存在
     * @param username
     * @return
     */
    public Long selectByUserName(String username);

    /**
     * 获取user表在字典表中的状态值
     * @return
     */
    public List<HashMap> getUserStatus();

    /**
     * 获取用户字典表性别值
     * @return
     */
    public List<HashMap> getUserSsex();









}