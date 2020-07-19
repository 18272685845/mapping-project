package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.Menu;
import com.aaa.service.MenuService;
import com.aaa.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     *      获取所有菜单
     * @param menu
     * @return
     */
    @PostMapping("/selectAllMenu")
    public ResultData selectMenuById(@RequestBody Menu menu){
        List<Menu> menus = menuService.selectMenuById(menu);
        if (menus.size()>0 && menus != null){
            return super.selectSuccessZ(menus);
        }else {
            return super.selectFailedZ("查询失败");
        }
    }
    /**
     *      修改菜单
     * @param menu
     * @return
     */
    @PostMapping("/updateMenu")
    public ResultData updateMenu(@RequestBody Menu menu){
        menu.setMODIFY_TIME(DateUtils.getCurrentDate());
        Integer update = menuService.update(menu);
        if (update > 0){
            return super.updateDataSuccess("修改成功");
        }else {
            return super.updateDataFailed("修改失败");
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
            return super.addDataSuccess("添加成功");
        }else{
            return super.addDataFailed("添加失败");
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
            return delDataSuccess("删除成功");
        }
        return delDataFailed("删除失败");
    }


}
