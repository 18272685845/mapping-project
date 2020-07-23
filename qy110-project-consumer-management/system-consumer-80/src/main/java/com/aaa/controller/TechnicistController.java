package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.model.Technicist;
import com.aaa.service.SpringCloudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Technicist")
@Api(value = "技术人员信息表",tags = "技术人员信息表")
public class TechnicistController {
    @Autowired
    private SpringCloudService springCloudService;

    /**
     * 根据用户Id查询技术人员信息
     * @param userId
     * @return
     */
    @GetMapping("/selectTechnicistById")
    @ApiOperation(value = "根据用户Id查询技术人员信息",notes = "<span style='color:red;'>描述：</span>根据用户Id查询技术人员信息")
    public ResultData selectTechnicistById(@RequestParam("userId") Integer userId){
        return springCloudService.selectTechnicistById(userId);
    }

    /**
     * 新增技术人员
     * @param technicist
     * @return
     */
    @PostMapping("/addTechnicist")
    @ApiOperation(value = "新增技术人员",notes = "<span style='color:red;'>描述：</span>新增技术人员")
    public ResultData addTechnicist(@RequestBody Technicist technicist){
        return springCloudService.addTechnicist(technicist);
    }

    /**
     * 修改技术人员信息
     * @param technicist
     * @return
     */
    @PostMapping("/updateTechnicist")
    @ApiOperation(value = "修改技术人员信息",notes = "<span style='color:red;'>描述：</span>修改技术人员信息")
    public ResultData updateTechnicist(@RequestBody Technicist technicist){
        return springCloudService.updateTechnicist(technicist);
    }
    /**
     * 删除技术人员信息
     * @param technicist
     * @return
     */
    @PostMapping("/deleteTechnicist")
    @ApiOperation(value = "删除技术人员信息",notes = "<span style='color:red;'>描述：</span>删除技术人员信息")
    public ResultData deleteTechnicist(@RequestBody Technicist technicist){
        return springCloudService.deleteTechnicist(technicist);
    }
}
