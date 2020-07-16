package com.aaa.mapper;

import com.aaa.model.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UserMapper extends Mapper<User> {

    public List<User> selectAllUser();
}