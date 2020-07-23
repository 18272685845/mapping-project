package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.SpecialPostMapper;
import com.aaa.model.SpecialPost;
import com.aaa.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
/**
 * @Author 郭航宇
 * @Date 10:21 2020/7/18
 * Description:
 **/

@Service
public class SpecialPostService extends BaseService<SpecialPost> {
    @Autowired
     private SpecialPostMapper specialPostMapper;

    /**
     * 根据用户id查询特殊岗位信息
     * @param userId
     * @return
     */
    public List<HashMap> selectSpecialPostById(Integer userId){
        List<HashMap> maps = specialPostMapper.selectSpecialPostById(userId);
        if (maps != null){
            return maps;
        }
        return null;
    }
    /**
     * 新增特殊岗位信息
     * @param specialPost
     * @return
     */
    public Integer addSpecialPost(SpecialPost specialPost){
        if (specialPost != null){
            //设置创建时间
            specialPost.setCreateTime(new Date());
            //设置主键id
            specialPost.setId(IdUtils.getLongID());
            Integer insert = specialPostMapper.insert(specialPost);
            if (insert > 0){
                return insert;
            }
        }
        return null;
    }
    /**
     * 修改特殊岗位信息
     * @param specialPost
     * @return
     */
    public Integer updateTechnicist(SpecialPost specialPost){
        if (specialPost != null){
            //设置创建时间
            specialPost.setModifyTime(new Date());
            Integer update = specialPostMapper.updateByPrimaryKey(specialPost);
            if (update > 0){
                return update;
            }
        }
        return null;
    }
}
