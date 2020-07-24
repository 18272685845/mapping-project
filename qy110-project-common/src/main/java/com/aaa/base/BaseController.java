package com.aaa.base;


import static com.aaa.status.LoginStatus.*;
import static com.aaa.status.OperationStatus.*;

/**
 * @Author 郭航宇
 * @Date 15:45 2020/7/8
 * Description:
 *  统一controller
 *  所有的controller都需要继承这个controller，进行统一返回
 **/

public class BaseController {

    /**
     * 登陆成功
     * 使用系统消息
     * @return
     */
    protected ResultData loginSuccess(){
        ResultData resultData=new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * 登陆成功 返回自定义信息
     * @param msg
     * @return
     */
    protected ResultData loginSuccess(String msg){
        ResultData resultData=new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 登陆成功返回数据信息，使用系统消息
     * @param data
     * @return
     */
    protected ResultData loginSuccess(Object data){
        ResultData resultData=new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * 登陆成功返回数据信息，自定义消息
     * @param data
     * @param msg
     * @return
     */
    protected ResultData loginSuccess(Object data,String msg){
        ResultData resultData=new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * 登陆失败 使用系统消息
     * @return
     */
    protected ResultData loginFailed(){
        ResultData resultData=new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        return resultData;
    }


    /**
     * 登陆失败 使用系统消息，使用详细说明
     * @param detail
     * @return
     */
    protected ResultData loginFailed(String detail){
        ResultData resultData=new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }
    /**
     * 成功新增数据
     * @return
     */
    protected ResultData addDataSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(ADD_DATA_SUCCESS.getCode());
        resultData.setMsg(ADD_DATA_SUCCESS.getMsg());
        return resultData;
    }
    /**
     * 成功新增数据
     * @return
     */
    protected ResultData addDataSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(ADD_DATA_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     * 成功新增数据
     * @return
     */
    protected ResultData addDataSuccess(String msg,String code){
        ResultData resultData = new ResultData();
        resultData.setCode(msg);
        resultData.setMsg(code);
        return resultData;
    }

    /**
     * 新增数据失败
     * @return
     */
    protected ResultData addDataFailed(){
        ResultData resultData = new ResultData();
        resultData.setMsg(ADD_DATA_FAILED.getMsg());
        resultData.setCode(ADD_DATA_FAILED.getCode());
        return resultData;
    }
    /**
     * 新增数据失败
     * @return
     */
    protected ResultData addDataFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setMsg(ADD_DATA_FAILED.getMsg());
        resultData.setCode(msg);
        return resultData;
    }
    /**
     * 新增数据失败
     * @return
     */
    protected ResultData addDataFailed(String msg,String code){
        ResultData resultData = new ResultData();
        resultData.setMsg(msg);
        resultData.setCode(code);
        return resultData;
    }

    /**
     * 成功删除数据
     * @return
     */
    protected ResultData delDataSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(DEL_DATA_SUCCESS.getCode());
        resultData.setMsg(DEL_DATA_SUCCESS.getMsg());
        return resultData;
    }
    /**
     * 成功删除数据
     * @return
     */
    protected ResultData delDataSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(DEL_DATA_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     * 成功删除数据
     * @return
     */
    protected ResultData delDataSuccess(String msg,String code){
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 删除数据失败
     * @return
     */
    protected ResultData delDataFailed(){
        ResultData resultData = new ResultData();
        resultData.setMsg(DEL_DATA_FAILED.getMsg());
        resultData.setCode(DEL_DATA_FAILED.getCode());
        return resultData;
    }
    /**
     * 删除数据失败
     * @return
     */
    protected ResultData delDataFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setMsg(msg);
        resultData.setCode(DEL_DATA_FAILED.getCode());
        return resultData;
    }
    /**
     * 删除数据失败
     * @return
     */
    protected ResultData delDataFailed(String msg,String code){
        ResultData resultData = new ResultData();
        resultData.setMsg(msg);
        resultData.setCode(code);
        return resultData;
    }

    /**
     * 成功更新数据
     * @return
     */
    protected ResultData updateDataSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_DATA_SUCCESS.getCode());
        resultData.setMsg(UPDATE_DATA_SUCCESS.getMsg());
        return resultData;
    }
    /**
     * 成功更新数据
     * @return
     */
    protected ResultData updateDataSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_DATA_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     * 成功更新数据
     * @return
     */
    protected ResultData updateDataSuccess(String msg,String code){
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 更新数据失败
     * @return
     */
    protected ResultData updateDataFailed(){
        ResultData resultData = new ResultData();
        resultData.setMsg(UPDATE_DATA_FAILED.getMsg());
        resultData.setCode(UPDATE_DATA_FAILED.getCode());
        return resultData;
    }

    /**
     * 更新数据失败
     * @return
     */
    protected ResultData updateDataFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setMsg(msg);
        resultData.setCode(UPDATE_DATA_FAILED.getCode());
        return resultData;
    }
    /**
     * 更新数据失败
     * @return
     */
    protected ResultData updateDataFailed(String msg,String code){
        ResultData resultData = new ResultData();
        resultData.setMsg(msg);
        resultData.setCode(code);
        return resultData;
    }

    /**
     * 系统异常
     * @return
     */
    protected ResultData systemError(){
        ResultData resultData = new ResultData();
        resultData.setCode(SYSTEM_ERROR.getCode());
        resultData.setData(SYSTEM_ERROR.getMsg());
        return resultData;
    }
    /**
     * 系统异常
     * @return
     */
    protected ResultData systemError(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(SYSTEM_ERROR.getCode());
        resultData.setData(msg);
        return resultData;
    }
    /**
     * 系统异常
     * @return
     */
    protected ResultData systemError(String msg,String code){
        ResultData resultData = new ResultData();
        resultData.setCode(code);
        resultData.setData(msg);
        return resultData;
    }

    /**
     * 角色查询成功
     * @param obj
     * @return
     */
    protected ResultData selectRoleSuccess(Object obj){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_ROLE_SUCCESS.getCode());
        resultData.setMsg(SELECT_ROLE_SUCCESS.getMsg());
        resultData.setData(obj);
        return resultData;
    }

    /**
     * 角色查询失败
     * @return
     */
    protected ResultData selectRoleError(){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_ROLE_FAILED.getCode());
        resultData.setMsg(SELECT_ROLE_FAILED.getMsg());
        return resultData;
    }

    /**
     * 删除角色失败
     * @return
     */
    protected ResultData deleteRoleError(){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_ROLE_FAILED.getCode());
        resultData.setMsg(DELETE_ROLE_FAILED.getMsg());
        return resultData;
    }

    /**
     * 删除角色成功
     * @return
     */
    protected ResultData deleteRoleSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_ROLE_SUCCESS.getCode());
        resultData.setMsg(DELETE_ROLE_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * 新增角色成功
     * @return
     */
    protected ResultData insertRoleSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_ROLE_SUCCESS.getCode());
        resultData.setMsg(INSERT_ROLE_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * 新增角色失败
     * @return
     */
    protected ResultData insertRoleFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_ROLE_FAILED.getCode());
        resultData.setMsg(INSERT_ROLE_FAILED.getMsg());
        return resultData;
    }

    /**
     * 查询数据成功，返回data数据
     * @param data
     * @return
     */
    protected ResultData selectSuccessZ(Object data) {
        ResultData resultDate = new ResultData();
        resultDate.setCode(SELECT_SUCCESS.getCode());
        resultDate.setMsg(SELECT_SUCCESS.getMsg());
        resultDate.setData(data);
        return resultDate;
    }

    /**
     * 查询数据成功，返回data数据和详情信息
     * @param detail
     * @param data
     * @return
     */
    protected ResultData selectSuccessZ(String detail, Object data) {
        ResultData resultDate = new ResultData();
        resultDate.setCode(SELECT_SUCCESS.getCode());
        resultDate.setMsg(SELECT_SUCCESS.getMsg());
        resultDate.setDetail(detail);
        resultDate.setData(data);
        return resultDate;
    }

    /**
     * 查询失败
     * @return
     */
    protected ResultData selectFailedZ() {
        ResultData resultDate = new ResultData();
        resultDate.setCode(SELECT_FAILED.getCode());
        resultDate.setMsg(SELECT_FAILED.getMsg());
        return resultDate;
    }

    /**
     * 查询失败，返回自定义详情
     * @param detail
     * @return
     */
    protected ResultData selectFailedZ(String detail) {
        ResultData resultDate = new ResultData();
        resultDate.setCode(SELECT_FAILED.getCode());
        resultDate.setMsg(SELECT_FAILED.getMsg());
        resultDate.setDetail(detail);
        return resultDate;
    }



    /**
     * 查询数据成功
     * @return
     */
    protected ResultData selectSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(GET_DATA_SUCCESS.getCode());
        resultData.setMsg(GET_DATA_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /**
     * 查询数据失败
     * @return
     */
    protected ResultData selectFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(GET_DATA_FAILED.getCode());
        resultData.setMsg(GET_DATA_FAILED.getMsg());
        return resultData;
    }
    //TODO 代码未完善

    /**
     * 查询成功，返回系统消息
     * @return
     */
    protected ResultData selectAll(){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_SUCCESS.getCode());
        resultData.setCode(SELECT_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * 查询成功，返回自定义消息
     * @return
     */
    protected ResultData selectAllRole(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_FAILED.getCode());
        resultData.setCode(msg);
        return resultData;
    }


}
