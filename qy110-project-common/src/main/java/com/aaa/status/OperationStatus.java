package com.aaa.status;

/**
 * @Author 郭航宇
 * @Date 14:41 2020/7/9
 * Description:
 *  操作状态码及描述
 **/

public enum  OperationStatus {

    ADD_DATA_SUCCESS("20003","新增成功"),
    ADD_DATA_FAILED("10006","删除失败"),
    DEL_DATA_SUCCESS("20004","删除成功"),
    DEL_DATA_FAILED("10007","删除失败"),
    UPDATE_DATA_SUCCESS("20005","更新成功"),
    UPDATE_DATA_FAILED("10008","更新失败"),
    GET_DATA_SUCCESS("20007","获取成功"),
    GET_DATA_FAILED("10011","暂无数据"),
    GET_MENU_SUCCESS("20006","获取菜单成功"),
    GET_MENU_FAILED("10010","获取菜单失败"),
    SELECT_SUCCESS("21006", "查询成功"),
    SELECT_FAILED("11009", "查询失败"),

    SELECT_ROLE_SUCCESS("210001","查询角色成功"),
    SELECT_ROLE_FAILED("210002","暂无角色信息"),
    INSERT_ROLE_SUCCESS("210003","新增角色成功"),
    INSERT_ROLE_FAILED("210004","新增角色失败"),
    DELETE_ROLE_SUCCESS("210005","删除角色成功"),
    DELETE_ROLE_FAILED("210006","删除角色失败"),

    SYSTEM_ERROR("10009","系统内部异常"),

    ZUUL_FILTER_SUCCESS("6", "路由过滤成功"),
    ZUUL_FILTER_FAILED("7", "路由过滤失败"),
    ZUUL_FILTER_TOKEN_SUCCESS("8", "token值存在"),
    ZUUL_FILTER_TOKEN_FAILED("9", "token值不存在"),
    REQUEST_IS_NULL("10", "request对象为null");

    private String code;
    private String msg;

    OperationStatus(String code ,String msg){
        this.code=code;
        this.msg=msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
