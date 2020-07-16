package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.Menu;
import com.aaa.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * @author 王登辉
 * @date 2020/7/16
 *
**/
@RestController
public class MenuController extends BaseController {
    @Autowired
    private MenuService menuService;
    @GetMapping("/selectAllMenu")
    public ResultData selectAllMenu(@RequestParam("userid")Long userid){
        List<Menu> menus = menuService.selectAllMenu(userid);
        if (menus.size() > 0 && menus != null){
          return selectSuccess(menus);
        }else {
            return selectFailed();
        }
    }
}
