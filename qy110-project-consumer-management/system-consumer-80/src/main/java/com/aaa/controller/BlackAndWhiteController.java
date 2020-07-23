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
 * @date 2020/7/21
 *      黑白名单
**/
@RestController
@RequestMapping("/blcakandwhite")
@Api(value = "黑白名单",tags = "黑白名单")
public class BlackAndWhiteController {

    @Autowired
    private SpringCloudService springCloudService;
    /**
     *      白名单
     * @return
     */
    @GetMapping("/selectByWhite")
    @ApiOperation(value = "白名单",notes = "<span style='color:red;'>描述：</span>白名单")
    public ResultData selectByWhite(){
        return springCloudService.selectByWhite();
    }

    /**
     *      黑名单
     * @return
     */
    @GetMapping("/selectByBlack")
    @ApiOperation(value = "黑名单",notes = "<span style='color:red;'>描述：</span>黑名单")
    public ResultData selectByBlack(){
        return springCloudService.selectByBlack();
    }
}
