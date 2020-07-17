package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.base.ResultData;
import com.aaa.mapper.UserMapper;
import com.aaa.model.User;
import com.aaa.utils.DateUtils;
import com.aaa.vo.PageVo;
import com.aaa.vo.UpdateOrAddUserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.aaa.status.LoginStatus.*;
import static com.aaa.status.OperationStatus.*;

@Service
public class UserService  extends BaseService<User> {
    @Autowired
    private UserMapper userMapper;

    /**
     * 分页查询所有用户信息
     * @return
     */
    public PageInfo selectPageAllUser(PageVo pageVo){
        if (pageVo.getPageNum()== null){
            pageVo.setPageNum(1);
        }else if (pageVo.getPageSize() == null){
            pageVo.setPageSize(10);
        }
        PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize());
        List<User> userList = userMapper.selectAllUser();
       if (userList.size() > 0){
           PageInfo pageInfo =new PageInfo(userList);
           return pageInfo;
       }
       return null;
    }


    /**
     * 查询所有角色
     * @return
     */
    public List<HashMap> selectAllRole(){
        List<HashMap> mapList = userMapper.selectAllRole();
        if (mapList.size()>0 && mapList != null){
            return mapList;
        }
        return mapList;
    }
    /**
     * 根据用户id查询所对应的角色
     */
    public List<Integer> selectByIdUserRole(Integer id){
        List<Integer> userRole = userMapper.selectByIdUserRole(id);
        if (userRole.size()>0 && userRole != null){
            return userRole;
        }
        return null;
    }
    /**
     * 根据id批量删除用户
     * @param ids
     * @return
     */
    public Integer deleteBatchUser (List<Integer> ids){
        Integer integer=0;
        Integer integerNum=0;
        if (ids.size()>0 && ids!=null){
            //删除用户
            integer = userMapper.deleteBatchUser(ids);
            if (integer > 0){
                    //删除用户所拥有的角色
                    Integer integer1 = userMapper.deleteUserIdByRole(ids);
                    integerNum=integer+integer1;
                    return integerNum;
            }
        }
        return null;
    }



    /**
     * 根据用户id修改用户信息
     * @return
     */
    public Integer updateUser(UpdateOrAddUserVo updateUserVo){
        //一个用户拥有一个角色，要修改用户角色，需要先删掉原来的角色
        //根据用户id删除其所拥有的所有角色
        int idValue = updateUserVo.getUser().getId().intValue();
        List<Integer> list=new ArrayList<Integer>();
        list.add(idValue);
        Integer integer = userMapper.deleteUserIdByRole(list);
        if (integer>0){
            //判断前端传递的角色id 增加新的角色
            if (updateUserVo.getRoleIDs().size()>0){
                //放入用户id 和 角色id
                HashMap hashMap=new HashMap();
                hashMap.put("id",updateUserVo.getUser().getId());
                hashMap.put("roleIDs",updateUserVo.getRoleIDs());
                //新增新的角色
                userMapper.insertUserRole(hashMap);
            }
            updateUserVo.getUser().setModifyTime(DateUtils.getCurrentDate());
            Integer update = update(updateUserVo.getUser());
            if (update >0){
                return update;
            }
        }
        return null;
    }

    /**
     * 新增用户
     * @param addUserVo
     * @return
     */
    public ResultData addUser(UpdateOrAddUserVo addUserVo){
        ResultData resultData=new ResultData();
        //查看用户名是否存在
        Long userName = userMapper.selectByUserName(addUserVo.getUser().getUsername());
        if (userName == null && userName.equals("")){
            //用户名不存在，执行添加功能
            addUserVo.getUser().setCreateTime(DateUtils.getCurrentDate());
            Integer add = add(addUserVo.getUser());
            if (add > 0){
                return resultData.setMsg(ADD_DATA_SUCCESS.getMsg()).setCode(ADD_DATA_SUCCESS.getCode());
            }
            //获取新增用户id
            Long id = addUserVo.getUser().getId();

            //判断新增用户是否需要设置角色
            if (addUserVo.getRoleIDs().size()>0){
                //需要设置角色
                HashMap hashMap=new HashMap();
                hashMap.put("id",id);
                hashMap.put("roleIDs",addUserVo.getRoleIDs());
                Integer integer = userMapper.insertUserRole(hashMap);
                if (integer > 0){
                    //角色设置成功
                    return resultData.setMsg(INSERT_ROLE_SUCCESS.getMsg()).setCode(INSERT_ROLE_SUCCESS.getCode());
                }else {
                    return resultData.setMsg(INSERT_ROLE_FAILED.getMsg()).setCode(INSERT_ROLE_FAILED.getCode());
                }
            }
        }else {
            return resultData.setMsg(USER_EXIST.getMsg()).setCode(USER_EXIST.getCode());
        }
        return null;
    }

    /**
     * 获取用户的字典表状态
     * @return
     */
    public List<HashMap> getUserStatus(){
        List<HashMap> userStatus = userMapper.getUserStatus();
        if (userStatus != null && userStatus.size()>0){
            return userStatus;
        }
        return null;
    }

    /**
     * 获取用户字典表性别值
     * @return
     */
    public List<HashMap> getUserSsex(){
        List<HashMap> userSsex = userMapper.getUserSsex();
        if (userSsex != null && userSsex.size() > 0){
            return userSsex;
        }
        return null;
    }


}
