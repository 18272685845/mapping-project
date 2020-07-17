package com.aaa.vo;

import com.aaa.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


/**
 * @Author 郭航宇
 * @Date 15:55 2020/7/16
 * Description:
 *  用户角色 封装参数
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PageVo {
    private Integer pageNum;
    private Integer pageSize;
}
