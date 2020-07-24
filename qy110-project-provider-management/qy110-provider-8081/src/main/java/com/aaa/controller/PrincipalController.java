package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.Principal;
import com.aaa.service.PrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @Author 郭航宇
 * @Date 20:44 2020/7/17
 * Description:
 **/

@RestController
public class PrincipalController extends CommonController<Principal> {
    @Autowired
    private PrincipalService principalService;
    @Override
    public BaseService<Principal> getBaseService() {
        return principalService;
    }
    /**
     * 根据用户id查询单位负责人
     * @param userId
     * @return
     */
   @GetMapping("/selectPrincipalById")
    public ResultData selectPrincipalById(@RequestParam("userId") Integer userId){
       List<HashMap> mapList = principalService.selectPrincipalById(userId);
       if (mapList != null){
           return selectSuccess(mapList);
       }
       return selectFailed();
   }

    /**
     * 根据id编号查询单位负责人附件信息
     * @param id
     * @return
     */
    @GetMapping("/selectPrincipalByResource")
    public ResultData selectPrincipalByResource(@RequestParam("id") Long id){
        List<HashMap> maps = principalService.selectPrincipalByResource(id);
        if (maps != null && maps.size() >0){
            return selectSuccess(maps);
        }
        return selectFailed();
    }

    /**
     * 修改单位负责人信息
     * @return
     */
    @PostMapping("/updatePrincipal")
    public ResultData updatePrincipal(@RequestBody Principal principal){
        Integer update = principalService.updatePrincipal(principal);
        if (update > 0){
            return updateDataSuccess();
        }
        return updateDataFailed();
    }

    /**
     * 增加单位负责人
     * @param principal
     * @return
     */
    @PostMapping("/addPrincipal")
    public ResultData addPrincipal(@RequestBody Principal principal){
        Integer add = principalService.addPrincipal(principal);
        if (add > 0){
            return addDataSuccess();
        }
        return addDataFailed();
    }

    /**
     * 删除单位负责人
     * @param principal
     * @return
     */
    @PostMapping("/deletePrincipal")
    public ResultData deletePrincipal(@RequestBody Principal principal){
        Integer delete = principalService.delete(principal);
        if (delete > 0){
            return delDataSuccess();
        }
        return delDataFailed();
    }
}
