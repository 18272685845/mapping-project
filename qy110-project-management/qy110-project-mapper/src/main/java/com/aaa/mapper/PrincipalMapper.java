package com.aaa.mapper;

import com.aaa.model.Principal;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;
/**
 * @Author 郭航宇
 * @Date 8:39 2020/7/18
 * Description:
 **/

@Repository
public interface PrincipalMapper extends Mapper<Principal> {
    /**
     * 根据id查询单位负责人信息
     * @param userId
     * @return
     */
    public List<HashMap> selectPrincipalById(Integer userId);

    /**
     * 根据id编号查询单位负责人附件信息
     * @param id
     * @return
     */
    public List<HashMap> selectPrincipalByResource(Long id);




}