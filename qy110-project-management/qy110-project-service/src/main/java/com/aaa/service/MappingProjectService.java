package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.MappingProjectMapper;
import com.aaa.model.MappingProject;
import com.aaa.utils.DateUtils;
import com.aaa.utils.IdUtils;
import com.aaa.vo.InsertProjectVo;
import com.aaa.vo.MappingProjectVo;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


import java.util.List;
/**
 * @Author 郭航宇 LQY
 * @Date 14:53 2020/7/18
 * Description:
 **/

@Service
public class MappingProjectService extends BaseService<MappingProject> {

    @Autowired
    private MappingProjectMapper mappingProjectMapper;

    /**
     * 带条件查询的 分页查询项目信息
     * @param mappingProjectVo
     * @return
     */
    public PageInfo selectMappingProjectByPage(MappingProjectVo mappingProjectVo){
        if (mappingProjectVo.getPageNum() == 0 ){
            mappingProjectVo.setPageNum(1);
        }
        if (mappingProjectVo.getPageSize() == 0 ){
            mappingProjectVo.setPageSize(5);
        }
        PageInfo<MappingProject> pageInfo = super.selectListByPage(mappingProjectVo.getMappingProject(), mappingProjectVo.getPageNum(), mappingProjectVo.getPageSize());
        return pageInfo;
    }

    /**
     * 新增项目信息
     * @return
     */
    public Integer insertMappingProject(InsertProjectVo insertProjectVo) {
        if (insertProjectVo.getMappingProject() != null && insertProjectVo.getResultCommit() != null) {
            insertProjectVo.getMappingProject().setCreateTime(DateUtils.getCurrentDate());
            Long longID = IdUtils.getLongID();
            insertProjectVo.getMappingProject().setId(longID);
            Integer add = super.add(insertProjectVo.getMappingProject());
            if (add > 0) {
                //项目新增成功 新增项目汇交表
                insertProjectVo.getResultCommit().setCreateDate(new Date());
                insertProjectVo.getResultCommit().setRefId(longID);
                insertProjectVo.getResultCommit().setId(IdUtils.getLongID());
                Integer integer = mappingProjectMapper.addResultCommit(insertProjectVo.getResultCommit());
                if (integer > 0) {
                    return integer;
                }
            }
        }
        return null;
    }

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

     * 修改项目信息
     * @return
     */
    public Integer updateMappingProject(MappingProject mappingProject){
        if (mappingProject != null){
            mappingProject.setModifyTime(DateUtils.getCurrentDate());
            Integer update = super.update(mappingProject);
            if (update > 0){
                return update;
            }
        }
        return null;
    }
    /**
     * 根据项目id修改项目提交状态
     * @param id
     * @return
     */
    public Integer updateProjectResultsStatusById(Long id){
        Integer integer = mappingProjectMapper.updateProjectResultsStatusById(id);
        if (integer > 0){
            return integer;
        }
        return integer;
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
