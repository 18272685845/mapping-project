package com.aaa.vo;

import com.aaa.model.RoleMenu;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class RoleMenuVo implements Serializable {
    //角色id
    private Integer roleid;
    //菜单id
    private Integer [] menuid;

}
