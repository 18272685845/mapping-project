package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.model.Score;
import com.aaa.service.SpringCloudService;
import com.aaa.vo.ScoreVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author LQY
 * @date 2020-07-21 17:46
 */
@RestController
@RequestMapping("/scoreController")
@Api(value = "评分记录模块",tags = "评分记录模块")
public class ScoreController {

    @Autowired
    private SpringCloudService springCloudService;

    /**
     * 根据单位的编号查找评分记录
     * @param num
     * @return
     */
    @GetMapping("/selectListScore")
    @ApiOperation(value = "根据单位的编号查找评分记录",notes = "<span style='color:red;'>描述：</span>根据单位的编号查找评分记录")
    public ResultData selectListScore(@RequestParam("num") String num){
        return springCloudService.selectListScore(num);
    }

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
    @PostMapping("/insertScore")
    @ApiOperation(value = "插入评分记录",notes = "<span style='color:red;'>描述：</span>插入评分记录")
    public ResultData insertScore(@RequestBody ScoreVo scoreVo){
        return springCloudService.insertScore(scoreVo);
    }
}
