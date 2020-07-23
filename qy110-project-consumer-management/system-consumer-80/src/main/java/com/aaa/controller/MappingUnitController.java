package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.model.MappingUnit;
import com.aaa.service.SpringCloudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author LQY
 * @date 2020-07-17 11:55
 */
@RestController
@RequestMapping("/mappingUnit")
@Api(value = "单位统计",tags = "单位统计")
public class MappingUnitController {

    @Autowired
    private SpringCloudService springCloudService;

    /**
     * 单位统计信息
     * @return
     */
    @GetMapping("/selectAllUnit")
    @ApiOperation(value = "单位统计信息",notes = "<span style='color:red;'>描述：</span>单位统计信息")
    public ResultData selectAllUnit(){
        return springCloudService.selectAllUnit();
    }

    /**
     * 单位资质等级信息
     * @return
     */
    @GetMapping("/selectQualificationLevel")
    @ApiOperation(value = "单位资质等级信息",notes = "<span style='color:red;'>描述：</span>单位资质等级信息")
    public ResultData selectQualificationLevel(){
        return springCloudService.selectQualificationLevel();
    }

    /**
     * 单位所属技术员和项目数量
     * @return
     */
    @GetMapping("/selectTechnicist")
    @ApiOperation(value = "单位所属技术员和项目数量",notes = "<span style='color:red;'>描述：</span>单位所属技术员和项目数量")
    public ResultData selectTechnicist(Integer userId){
        return springCloudService.selectTechnicist(userId);
    }

    /**
     * 所有单位人员设备汇总统计
     * @return
     */
    @GetMapping("/selectEquipmentByUnit")
    @ApiOperation(value = "所有单位人员设备汇总统计",notes = "<span style='color:red;'>描述：</span>所有单位人员设备汇总统计")
    public ResultData selectEquipmentByUnit(){
        return springCloudService.selectEquipmentByUnit();
    }

    /**
     *      白名单
     * @return
     */


    /**
     *      抽查分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/selectByRound")
    @ApiOperation(value = "双随机抽查",notes = "<span style='color:red;'>描述：</span>双随机抽查")
    public ResultData selectByRound(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize){
        return springCloudService.selectByRound(pageNum,pageSize);
    }

    /**
     *      抽查表初始化
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/selectByRounds")
    public ResultData selectByRounds(@RequestParam String address,@RequestParam Double scale,@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        return springCloudService.selectByRounds(address,scale,pageNum,pageSize);
    }
}

