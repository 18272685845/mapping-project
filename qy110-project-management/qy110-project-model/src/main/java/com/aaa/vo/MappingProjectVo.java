package com.aaa.vo;

import com.aaa.model.MappingProject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author 郭航宇
 * @Date 14:50 2020/7/18
 * Description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MappingProjectVo {
    private MappingProject mappingProject;

    private Integer pageNum;

    private Integer pageSize;
}
