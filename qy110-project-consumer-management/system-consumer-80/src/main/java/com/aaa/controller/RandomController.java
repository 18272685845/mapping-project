package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.service.SpringCloudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王登辉
 * @date 2020/7/21
 *      双随机抽查
**/
@RestController
@RequestMapping("/DoubleRandom")
@Api(value = "双随机抽查",tags = "双随机抽查")
public class RandomController {

    @Autowired
    private SpringCloudService springCloudService;
    /**
     *      抽查分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/selectByRound")
    @ApiOperation(value = "抽查分页查询",notes = "<span style='color:red;'>描述：</span>抽查分页查询")
    public ResultData selectByRound(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
       return springCloudService.selectByRound(pageNum,pageSize);
    }
    /**
     *      抽查表初始化
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/selectByRounds")
    @ApiOperation(value = "抽查表初始化",notes = "<span style='color:red;'>描述：</span>抽查表初始化")
    public ResultData selectByRounds(@RequestParam String address,@RequestParam Double scale,@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        return springCloudService.selectByRounds(address,scale,pageNum,pageSize);
    }
}
