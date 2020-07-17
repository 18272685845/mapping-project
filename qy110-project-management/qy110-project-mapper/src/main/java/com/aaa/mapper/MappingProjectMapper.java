package com.aaa.mapper;

import com.aaa.model.MappingProject;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

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
    List selectQualification();
}