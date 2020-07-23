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
     * @param
     * @return
     */
    public Integer deleteMenu(List<Integer> ids){
        Integer integer = menuMapper.deleteBachById(ids);
        if (integer > 0){
            return integer;
        }
        return  null;
    }

    /**
     *      获取菜单信息
     * @param menu
     * @return
     */
    public List<Menu>selectMenuById(Menu menu){
        //查询一级菜单
        List<Menu> menus = menuMapper.selectByParentId(menu);
        if (menus.size() > 0 && menus != null){
            for (Menu oneMenu:menus) {
                menu.setMENU_ID(oneMenu.getMENU_ID());
                //查询二级菜单
                 List<Menu> submenu = menuMapper.selectByParentId(menu);
                 if (submenu.size() > 0 && submenu != null){
                    for (Menu twoMenu:submenu) {
                        menu.setMENU_ID(twoMenu.getMENU_ID());
                        //查询三级菜单
                        List<Menu> menus1 = menuMapper.selectByParentId(menu);
                        twoMenu.setListMenu(menus1);
                    }
                 }
                 oneMenu.setListMenu(submenu);
            }
        }
        return menus;
    }
}
