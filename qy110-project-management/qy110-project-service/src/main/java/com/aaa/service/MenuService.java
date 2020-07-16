package com.aaa.service;

import com.aaa.mapper.MenuMapper;
import com.aaa.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author 王登辉
 * @date 2020/7/16
 * 
**/
@Service
public class MenuService{
    @Autowired
    private MenuMapper menuMapper;

    public List<Menu> selectAllMenu(Long userid) {
        //1.一级菜单
        List<Menu> oneMenu = menuMapper.selectAllMenu((long) 0,userid);
        if (oneMenu.size()>0 && oneMenu != null){
            for (Menu menusList:oneMenu) {

                //2.二级菜单
                List<Menu> twoMenu=menuMapper.selectAllMenu(menusList.getMENU_ID(),userid);
                for (Menu menusList2:twoMenu) {
                    //3.三级菜单
                    List<Menu> threeMenu=menuMapper.selectAllMenu(menusList2.getMENU_ID(), userid);
                    for (Menu menuList3:threeMenu) {
                        menusList2.setListMenu(threeMenu);
                    }
                }
                menusList.setListMenu(twoMenu);
            }
            return oneMenu;
        }else {
            return null;
        }
    }
}
