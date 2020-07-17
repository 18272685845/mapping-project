package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.MappingUnit;
import com.aaa.service.MappingUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


/**
 * @author LQY
 * @date 2020-07-17 11:29
 */
@RestController
public class MappingUnitController extends CommonController<MappingUnit> {

    @Autowired
    private MappingUnitService mappingUnitService;

    @Override
    public BaseService<MappingUnit> getBaseService() {
        return mappingUnitService;
    }

    /**
     * 项目统计信息
     * @return
     */
    @GetMapping("/selectAllUnit")
    public ResultData selectAllUnit(){
        java.util.List<MappingUnit> mappingUnits = mappingUnitService.selectAllUnit();
        if(null != mappingUnits && 0 < mappingUnits.size()){
            return selectSuccess(mappingUnits);
        }
        return selectFailed();
    }

    /**
     * 单位资质信息
     * @return
     */
    @GetMapping("/selectQualificationLevel")
    public ResultData selectQualificationLevel(){
        List list = mappingUnitService.selectQualificationLevel();
        if(null != list && 0 < list.size()){
            return selectSuccess(list);
        }
        return selectFailed();
    }

    /**
     * 单位所属技术员和项目数量
     * @return
     */
    @GetMapping("/selectTechnicist")
    public ResultData selectTechnicist(Integer userId){
        Map selectTechnicist = mappingUnitService.selectTechnicist(userId);
        if(null != selectTechnicist && 0 < selectTechnicist.size()){
            return selectSuccess(selectTechnicist);
        }
        return selectFailed();
    }

    /**
     * 所有单位人员设备汇总统计
     * @return
     */
    @GetMapping("/selectEquipmentByUnit")
    public ResultData selectEquipmentByUnit(){
        Map equipmentByUnit = mappingUnitService.selectEquipmentByUnit();
        if(null != equipmentByUnit && 0 < equipmentByUnit.size()){
            return selectSuccess(equipmentByUnit);
        }
        return selectFailed();
    }

}
