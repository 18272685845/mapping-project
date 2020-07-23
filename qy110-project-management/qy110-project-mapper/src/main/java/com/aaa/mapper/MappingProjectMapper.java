package com.aaa.mapper;

import com.aaa.model.MappingProject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import com.aaa.model.ResultCommit;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author 郭航宇 LQY
 * @Date 14:50 2020/7/18
 * Description:
 **/

@Repository
public interface MappingProjectMapper extends Mapper<MappingProject> {
    /**
     * 首页模糊查询
     * @param projectName
     * @param projectType
     * @param startDate
     * @return
     */
    List<Map<String,Object>> selectMappingProjectByProjectNameAndProjectTypeAndStartDate(@Param("projectName") String projectName, @Param("projectType") String projectType, @Param("startDate")String startDate);

    /**
     * 模糊查询的下拉框数据  测绘类型
     * @return
     */
    @Select("select project_type from t_mapping_project GROUP BY project_type")
    List<Map<String,Object>> selectProjectType();

    /**
     * 通过名字查询项目
     * @param projectName
     * @return
     */
    public MappingProject selectMappingProjectByProjectName(String projectName);

    /**
     * 新增项目汇交信息
     * @param resultCommit
     * @return
     */
    public Integer addResultCommit(ResultCommit resultCommit);

    /**
     * 根据项目id修改项目提交状态
     * @param id
     * @return
     */
    public Integer updateProjectResultsStatusById(Long id);

    /**
     * 项目类型
     */

    List<HashMap> selectQualification();

    /**
     * 根据项目名称进行查询
     * @param name
     * @return
     */
    MappingProject selectProjectByName(@Param("name") String name);


}