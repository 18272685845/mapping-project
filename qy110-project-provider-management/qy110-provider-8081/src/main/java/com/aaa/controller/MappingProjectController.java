package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.MappingProject;
import com.aaa.model.ResultCommit;
import com.aaa.service.MappingProjectService;

import com.aaa.service.ResourceService;
import com.aaa.service.ResultCommitService;
import com.aaa.service.UploadService;
import com.aaa.vo.InsertProjectVo;
import com.aaa.vo.MappingProjectVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 郭航宇 LQY
 * @Date 15:10 2020/7/18
 * Description:
 **/
@RestController
public class MappingProjectController extends CommonController<MappingProject> {

    @Autowired
    private MappingProjectService mappingProjectService;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private ResultCommitService resultCommitService;

    @Autowired
    private UploadService uploadService;

    @Override
    public BaseService<MappingProject> getBaseService() {
        return mappingProjectService;
    }
    /**
     * 首页模糊查询
     * @param projectName
     * @param projectType
     * @param startDate
     * @return
     */
    @GetMapping("/selectMappingProjectByProjectNameAndProjectTypeAndStartDate")
    public  ResultData selectMappingProjectByProjectNameAndProjectTypeAndStartDate(@RequestParam("projectName") String projectName,@RequestParam("projectType") String projectType,@RequestParam("startDate") String startDate){
        List<Map<String, Object>> mapList = mappingProjectService.selectMappingProjectByProjectNameAndProjectTypeAndStartDate(projectName, projectType, startDate);
        if (mapList != null){
            return selectSuccess(mapList);
        }
        return selectFailed();
    }
    /**
     * 模糊查询的下拉框数据  测绘类型
     * @return
     */
    @GetMapping("/selectProjectType")
    public ResultData selectProjectType(){
        List<Map<String, Object>> mapList = mappingProjectService.selectProjectType();
        if (mapList !=null){
            return selectSuccess(mapList);
        }
        return selectFailed();
    }
    /**
     * 通过名字查询项目
     * @param projectName
     * @return
     */
    @GetMapping("/selectMappingProjectByProjectName")
    public ResultData selectMappingProjectByProjectName(@RequestParam("projectName") String projectName){
        MappingProject project = mappingProjectService.selectMappingProjectByProjectName(projectName);
        if (project != null){
            return selectSuccess(project);
        }
        return selectFailed();
    }
    /**
     * 带条件查询的 分页查询项目信息
     * @param mappingProjectVo
     * @return
     */
    @PostMapping("/selectMappingProjectByPage")
    public ResultData selectMappingProjectByPage(@RequestBody MappingProjectVo mappingProjectVo){
        PageInfo pageInfo = mappingProjectService.selectMappingProjectByPage(mappingProjectVo);
        if (pageInfo.getList().size()>0){
            return selectSuccess(pageInfo);
        }
        return selectFailed();
    }
    /**
     * 新增项目信息
     * @return
     */
    @PostMapping(value = "/insertMappingProject", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultData insertMappingProject( MappingProject mappingProject, ResultCommit resultCommit, MultipartFile[] multipartFile, String refBizType){

        try {
            Long integer = mappingProjectService.insertMappingProject(mappingProject);
            if (integer > 0){
                Boolean aBoolean = mappingProjectService.beforeToDo(multipartFile, refBizType,resourceService, integer);
                if (aBoolean){
                    Integer commit = resultCommitService.insertResultCommit(resultCommit, integer);
                    if (commit>0){
                        return insertRoleSuccess();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return insertRoleFailed();
    }


    /**
     * 修改项目信息
     * @return
     */
    @PostMapping("/updateMappingProject")
    public ResultData updateMappingProject(@RequestBody MappingProject mappingProject){
        Integer integer = mappingProjectService.updateMappingProject(mappingProject);
        if (integer > 0){
            return updateDataSuccess();
        }
        return updateDataFailed();
    }
    /**
     * 根据项目id修改项目提交状态
     * @param id
     * @return
     */
    @GetMapping("/updateProjectResultsStatusById")
    public ResultData updateProjectResultsStatusById(@RequestParam("id") Long id) {
        Integer integer = mappingProjectService.updateProjectResultsStatusById(id);
        if (integer > 0) {
            return updateDataSuccess();
        }
        return updateDataFailed();

    }
    /**
     * 所有项目统计信息
     *      项目审核模块中，汇交成果信息、项目审核、成果汇交审核也是这个
     * @return
     */
    @GetMapping("/selectAllProject")
    public ResultData selectAllProject(){
        List<MappingProject> mappingProjects = mappingProjectService.selectAllProject();
        if(null != mappingProjects && 0 < mappingProjects.size()){
            return selectSuccess(mappingProjects);
        }
        return selectFailed();
    }

    /**
     * 查询项目类型
     * @return
     */
    @GetMapping("/selectQualification")
    public ResultData selectQualification(){
        List<HashMap> hashMaps = mappingProjectService.selectQualification();
        if(null != hashMaps && 0 < hashMaps.size()){
            return selectSuccess(hashMaps);
        }
        return selectFailed();
    }

    /**
     * 根据项目名称进行查询
     *       项目审核模块中，汇交成果信息的搜索、项目审核、成果汇交审核也是这个
     * @param name
     * @return
     */
    @GetMapping("/selectProjectByName")
    public ResultData selectProjectByName(@RequestParam("name") String name){
        MappingProject mappingProject = mappingProjectService.selectProjectByName(name);
        if(null != mappingProject &&  !mappingProject.equals("")){
            return selectSuccess(mappingProject);
        }
        return selectFailed();
    }

}
