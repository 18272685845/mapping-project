package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.MappingUnit;
import com.aaa.service.MappingUnitService;
import com.aaa.vo.MappingUnitVo;
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
     * 数据统计中：单位统计信息
     * 单位审核中：单位列表
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
     * 单位审核中：单位列表
     * 根据单位名称进行查询
     * @param name
     * @return
     */
    @GetMapping("/selectOneUnitByName")
    public ResultData selectOneUnitByName(@RequestParam("name") String name){
        MappingUnit mappingUnit = mappingUnitService.selectOneUnitByName(name);
        if(null != mappingUnit && !mappingUnit.equals("")){
            return selectSuccess(mappingUnit);
        }
        return selectFailed();
    }


    /**
     * 单位资质信息
     * @return
     */
    @GetMapping("/selectQualificationLevel")
    public ResultData selectQualificationLevel(){
        List<MappingUnitVo> list = mappingUnitService.selectQualificationLevel();
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
    public ResultData selectTechnicist(@RequestParam("userId") Integer userId){
        List selectTechnicist = mappingUnitService.selectTechnicist(userId);
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
        List list = mappingUnitService.selectEquipmentByUnit();
        if(null != list && 0 < list.size()){
            return selectSuccess(list);
        }
        return selectFailed();
    }

    /**
     * 单位修改待审核、单位注册待审核
     * @param status 2:单位修改待审核  3:单位修改待审核
     * @param name  根据姓名进行模糊查询
     * @return
     */
    @GetMapping("/selectUnitByAuditStatus")
    public ResultData selectUnitByAuditStatus(@RequestParam("name") String name,@RequestParam("status") String status){
        List<MappingUnit> mappingUnits = mappingUnitService.selectUnitByAuditStatus(name,status);
        if(null != mappingUnits && 0 < mappingUnits.size()){
            return selectSuccess(mappingUnits);
        }
        return selectFailed();
    }

}
