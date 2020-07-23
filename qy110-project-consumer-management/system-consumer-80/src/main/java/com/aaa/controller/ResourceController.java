package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.service.SpringCloudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author LQY
 * @date 2020-07-18 11:45
 */
@RestController
@RequestMapping("/resource")
@Api(value = "附件模块",tags = "附件模块")
public class ResourceController {

    @Autowired
    private SpringCloudService springCloudService;

    /**
     * 根据用户编号查找本单位的附件
     * @param number
     * @return
     */
    @GetMapping("/selectResourceByNum")
    @ApiOperation(value = "根据用户编号查找附件",notes = "<span style='color:red;'>描述：</span>根据用户编号查找附件")
    public ResultData selectResourceByNum(@RequestParam("number") String number){
        return springCloudService.selectResourceByNum(number);
    }


}
