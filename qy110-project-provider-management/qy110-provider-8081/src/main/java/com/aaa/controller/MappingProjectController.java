package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.MappingProject;
import com.aaa.service.MappingProjectService;

import com.aaa.vo.InsertProjectVo;
import com.aaa.vo.MappingProjectVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * @Author 郭航宇 LQY
 * @Date 15:10 2020/7/18
 * Description:
 **/
@RestController
public class MappingProjectController extends CommonController<MappingProject> {

    @Autowired
    private MappingProjectService mappingProjectService;
    @Override
    public BaseService<MappingProject> getBaseService() {
        return mappingProjectService;
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
    @PostMapping("/insertMappingProject")
    public ResultData insertMappingProject(@RequestBody InsertProjectVo insertProjectVo){
        Integer integer = mappingProjectService.insertMappingProject(insertProjectVo);
        if (integer > 0){
            return insertRoleSuccess();
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
     * 所有单位统计信息
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
        List list = mappingProjectService.selectQualification();
        if(null != list && 0 < list.size()){
            return selectSuccess(list);
        }
        return selectFailed();
    }

}
