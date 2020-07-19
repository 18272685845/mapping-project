package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.model.MappingProject;
import com.aaa.service.SpringCloudService;
import com.aaa.vo.InsertProjectVo;
import com.aaa.vo.MappingProjectVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 郭航宇
 * @Date 15:16 2020/7/18
 * Description:
 **/

@RestController
@RequestMapping("/mappingProject")
@Api(value = "项目管理模块",tags = "项目管理模块")
public class MappingProjectController {
    @Autowired
    private SpringCloudService springCloudService;

    /**
     * 带条件查询的 分页查询项目信息
     * @param mappingProjectVo
     * @return
     */
    @PostMapping("/selectMappingProjectByPage")
    @ApiOperation(value = "带条件分页查询项目信息",notes = "<span style='color:red;'>描述：</span>带条件分页查询项目信息")
    public ResultData selectMappingProjectByPage(@RequestBody MappingProjectVo mappingProjectVo){
        return springCloudService.selectMappingProjectByPage(mappingProjectVo);
    }
    /**
     * 新增项目信息
     * @return
     */
    @PostMapping("/insertMappingProject")
    @ApiOperation(value = "新增项目信息",notes = "<span style='color:red;'>描述：</span>新增项目信息")
    public ResultData insertMappingProject(@RequestBody InsertProjectVo insertProjectVo){
        return springCloudService.insertMappingProject(insertProjectVo);
    }
    /**
     * 修改项目信息
     * @return
     */
    @PostMapping("/updateMappingProject")
    @ApiOperation(value = "修改项目信息",notes = "<span style='color:red;'>描述：</span>修改项目信息")
    public ResultData updateMappingProject(@RequestBody MappingProject mappingProject){
        return springCloudService.updateMappingProject(mappingProject);
    }
    /**
     * 根据项目id修改项目提交状态
     * @param id
     * @return
     */
    @GetMapping("/updateProjectResultsStatusById")
    @ApiOperation(value = "根据项目id修改项目提交状态",notes = "<span style='color:red;'>描述：</span>根据项目id修改项目提交状态")
    public ResultData updateProjectResultsStatusById(@RequestParam("id") Long id){
        return springCloudService.updateProjectResultsStatusById(id);
    }
}
