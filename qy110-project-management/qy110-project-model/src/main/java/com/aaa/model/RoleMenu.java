package com.aaa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @auther LQY
 * @date 2020-07-18
 **/
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_role_menu")
public class RoleMenu {
    @Column(name = "ROLE_ID")
    private Integer roleId;

    @Column(name = "MENU_ID")
    private Integer menuId;

}