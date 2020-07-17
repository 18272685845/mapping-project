package com.aaa.mapper;

import com.aaa.model.Menu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MenuMapper extends Mapper<Menu> {

    public Integer deleteBachById(List<Integer> ids);
}