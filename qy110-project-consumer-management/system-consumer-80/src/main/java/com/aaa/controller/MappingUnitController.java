package com.aaa.controller;

import com.aaa.base.ResultData;

import com.aaa.model.MappingUnit;
import com.aaa.service.SpringCloudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LQY
 * @date 2020-07-17 11:55
 */
@RestController
@RequestMapping("/mappingUnit")
@Api(value = "单位基本信息模块-单位统计",tags = "单位基本信息模块-单位统计")
public class MappingUnitController {

    @Autowired
    private SpringCloudService springCloudService;

    /**
     * 根据登陆用户id查询其单位信息
     *
     * @param
     * @return
     */
    @GetMapping("/selectMappingUnitById")
    @ApiOperation(value = "根据登陆用户id查询其单位信息", notes = "<span style='color:red;'>描述：</span>根据登陆用户id查询其单位信息")
    public ResultData selectMappingUnitById() {
        return springCloudService.selectMappingUnitById();
    }

    /**
     * 根据前端传递id获取单位信息
     *
     * @param userId
     * @return
     */
    @GetMapping("/getMappingUnitByUserId")
    @ApiOperation(value = "根据前端传递id获取单位信息", notes = "<span style='color:red;'>描述：</span>根据前端传递id获取单位信息")
    public ResultData getMappingUnitByUserId(@RequestParam("userId") Long userId) {
        return springCloudService.getMappingUnitByUserId(userId);
    }

    /**
     * 修改单位信息
     *
     * @return
     */
    @PostMapping("/updateMappingUnit")
    @ApiOperation(value = "修改单位信息", notes = "<span style='color:red;'>描述：</span>修改单位信息")
    public ResultData updateMappingUnit(@RequestBody MappingUnit mappingUnit) {
        return springCloudService.updateMappingUnit(mappingUnit);
    }

    /**
     * 查询一条单位信息
     *
     * @param mappingUnit
     * @return
     */
    @PostMapping("/selectOneMappingUnit")
    @ApiOperation(value = "查询一条单位信息", notes = "<span style='color:red;'>描述：</span>查询一条单位信息")
    public ResultData selectOneMappingUnit(@RequestBody MappingUnit mappingUnit) {
        return springCloudService.selectOneMappingUnit(mappingUnit);
    }
    /**
     * 单位统计信息
     * @return
     */
    @GetMapping("/selectAllUnit")
    @ApiOperation(value = "单位统计信息", notes = "<span style='color:red;'>描述：</span>单位统计信息")
    public ResultData selectAllUnit () {
        return springCloudService.selectAllUnit();
    }

    /**
     * 单位资质等级信息
     * @return
     */
    @GetMapping("/selectQualificationLevel")
    @ApiOperation(value = "单位资质等级信息", notes = "<span style='color:red;'>描述：</span>单位资质等级信息")
    public ResultData selectQualificationLevel () {
        return springCloudService.selectQualificationLevel();
    }

    /**
     * 单位所属技术员和项目数量
     * @return
     */
    @GetMapping("/selectTechnicist")
    @ApiOperation(value = "单位所属技术员和项目数量", notes = "<span style='color:red;'>描述：</span>单位所属技术员和项目数量")
    public ResultData selectTechnicist (Integer userId){
        return springCloudService.selectTechnicist(userId);
    }

    /**
     * 所有单位人员设备汇总统计
     * @return
     */
    @GetMapping("/selectEquipmentByUnit")
    @ApiOperation(value = "所有单位人员设备汇总统计", notes = "<span style='color:red;'>描述：</span>所有单位人员设备汇总统计")
    public ResultData selectEquipmentByUnit () {
        return springCloudService.selectEquipmentByUnit();
    }
}
