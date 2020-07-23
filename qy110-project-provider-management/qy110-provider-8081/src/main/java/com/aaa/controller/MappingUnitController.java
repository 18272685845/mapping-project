package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.MappingUnit;
import com.aaa.service.MappingUnitService;
import com.aaa.utils.PageInfoRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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



    /**
     *      抽查分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/selectByRound")
    public ResultData selectByRoundLimit(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        PageInfoRandom pageInfoRandom=new PageInfoRandom<>(mappingUnitService.list,pageNum,pageSize);
        return selectSuccess(pageInfoRandom);
    }
    /**
     *      抽查表初始化
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/selectByRounds")
    public ResultData selectByRoundsInit(@RequestParam String address,@RequestParam Double scale,@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        mappingUnitService.setList(null);
        List<MappingUnit> mappingUnits = mappingUnitService.selectByRound(address, scale, pageNum, pageSize);
        if (mappingUnits.size() > 0 && mappingUnits != null){
            PageInfoRandom pageInfo = new PageInfoRandom<>(mappingUnits,pageNum,pageSize);
            return selectSuccess(pageInfo);
        }else {
            return selectFailedZ();
        }
    }

}
