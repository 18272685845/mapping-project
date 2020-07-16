package com.aaa.mapper;

import com.aaa.model.Menu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
/**
 * @author 王登辉
 * @date 2020/7/16
 * 
**/
public interface MenuMapper{
    @Select("select tm.* from " +
            "t_user_role ur left join t_role_menu rm on ur.ROLE_ID=rm.ROLE_ID " +
            "join t_menu tm on tm.MENU_ID =rm.MENU_ID " +
            "where tm.PARENT_ID=#{parentid} and ur.USER_ID=#{userid}"
            )
    List<Menu> selectAllMenu(@Param("parentid") Long parentid, @Param("userid") Long userid);


}