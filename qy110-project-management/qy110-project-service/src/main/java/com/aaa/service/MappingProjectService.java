package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.MappingProjectMapper;
import com.aaa.model.MappingProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LQY
 * @date 2020-07-17 11:25
 */
@Service
public class MappingProjectService extends BaseService<MappingProject> {

    @Autowired
    private MappingProjectMapper mappingProjectMapper;

    /**
     * 统计所有项目信息
     *      项目审核模块中，汇交成果信息、项目审核、成果汇交审核也是这个
     * @return
     */
    public List<MappingProject> selectAllProject(){
        List<MappingProject> mappingProjects = mappingProjectMapper.selectAll();
        if(null != mappingProjects && 0 < mappingProjects.size()){
            return mappingProjects;
        }
        return null;
    }

    /**
     * 查询项目类型
     * @return
     */
    public List<HashMap> selectQualification(){
        List<HashMap> hashMaps = mappingProjectMapper.selectQualification();
        if(null != hashMaps && 0 < hashMaps.size()){
            return hashMaps;
        }
        return null;
    }

    /**
     * 根据项目姓名进行模糊查询
     *              项目审核模块中，汇交成果信息的搜索、项目审核、成果汇交审核也是这个
     * @param name
     * @return
     */
    public MappingProject selectProjectByName(String name){
        MappingProject mappingProject = mappingProjectMapper.selectProjectByName(name);
        if(null != mappingProject && !mappingProject.equals("")){
            return mappingProject;
        }
        return null;
    }



}
