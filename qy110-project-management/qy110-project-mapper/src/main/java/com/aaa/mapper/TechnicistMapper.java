package com.aaa.mapper;

import com.aaa.model.Technicist;
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
public interface TechnicistMapper extends Mapper<Technicist> {

    public List<HashMap> selectTechnicistById(Integer userId);
}