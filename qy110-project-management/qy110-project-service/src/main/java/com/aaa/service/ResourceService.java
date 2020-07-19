package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.ResourceMapper;
import com.aaa.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class ResourceService extends BaseService<Resource> {
    @Autowired
    private ResourceMapper resourceMapper;

    /**
     * 根据单位编号id查询附件表
     * @param id
     * @return
     */
    public List<HashMap> selectResourceById(Long id){
        List<HashMap> maps = resourceMapper.selectResourceById(id);
        if (maps != null){
            return maps;
        }
        return null;
    }
}
