package com.aaa.mapper;

import com.aaa.model.Score;
import com.aaa.vo.ScoreVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import tk.mybatis.mapper.common.Mapper;

import java.security.PublicKey;
import java.util.Date;
import java.util.List;

/**
 * @auther LQY
 * @date 2020-07-20
 * 单位分值
 **/
@Repository
public interface ScoreMapper extends Mapper<Score> {

    /**
     * 根据单位编号查找评分记录
     * @param num
     * @return
     */
    public List<Score> selectListScore(@Param("num") String num);

    /**
     * 插入评分记录
     * @param id 评分记录编号
     * @param scoreNum 要加减的分数值
     * @param score 当前分数值
     * @param unitId 关联单位的id
     * @param reason 备注
     * @param createTime 创建时间
     * @param status 根据这个状态判断加分减分  0:加分  1:减分
     * @return
     */
    Integer insertScore(ScoreVo scorevo);

    /**
     * 获取最后一条记录的id
     * @return
     */
    Long selectLastId();

}