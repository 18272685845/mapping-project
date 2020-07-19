package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.Resource;
import com.aaa.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


/**
 * @Author 郭航宇
 * @Date 11:08 2020/7/18
 * Description:
 * 附件表
 **/

@RestController
public class ResourceController extends CommonController<Resource> {
    @Autowired
    private ResourceService resourceService;
    @Override
    public BaseService<Resource> getBaseService() {
        return resourceService;
    }

    /**
     * 根据单位编号id查询附件表
     * @param id
     * @return
     */
    @GetMapping("/selectResourceById")
    public ResultData selectResourceById(@RequestParam("id") Long id){
        List<HashMap> maps = resourceService.selectResourceById(id);
        if (maps != null){
            return selectSuccess(maps);
        }
        return selectFailed();
    }


}
