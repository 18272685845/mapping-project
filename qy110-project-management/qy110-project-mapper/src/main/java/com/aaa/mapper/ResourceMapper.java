package com.aaa.mapper;

import com.aaa.model.Resource;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @auther LQY
 * @date 2020-07-18
 **/
@Repository
public interface ResourceMapper extends Mapper<Resource> {

    /**
     * 根据库用户编号查找附件
     * @param number
     * @return
     */
    List<Resource> selectResourceByNum(String number);
}