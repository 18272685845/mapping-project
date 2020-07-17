package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.User;
import com.aaa.service.UserService;
import com.aaa.vo.PageVo;
import com.aaa.vo.UpdateOrAddUserVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
/**
 * @Author 郭航宇
 * @Date 19:15 2020/7/16
 * Description:
 **/

@RestController
public class UserController extends CommonController<User> {

    @Autowired
    private UserService userService;
    @Override
    public BaseService<User> getBaseService() {
        return userService;
    }
    /**
     * 分页查询所有用户信息
     * @return
     */
    @PostMapping("/selectPageAllUser")
    public ResultData selectPageAllUser(@RequestBody PageVo pageVo){
        PageInfo pageInfo = userService.selectPageAllUser(pageVo);
        if (pageInfo.getList().size()>0 ){
            return selectSuccess(pageInfo);
        }
        return selectFailed();
    }

    /**
     * 查询所有角色
     * @return
     */
    @GetMapping("/selectAllRole")
    public ResultData selectAllRole(){
        List<HashMap> selectAllRole = userService.selectAllRole();

        if (selectAllRole != null){
            return selectSuccess(selectAllRole);
        }
        return selectFailed();
    }
    /**
     * 根据用户id查询所对应的角色
     */
    @GetMapping("/selectByIdUserRole")
    public ResultData selectByIdUserRole(@RequestParam("id") Integer id){
        List<Integer> selectByIdUserRole = userService.selectByIdUserRole(id);
        if (selectByIdUserRole != null){
            return selectSuccess(selectByIdUserRole);
        }
        return selectFailed();
    }

    /**
     * 根据id批量删除用户
     * @param ids
     * @return
     */
    @PostMapping  ("/deleteBatchUser")
    public ResultData deleteBatchUser (@RequestBody List<Integer> ids){
        Integer deleteBatchUser = userService.deleteBatchUser(ids);
        if (deleteBatchUser > 0){
            return delDataSuccess("批量删除成功");
        }
        return delDataFailed("批量删除成功");
    }
    /**
     * 根据用户id修改用户信息
     * @return
     */
    @PostMapping("/updateUser")
    public ResultData updateUser(@RequestBody UpdateOrAddUserVo updateUserVo){
        Integer integer = userService.updateUser(updateUserVo);
        if (integer > 0 && integer!= null){
            return updateDataSuccess();
        }
        return updateDataFailed();
    }

    /**
     * 新增用户
     * @param addUserVo
     * @return
     */
    @PostMapping("/addUser")
    public ResultData addUser(@RequestBody UpdateOrAddUserVo addUserVo){
        return userService.addUser(addUserVo);
    }

    /**
     * 获取用户的字典表状态
     * @return
     */
    @GetMapping("/getUserStatus")
    public ResultData getUserStatus(){
        List<HashMap> userStatus = userService.getUserStatus();
        if (userStatus!=null && userStatus.size()>0){
            return selectSuccess(userStatus);
        }
        return selectFailed();
    }
    /**
     * 获取用户字典表性别值
     * @return
     */
    @GetMapping("/getUserSsex")
    public ResultData getUserSsex(){
        List<HashMap> userSsex = userService.getUserSsex();
        if (userSsex != null && userSsex.size() > 0){
            return selectSuccess(userSsex);
        }
        return selectFailed();
    }



}
