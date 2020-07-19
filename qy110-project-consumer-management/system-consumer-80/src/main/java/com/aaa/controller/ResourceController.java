package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.service.SpringCloudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
@Api(value = "附件表",tags = "附件表")
public class ResourceController {

    @Autowired
    private SpringCloudService springCloudService;

    /**
     * 根据单位编号id查询附件表
     * @param id
     * @return
     */
    @GetMapping("/selectResourceById")
    @ApiOperation(value = "根据单位编号id查询附件表",notes = "<span style='color:red;'>描述：</span>根据单位编号id查询附件表")
    public ResultData selectResourceById(@RequestParam("id") Long id){
        System.out.println(id);
        return springCloudService.selectResourceById(id);
    }
}
