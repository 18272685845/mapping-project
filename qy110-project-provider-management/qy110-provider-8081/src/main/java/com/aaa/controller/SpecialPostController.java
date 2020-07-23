package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.SpecialPost;
import com.aaa.service.SpecialPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class SpecialPostController extends CommonController<SpecialPost> {
    @Autowired
    private SpecialPostService specialPostService;
    @Override
    public BaseService<SpecialPost> getBaseService() {
        return specialPostService;
    }
    /**
     * 根据用户id查询特殊岗位信息
     * @param userId
     * @return
     */
    @GetMapping("/selectSpecialPostById")
    public ResultData selectSpecialPostById(@RequestParam("userId") Integer userId){
        List<HashMap> maps = specialPostService.selectSpecialPostById(userId);
        if (maps != null){
            return selectSuccess(maps);
        }
        return selectFailed();
    }

    /**
     * 新增特殊岗位信息
     * @param specialPost
     * @return
     */
    @PostMapping("/addSpecialPost")
    public ResultData addSpecialPost(@RequestBody SpecialPost specialPost){
        Integer integer = specialPostService.addSpecialPost(specialPost);
        if (integer >0){
            return addDataSuccess();
        }
        return addDataFailed();
    }
    /**
     * 修改特殊岗位信息
     * @param specialPost
     * @return
     */
    @PostMapping("/updateSpecialPost")
    public ResultData updateSpecialPost(@RequestBody SpecialPost specialPost){
        Integer integer = specialPostService.updateTechnicist(specialPost);
        if (integer > 0){
            return updateDataSuccess();
        }
        return updateDataFailed();
    }
    /**
     * 删除特殊岗位信息
     * @param specialPost
     * @return
     */
    @PostMapping("/deleteSpecialPost")
    public ResultData deleteSpecialPost(@RequestBody SpecialPost specialPost){
        Integer delete = specialPostService.delete(specialPost);
        if (delete > 0){
            return delDataSuccess();
        }
        return delDataFailed();
    }
}
