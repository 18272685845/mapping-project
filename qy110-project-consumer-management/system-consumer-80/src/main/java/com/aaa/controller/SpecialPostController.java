package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.model.SpecialPost;
import com.aaa.service.SpringCloudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 郭航宇
 * @Date 10:27 2020/7/18
 * Description:
 **/

@RestController
@RequestMapping("/specialPost")
@Api(value = "特殊岗位信息表",tags = "特殊岗位信息表")
public class SpecialPostController {
    @Autowired
    private SpringCloudService springCloudService;
    /**
     * 根据用户id查询特殊岗位信息
     * @param userId
     * @return
     */
    @GetMapping("/selectSpecialPostById")
    @ApiOperation(value = "根据用户id查询特殊岗位信息",notes = "<span style='color:red;'>描述：</span>根据用户id查询特殊岗位信息")
    public ResultData selectSpecialPostById(@RequestParam("userId") Integer userId){
        return springCloudService.selectSpecialPostById(userId);
    }
    /**
     * 新增特殊岗位信息
     * @param specialPost
     * @return
     */
    @PostMapping("/addSpecialPost")
    @ApiOperation(value = "新增特殊岗位信息",notes = "<span style='color:red;'>描述：</span>新增特殊岗位信息")
    public ResultData addSpecialPost(@RequestBody SpecialPost specialPost){
        return springCloudService.addSpecialPost(specialPost);
    }
    /**
     * 修改特殊岗位信息
     * @param specialPost
     * @return
     */
    @PostMapping("/updateSpecialPost")
    @ApiOperation(value = "修改特殊岗位信息",notes = "<span style='color:red;'>描述：</span>修改特殊岗位信息")
    public ResultData updateSpecialPost(@RequestBody SpecialPost specialPost){
        return springCloudService.updateSpecialPost(specialPost);
    }
    /**
     * 删除特殊岗位信息
     * @param specialPost
     * @return
     */
    @PostMapping("/deleteSpecialPost")
    @ApiOperation(value = "删除特殊岗位信息",notes = "<span style='color:red;'>描述：</span>修改特殊岗位信息")
    public ResultData deleteSpecialPost(@RequestBody SpecialPost specialPost){
        return springCloudService.deleteSpecialPost(specialPost);
    }
}
