package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.Menu;
import com.aaa.service.MenuService;
import com.aaa.utils.DateUtils;
import com.aaa.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class MenuController extends CommonController<Menu> {

    @Autowired
    private MenuService menuService;
    @Override
    public BaseService<Menu> getBaseService() {
        return menuService;
    }

    /**
     *      查询所有菜单
     * @return
     */
    @GetMapping("/selectAllMenu")
    public ResultData selectAllMenu(){
        List<Menu> menus = menuService.selectAll();
        if (menus.size()>0 && menus != null){
            return super.selectSuccessZ(menus);
        }else {
            return super.selectFailedZ();
        }
    }

    /**
     *      修改菜单
     * @param menu
     * @return
     */
    @PostMapping("/updateMenu")
    public ResultData updateMenu(@RequestBody Menu menu){
        Integer update = menuService.update1(menu);
        if (update > 0){
            return super.updateDataSuccess();
        }else {
            return super.updateDataFailed();
        }
    }

    /**
     *      添加菜单
     * @param menu
     * @return
     */
    @PostMapping("/insertMenu")
    public ResultData insertMenu(@RequestBody Menu menu){
        menu.setCREATE_TIME(DateUtils.getCurrentDate());
        menu.setMODIFY_TIME(DateUtils.getCurrentDate());
        Integer add = menuService.add(menu);
        if (add>0){
            return super.addDataSuccess();
        }else{
            return super.addDataFailed();
        }
    }

    /**
     *      删除菜单
     * @param ids
     * @return
     */
    @PostMapping("/deleteMenu")
    public ResultData deleteMenu(@RequestBody List<Integer> ids){
        Integer integer = menuService.deleteMenu(ids);
        if (integer> 0){
            return delDataSuccess("批量删除成功");
        }
        return delDataFailed("批量删除失败");
    }
}
