package com.aaa.mapper;

import com.aaa.model.ResultCommit;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @auther LQY
 * @date 2020-07-18
 **/
@Repository
public interface ResultCommitMapper extends Mapper<ResultCommit> {

    List<ResultCommit> selectResultCommitByNum(@Param("num") String num);
}



