package com.aaa.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.internal.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @auther LQY
 * @date 2020-07-16
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString
public class RoleSelecter implements Serializable {
    //角色名
    private String roleName;
    //开始时间
    private String startTime;
    //结束时间
    private String endTime;
}
