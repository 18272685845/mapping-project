package com.aaa.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author LQY
 * @date 2020-07-18 16:59
 * 单位的审核
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MappingUnitVo {
    private String num;
    private String qualification_level;
}
