package com.aaa.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author 郭航宇
 * @Date 21:29 2020/7/14
 * Description:
 * 部门参数 vo
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DeptVo implements Serializable {

    /**
     * 父级id
     */
    private Long parentId;
    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;
}
