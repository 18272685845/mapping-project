package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.Equipment;
import com.aaa.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


/**
 * @Author 郭航宇
 * @Date 9:51 2020/7/18
 * Description:
 **/

@RestController
public class EquipmentController extends CommonController<Equipment> {
    @Autowired
    private EquipmentService equipmentService;
    @Override
    public BaseService<Equipment> getBaseService() {
        return equipmentService;
    }
    /**
     * 根据用户id查询设备仪器信息
     * @param userId
     * @return
     */
    @GetMapping("/selectEquipmentById")
    public ResultData selectEquipmentById(@RequestParam("userId") Integer userId){
        List<HashMap> maps = equipmentService.selectEquipmentById(userId);
        if (maps != null){
            return selectSuccess(maps);
        }
        return selectFailed();
    }

    /**
     * 增加设备仪器信息
     * @param equipment
     * @return
     */
    @PostMapping("/addEquipment")
    public ResultData addEquipment(@RequestBody Equipment equipment){
        Integer integer = equipmentService.addEquipment(equipment);
        if (integer >0){
            return addDataSuccess();
        }
        return addDataFailed();
    }

    /**
     * 修改设备仪器信息
     * @param equipment
     * @return
     */
    @PostMapping("/updateEquipment")
    public ResultData updateEquipment(@RequestBody Equipment equipment){
        Integer integer = equipmentService.updateEquipment(equipment);
        if (integer > 0){
            return updateDataSuccess();
        }
        return updateDataFailed();
    }
    /**
     * 删除设备仪器信息
     * @param equipment
     * @return
     */
    @PostMapping("/deleteEquipment")
    public ResultData deleteEquipment(@RequestBody Equipment equipment){
        Integer delete =equipmentService.delete(equipment);
        if (delete > 0){
            return delDataSuccess();
        }
        return delDataFailed();
    }
}
