package com.aaa.mapper;

import com.aaa.model.MappingProject;
import com.aaa.model.ResultCommit;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
/**
 * @Author 郭航宇
 * @Date 14:50 2020/7/18
 * Description:
 **/

@Repository
public interface MappingProjectMapper extends Mapper<MappingProject> {

    public Integer addResultCommit(ResultCommit resultCommit);

    /**
     * 根据项目id修改项目提交状态
     * @param id
     * @return
     */
    public Integer updateProjectResultsStatusById(Long id);
}