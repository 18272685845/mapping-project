package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.service.SpringCloudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LQY
 * @date 2020-07-17 11:54
 */
@RestController
@RequestMapping("/mappingProject")
@Api(value = "项目统计",tags = "项目统计")
public class MappingProjectController {

    @Autowired
    private SpringCloudService springCloudService;

    /**
     * 项目统计信息
     * @return
     */
    @GetMapping("/selectAllProject")
    @ApiOperation(value = "项目统计",notes = "<span style='color:red;'>描述：</span>项目统计")
    public ResultData selectAllProject(){
        return springCloudService.selectAllProject();
    }

    /**
     * 项目类型统计信息
     * @return
     */
    @GetMapping("/selectAllProject")
    @ApiOperation(value = "项目类型统计",notes = "<span style='color:red;'>描述：</span>项目类型统计")
    public ResultData selectQualification(){
        return springCloudService.selectQualification();
    }

}
