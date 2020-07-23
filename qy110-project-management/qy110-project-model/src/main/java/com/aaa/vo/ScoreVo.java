package com.aaa.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LQY
 * @date 2020-07-21 18:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ScoreVo implements Serializable {


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
    private Long id;
    private Integer scoreNum;
    private Integer score;
    private Long unitId;
    private String reason;
    private Date createTime;
    private Integer status;

}
