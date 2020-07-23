package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.MappingProject;
import com.aaa.service.MappingProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author LQY
 * @date 2020-07-17 11:29
 */
@RestController
public class MappingProjectController extends CommonController<MappingProject> {

    @Autowired
    private MappingProjectService mappingProjectService;

    @Override
    public BaseService<MappingProject> getBaseService() {
        return mappingProjectService;
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
