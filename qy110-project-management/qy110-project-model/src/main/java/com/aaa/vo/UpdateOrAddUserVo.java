package com.aaa.vo;

import com.aaa.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @Author 郭航宇
 * @Date 19:15 2020/7/16
 * Description:
 * 修改 新增user 参数封装
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UpdateOrAddUserVo implements Serializable {
    private List roleIDs;
    private User user;

}
