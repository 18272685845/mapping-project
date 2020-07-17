package com.aaa.vo;

import com.aaa.model.MappingProject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @auther LQY
 * @date 2020-07-17
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MappingProjectPageVo {
    private MappingProject mappingProject;
    private Integer pageNum;
    private Integer pageSize;
}
