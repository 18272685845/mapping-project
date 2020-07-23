package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.MappingUnit;

import com.aaa.service.MappingUnitService;
import com.aaa.vo.MappingUnitVo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;


import java.util.Map;

/**
 * @Author 郭航宇 LQY
 * @Date 16:05 2020/7/17
 * Description:
 * 测绘单位Controller
 **/
@RestController
public class MappingUnitController  extends CommonController<MappingUnit> {


    @Autowired
    private MappingUnitService mappingUnitService;

    @Override
    public BaseService<MappingUnit> getBaseService() {
        return mappingUnitService;
    }

    /**
<<<<<<< HEAD
     * 数据统计中：单位统计信息
     * 单位审核中：单位列表
=======

     * 根据登陆用户查询其单位信息
     * @param
     * @return
     */
    @GetMapping("/selectMappingUnitById")
    public ResultData selectMappingUnitById(){
        //获取session
        HttpSession session = getSession();
        //执行查询
        List<HashMap> mappingUnitList = mappingUnitService.selectMappingUnitById(session);
        if (mappingUnitList != null){
            return selectSuccess(mappingUnitList);
        }
        return selectFailed();
    }
    /**
     *  根据前端传递id获取单位信息
     * @param userId
     * @return
     */
    @GetMapping("/getMappingUnitByUserId")
    public ResultData getMappingUnitByUserId(@RequestParam("userId") Long userId) {
        List<HashMap> byUserId = mappingUnitService.getMappingUnitByUserId(userId);
        if (byUserId != null && byUserId.size() > 0) {
            return selectSuccess(byUserId);
        }
        return selectFailed();
    }

    /**
     * 项目统计信息
>>>>>>> 0d292191da24dc20edf3fd6620c90bfe27e9458a
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
     * 修改单位信息
     * @return
     */
    @PostMapping("/updateMappingUnit")
    public ResultData updateMappingUnit(@RequestBody MappingUnit mappingUnit){
        Integer integer = mappingUnitService.updateMappingUnit(mappingUnit);
        if (integer > 0){
            return updateDataSuccess();
        }
        return updateDataFailed();
    }

    /**
     * 查询一条单位信息
     * @param mappingUnit
     * @return
     */
    @PostMapping("/selectOneMappingUnit")
    public ResultData selectOneMappingUnit(@RequestBody MappingUnit mappingUnit){
        MappingUnit unit = mappingUnitService.selectOneMappingUnit(mappingUnit);
        if (unit != null){
            return selectSuccess(unit);
        }
        return selectFailed();
    }

    /**
     * 单位所属技术员和项目数量
     * @param userId
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
