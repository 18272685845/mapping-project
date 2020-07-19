package com.aaa.status;

/**
 *
 * redis的一些标识
 */
public class RedisFlag {
    public static final String NX = "nx";
    public static final String PX = "px";
    public static final String XX = "xx";
    public static final String EX = "ex";
    public static final String NO = "no";
    public static final String RESULT_REDIS="OK";
    public static final String CHANGE_LINE="1";
    /**
     * 存放企业单位信息的key
     */
    public static final String UNIT_INFO="units";
    /**
     * 存放菜单信息的key
     */
    public static final String MENU_INFO="menus";
}
