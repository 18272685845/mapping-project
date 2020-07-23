package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.model.Audit;
import com.aaa.service.SpringCloudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LQY
 * @date 2020-07-18 15:14
 */
@RestController
@RequestMapping("/audit")
@Api(value = "审核记录模块",tags = "审核记录模块")
public class AuditController {

    @Autowired
    private SpringCloudService springCloudService;

    /**
     * 根据用户编号查找审核记录
     * @param num
     * @return
     */
    @GetMapping("/selectAuditByNum")
    @ApiOperation(value = "根据用户编号查找审核记录",notes = "<span style='color:red;'>描述：</span>根据用户编号查找审核记录")
    public ResultData selectAuditByNum(@RequestParam("num") String num){
        return springCloudService.selectAuditByNum(num);
    }
}
