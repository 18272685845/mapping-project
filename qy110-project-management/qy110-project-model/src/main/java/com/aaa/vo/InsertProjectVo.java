package com.aaa.vo;

import com.aaa.model.MappingProject;
import com.aaa.model.ResultCommit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author 郭航宇
 * @Date 15:43 2020/7/18
 * Description:
 * 新增项目 参数类
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class InsertProjectVo {

    private MappingProject mappingProject;
    /**
     * 项目成果汇交表
     */
    private ResultCommit resultCommit;
}
