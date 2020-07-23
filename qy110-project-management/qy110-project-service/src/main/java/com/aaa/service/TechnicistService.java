package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.TechnicistMapper;
import com.aaa.model.Technicist;
import com.aaa.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
/**
 * @Author 郭航宇
 * @Date 9:29 2020/7/18
 * Description:
 **/

@Service
public class TechnicistService extends BaseService<Technicist> {
    @Autowired
    private TechnicistMapper technicistMapper;

    /**
     * 根据用户Id查询技术人员表
     * @param userId
     * @return
     */
    public List<HashMap> selectTechnicistById(Integer userId){
        List<HashMap> maps = technicistMapper.selectTechnicistById(userId);
        if (maps != null){
            return maps;
        }
        return null;
    }

    /**
     * 新增技术人员
     * @param technicist
     * @return
     */
    public Integer addTechnicist(Technicist technicist){
        if (technicist != null){
            //设置创建时间
            technicist.setCreateTime(new Date());
            //设置主键id
            technicist.setId(IdUtils.getLongID());
            Integer insert = technicistMapper.insert(technicist);
            if (insert > 0){
                return insert;
            }
        }
        return null;
    }

    /**
     * 修改技术人员信息
     * @param technicist
     * @return
     */
    public Integer updateTechnicist(Technicist technicist){
        if (technicist != null){
            //设置创建时间
            technicist.setModifyTime(new Date());
            Integer update = technicistMapper.updateByPrimaryKey(technicist);
            if (update > 0){
                return update;
            }
        }
        return null;
    }



}
