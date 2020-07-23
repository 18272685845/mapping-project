package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.service.SpringCloudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     *      项目审核模块中，汇交成果信息也是这个
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
    @GetMapping("/selectQualification")
    @ApiOperation(value = "项目类型统计",notes = "<span style='color:red;'>描述：</span>项目类型统计")
    public ResultData selectQualification(){
        return springCloudService.selectQualification();
    }

    /**
     * 根据项目名称进行查询
     * @param name
     * @return
     */
    @GetMapping("/selectProjectByName")
    @ApiOperation(value = "根据项目名称进行查询",notes = "<span style='color:red;'>描述：</span>根据项目名称进行查询")
    public ResultData selectProjectByName(@RequestParam("name") String name){
        return springCloudService.selectProjectByName(name);
    }

}
