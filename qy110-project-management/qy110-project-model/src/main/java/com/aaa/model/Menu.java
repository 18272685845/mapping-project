package com.aaa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * @author 王登辉
 * @date 2020/7/16
 * 
**/
@Table(name = "t_menu")
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Menu implements Serializable {
    /**
     * 菜单/按钮ID
     */
    @Id
    @Column(name = "MENU_ID")
    private Long MENU_ID;

    /**
     * 上级菜单ID
     */
    @Column(name = "PARENT_ID")
    private Long PARENT_ID;

    /**
     * 菜单/按钮名称
     */
    @Column(name = "MENU_NAME")
    private String MENU_NAME;

    /**
     * 对应路由path
     */
    @Column(name = "PATH")
    private String PATH;

    /**
     * 对应路由组件component
     */
    @Column(name = "COMPONENT")
    private String COMPONENT;

    /**
     * 权限标识
     */
    @Column(name = "PERMS")
    private String PERMS;

    /**
     * 图标
     */
    @Column(name = "ICON")
    private String ICON;

    /**
     * 类型 0菜单 1按钮
     */
    @Column(name = "TYPE")
    private String TYPE;

    /**
     * 排序
     */
    @Column(name = "ORDER_NUM")
    private Double ORDER_NUM;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private String CREATE_TIME;

    /**
     * 修改时间
     */
    @Column(name = "MODIFY_TIME")
    private String MODIFY_TIME;

    private List<Menu> listMenu;
}