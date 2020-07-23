package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.Resource;
import com.aaa.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LQY
 * @date 2020-07-18 11:31
 * 附件
 */
@RestController
public class ResourceController extends CommonController<Resource> {

    @Autowired
    private ResourceService resourceService;

    @Override
    public BaseService<Resource> getBaseService() {
        return resourceService;
    }

    /**
     * 根据用户编号查找本单位的附件
     * @param number
     * @return
     */
    @GetMapping("/selectResourceByNum")
    public ResultData selectResourceByNum(@RequestParam("number") String number){
        List list = resourceService.selectResourceByNum(number);
        if(null != list && 0 < list.size()){
            return selectSuccess(list);
        }
        return selectFailed();
    }


}
