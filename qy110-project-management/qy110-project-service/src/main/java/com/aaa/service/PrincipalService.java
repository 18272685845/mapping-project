package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.PrincipalMapper;
import com.aaa.model.Principal;
import com.aaa.utils.DateUtils;
import com.aaa.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class PrincipalService extends BaseService<Principal> {
    @Autowired
    private PrincipalMapper principalMapper;

    /**
     * 根据用户id查询单位负责人
     * @param userId
     * @return
     */
    public List<HashMap> selectPrincipalById(Integer userId){
        List<HashMap> mapList = principalMapper.selectPrincipalById(userId);
        if (mapList != null && mapList.size() > 0){
            return mapList;
        }
        return null;
    }
    /**
     * 根据id编号查询单位负责人附件信息
     * @param id
     * @return
     */
    public List<HashMap> selectPrincipalByResource(Long id){
        List<HashMap> maps = principalMapper.selectPrincipalByResource(id);
        if (maps != null && maps.size() > 0){
            return maps;
        }
        return null;
    }
    /**
     * 修改单位负责人信息
     * @return
     */
    public Integer updatePrincipal( Principal principal){
        if (principal != null){
            //设置修改时间
            principal.setModifyTime(new Date());

            Integer primaryKey = principalMapper.updateByPrimaryKey(principal);
            if (primaryKey> 0){
                return primaryKey;
            }
        }
        return null;
    }

    /**
     * 增加单位负责人
     * @param principal
     * @return
     */
    public Integer addPrincipal( Principal principal){
        if (principal != null){
            //设置创建时间
            principal.setCreateTime(new Date());
            //设置主键id
            principal.setId(IdUtils.getLongID());
            Integer insert = principalMapper.insert(principal);
            if (insert > 0){
                return insert;
            }
        }
        return null;
    }



}
