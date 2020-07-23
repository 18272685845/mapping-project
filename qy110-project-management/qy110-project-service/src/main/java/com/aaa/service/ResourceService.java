package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.ResourceMapper;
import com.aaa.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LQY
 * @date 2020-07-18 11:29
 */
@Service
public class ResourceService extends BaseService<Resource> {

    @Autowired
    private ResourceMapper resourceMapper;

    /**
     * 根据单位编号查找附件
     * @param number
     * @return
     */
    public List selectResourceByNum(String number){
        List<Resource> resources = resourceMapper.selectResourceByNum(number);
        if(null != resources && 0 < resources.size()){
            return resources;
        }
        return null;
    }
}
