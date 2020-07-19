package com.aaa.mapper;

import com.aaa.model.Menu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
/**
 * @author 王登辉
 * @date 2020/7/17
 *      菜单的增删改查
**/
public interface MenuMapper extends Mapper<Menu> {
    /**
     *      删除菜单
     * @param ids
     * @return
     */
    Integer deleteBachById(List<Integer> ids);

    /**
     *      根据parentId来查询菜单或者按钮信息
     * @return
     */
    List<Menu> selectByParentId(Menu menu);
}