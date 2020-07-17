package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.MappingProject;
import com.aaa.service.MappingProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
