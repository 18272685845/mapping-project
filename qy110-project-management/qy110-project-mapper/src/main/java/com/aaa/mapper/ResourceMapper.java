package com.aaa.mapper;

import com.aaa.model.Resource;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @Author 郭航宇
 * @Date 10:45 2020/7/18
 * Description:
 * 附件表
 **/

public interface ResourceMapper extends Mapper<Resource> {
    /**
     * 根据单位编号id查询附件表
     * @param id
     * @return
     */
    public List<HashMap> selectResourceById(Long id);
}