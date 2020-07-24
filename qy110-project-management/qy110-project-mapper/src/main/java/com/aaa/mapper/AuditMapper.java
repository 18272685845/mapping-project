package com.aaa.mapper;

import com.aaa.model.Audit;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @auther LQY
 * @date 2020-07-18
 **/
@Repository
public interface AuditMapper extends Mapper<Audit> {

    List<Audit> selectAuditByNum(@Param("num") String num);

}