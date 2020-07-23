package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.ScoreMapper;
import com.aaa.model.Score;
import com.aaa.utils.IdUtils;
import com.aaa.vo.ScoreVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author LQY
 * @date 2020-07-20 11:23
 * 单位分值
 */
@Service
public class ScoreService extends BaseService<Score> {

    @Autowired
    private ScoreMapper scoreMapper;

    /**
     * 根据单位编号查找评分记录
     * @param num
     * @return
     */
    public List<Score> selectListScore(String num){
        List<Score> scores = scoreMapper.selectListScore(num);
        if(scores.size() > 0 && scores != null){
            return scores;
        }
        return null;
    }

    /**
     * 插入评分记录
     * @return
     */
    public Integer insertScore(ScoreVo scoreVo){
        Long lastId = scoreMapper.selectLastId();
        System.out.println(lastId);
        scoreVo.setId(IdUtils.getLongID());
        System.out.println(lastId+1+"-------------------------");
        scoreVo.setCreateTime(new Date());
        Integer insertScore = scoreMapper.insertScore(scoreVo);
        if(insertScore > 0){
            return insertScore;
        }
        return -1;
    }

}
