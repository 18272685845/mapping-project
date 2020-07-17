package com.aaa.vo;

import com.aaa.model.Role;
import com.aaa.model.RoleMenu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/***
 * @auther LQY
 * @date 2020-07-16
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString
public class RoleMenuSelecter implements Serializable {
    //角色参数
    private Role role;
    //菜单参数
    private List<RoleMenu> roleMenus;
}
