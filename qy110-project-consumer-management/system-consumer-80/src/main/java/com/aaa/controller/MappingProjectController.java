package com.aaa.controller;

import com.aaa.base.ResultData;

import com.aaa.model.MappingProject;
import com.aaa.model.ResultCommit;
import com.aaa.service.SpringCloudService;
import com.aaa.vo.InsertProjectVo;
import com.aaa.vo.MappingProjectVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Author 郭航宇
 * @Date 15:16 2020/7/18
 * Description:
 **/

@RestController
@RequestMapping("/mappingProject")
@Api(value = "项目管理模块-项目统计",tags = "项目管理模块-项目统计")
public class MappingProjectController {

    @Autowired
    private SpringCloudService springCloudService;

    /**
     * 首页模糊查询
     * @param projectName
     * @param projectType
     * @param startDate
     * @return
     */
    @GetMapping("/selectMappingProjectByProjectNameAndProjectTypeAndStartDate")
    @ApiOperation(value = "首页模糊查询",notes = "<span style='color:red;'>描述：</span>首页模糊查询")
    public  ResultData selectMappingProjectByProjectNameAndProjectTypeAndStartDate(String projectName, String projectType, String startDate){
        return springCloudService.selectMappingProjectByProjectNameAndProjectTypeAndStartDate(projectName, projectType, startDate);
    }
    /**
     * 模糊查询的下拉框数据  测绘类型
     * @return
     */
    @GetMapping("/selectProjectType")
    @ApiOperation(value = "模糊查询的下拉框数据",notes = "<span style='color:red;'>描述：</span>模糊查询的下拉框数据")
    public ResultData selectProjectType(){
        return springCloudService.selectProjectType();
    }
    /**
     * 通过名字查询项目
     * @param projectName
     * @return
     */
    @GetMapping("/selectMappingProjectByProjectName")
    @ApiOperation(value = "通过名字查询项目",notes = "<span style='color:red;'>描述：</span>通过名字查询项目")
    public ResultData selectMappingProjectByProjectName(@RequestParam("projectName") String projectName){
        return springCloudService.selectMappingProjectByProjectName(projectName);
    }

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
//    /**
//     * 新增项目信息，文件上传
//     * @param mappingProject
//     * @param resultCommit
//     * @param multipartFile
//     * @param refBizType
//     * @return
//     */
//    @PostMapping(value = "/insertMappingProject", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResultData insertMappingProject(@RequestBody MappingProject mappingProject,@RequestBody ResultCommit resultCommit,@RequestBody MultipartFile[] multipartFile,@RequestParam("refBizType") String refBizType){
//        return springCloudService.insertMappingProject(mappingProject, resultCommit, multipartFile, refBizType);
//    }
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
