package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.service.SpringCloudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
     * 数据统计中：单位统计信息
     * 单位审核中：单位列表
     * @return
     */
    @GetMapping("/selectAllUnit")
    @ApiOperation(value = "单位统计信息",notes = "<span style='color:red;'>描述：</span>单位统计信息")
    public ResultData selectAllUnit(){
        return springCloudService.selectAllUnit();
    }

    /**
     * 单位审核中：单位列表
     * 根据单位名称进行查询
     * @param name
     * @return
     */
    @GetMapping("/selectOneUnitByName")
    @ApiOperation(value = "根据单位名称进行查询",notes = "<span style='color:red;'>描述：</span>根据单位名称进行查询")
    public ResultData selectOneUnitByName(@RequestParam("name") String name){
        return springCloudService.selectOneUnitByName(name);
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
    public ResultData selectTechnicist(@RequestParam("userId") Integer userId){
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
     * 单位修改待审核、单位注册待审核
     * @param status 2:单位修改待审核  3:单位修改待审核
     * @param name  根据姓名进行模糊查询
     * @return
     */
    @GetMapping("/selectUnitByAuditStatus")
    @ApiOperation(value = "单位修改待审核",notes = "<span style='color:red;'>描述：</span>单位修改待审核")
    public ResultData selectUnitByAuditStatus(@RequestParam("name") String name,@RequestParam("status") String status){
        return springCloudService.selectUnitByAuditStatus(status,name);
    }
}
