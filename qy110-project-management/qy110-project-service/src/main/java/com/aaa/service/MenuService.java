package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.MenuMapper;
import com.aaa.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService extends BaseService<Menu> {
    @Autowired
    private MenuMapper menuMapper;
    /**
     *      删除菜单
     * @param id
     * @return
     */
    public Integer deleteMenu(List<Integer> ids){
        Integer integer = menuMapper.deleteBachById(ids);
        if (integer > 0){
            return integer;
        }
        return  null;
    }
}
