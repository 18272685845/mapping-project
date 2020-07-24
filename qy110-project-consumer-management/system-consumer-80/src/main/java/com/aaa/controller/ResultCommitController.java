package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.service.SpringCloudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LQY
 * @date 2020-07-18 14:39
 */
@RestController
@RequestMapping("/resultCommit")
@Api(value = "项目成果汇交模块",tags = "项目成果汇交模块")
public class ResultCommitController {

    @Autowired
    private SpringCloudService springCloudService;

    /**
     * 根据用户编号查找汇交结果
     * @param num
     * @return
     */
    @GetMapping("/selectResultCommitByNum")
    @ApiOperation(value = "根据用户编号查找汇交结果",notes = "<span style='color:red;'>描述：</span>根据用户编号查找汇交结果")
    public ResultData selectResultCommitByNum(String num){
        return springCloudService.selectResultCommitByNum(num);
    }
}
