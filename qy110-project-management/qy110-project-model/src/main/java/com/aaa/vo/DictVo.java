package com.aaa.vo;

import com.aaa.model.Dict;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author 郭航宇
 * @Date 14:58 2020/7/14
 * Description:
 *  字典列表 参数 vo
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DictVo {
    private Dict dict;
    private Integer pageNum;
    private Integer pageSize;
}
