package com.aaa.mapper;

import com.aaa.model.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UserMapper extends Mapper<User> {

    /**
     * 查询所有用户
     * @return
     */
    public List<User> selectAllUser();


}