package com.aaa.mapper;

import com.aaa.model.MappingProject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @auther LQY
 * @date 2020-07-17
 **/
@Repository
public interface MappingProjectMapper extends Mapper<MappingProject> {

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