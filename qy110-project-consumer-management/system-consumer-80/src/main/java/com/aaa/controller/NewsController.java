package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.service.SpringCloudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王登辉
 * @date 2020/7/22
 *
**/
@RestController
@RequestMapping("/News")
@Api(value = "信息公开",tags = "信息公开")
public class NewsController  {
    @Autowired
    private SpringCloudService springCloudService;
    /**
     * 项目类型统计信息
     * @return
     */
    @GetMapping("/selectAllNews")
    @ApiOperation(value = "信息公开",notes = "<span style='color:red;'>描述：</span>信息公开")
    public ResultData selectAllNews(){
        return springCloudService.selectAllNews();
    }
}
