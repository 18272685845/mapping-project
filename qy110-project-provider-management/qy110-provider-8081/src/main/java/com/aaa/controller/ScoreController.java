package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.Score;
import com.aaa.service.ScoreService;
import com.aaa.vo.ScoreVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author LQY
 * @date 2020-07-20 11:24
 * 分值记录
 */
@RestController
public class ScoreController extends CommonController<Score> {

    @Autowired
    private ScoreService scoreService;

    @Override
    public BaseService<Score> getBaseService() {
        return scoreService;
    }

    /**
     * 根据单位的编号查找评分记录
     * @param num
     * @return
     */
    @GetMapping("/selectListScore")
    public ResultData selectListScore(@RequestParam("num") String num){
        List<Score> scores = scoreService.selectListScore(num);
        if(scores.size() > 0 && scores != null){
            return selectSuccess(scores);
        }
        return selectFailed();
    }

    /**
     * 插入评分记录
     * @return
     */
    @PostMapping("/insertScore")
    public ResultData insertScore(@RequestBody ScoreVo scoreVo){
        Integer insertScore = scoreService.insertScore(scoreVo);
        if(insertScore > 0){
            return selectSuccess(insertScore);
        }
        return selectFailed();
    }
}
