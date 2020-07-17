package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.MappingProjectMapper;
import com.aaa.model.MappingProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List selectQualification(){
        List list = mappingProjectMapper.selectQualification();
        if(null != list && 0 < list.size()){
            return list;
        }
        return null;
    }



}
