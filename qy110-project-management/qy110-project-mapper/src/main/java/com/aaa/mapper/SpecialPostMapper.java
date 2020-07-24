package com.aaa.mapper;

import com.aaa.model.SpecialPost;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;
/**
 * @Author 郭航宇
 * @Date 10:21 2020/7/18
 * Description:
 * 特殊岗位人员
 **/

@Repository
public interface SpecialPostMapper extends Mapper<SpecialPost> {
    /**
     * 根据用户id查询特殊岗位信息
     * @param userId
     * @return
     */
    public List<HashMap> selectSpecialPostById(Integer userId);
}