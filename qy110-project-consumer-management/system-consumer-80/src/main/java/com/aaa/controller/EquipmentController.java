package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.model.Equipment;
import com.aaa.service.SpringCloudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 郭航宇
 * @Date 9:54 2020/7/18
 * Description:
 **/
@RestController
@RequestMapping("/equipment")
@Api(value = "仪器设备表",tags = "仪器设备表")
public class EquipmentController {
    @Autowired
    private SpringCloudService springCloudService;

    /**
     * 根据用户id查询设备仪器信息
     * @param userId
     * @return
     */
    @GetMapping("/selectEquipmentById")
    @ApiOperation(value = "根据用户id查询设备仪器信息",notes = "<span style='color:red;'>描述：</span>根据用户id查询设备仪器信息")
    public ResultData selectEquipmentById(@RequestParam("userId") Integer userId){
        return springCloudService.selectEquipmentById(userId);
    }
    /**
     * 增加设备仪器信息
     * @param equipment
     * @return
     */
    @PostMapping("/addEquipment")
    @ApiOperation(value = "增加设备仪器信息",notes = "<span style='color:red;'>描述：</span>增加设备仪器信息")
    public ResultData addEquipment(@RequestBody Equipment equipment){
        return springCloudService.addEquipment(equipment);
    }
    /**
     * 修改设备仪器信息
     * @param equipment
     * @return
     */
    @PostMapping("/updateEquipment")
    @ApiOperation(value = "修改设备仪器信息",notes = "<span style='color:red;'>描述：</span>修改设备仪器信息")
    public ResultData updateEquipment(@RequestBody Equipment equipment){
        return springCloudService.updateEquipment(equipment);
    }
    /**
     * 删除设备仪器信息
     * @param equipment
     * @return
     */
    @PostMapping("/deleteEquipment")
    @ApiOperation(value = "删除设备仪器信息",notes = "<span style='color:red;'>描述：</span>删除设备仪器信息")
    public ResultData deleteEquipment(@RequestBody Equipment equipment){
        return springCloudService.deleteEquipment(equipment);
    }
}
