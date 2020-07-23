package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.MappingUnitMapper;
import com.aaa.model.MappingUnit;
import com.aaa.vo.MappingUnitVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author LQY
 * @date 2020-07-17 11:25
 */
@Service
public class MappingUnitService extends BaseService<MappingUnit> {

    @Autowired
    private MappingUnitMapper mappingUnitMapper;

    /**
     * 数据统计中：单位统计信息
     * 单位审核中：单位列表
     * @return
     */
    public List<MappingUnit> selectAllUnit(){
        java.util.List<MappingUnit> mappingUnits = mappingUnitMapper.selectAll();
        if(null != mappingUnits && 0 < mappingUnits.size()){
            return mappingUnits;
        }
        return null;
    }

    /**
     * 单位审核中：单位列表
     * 根据单位名称进行查询
     * @param name
     * @return
     */
    public MappingUnit selectOneUnitByName(String name){
        MappingUnit mappingUnit = mappingUnitMapper.selectOneUnitByName(name);
        if(null != mappingUnit && !mappingUnit.equals("")){
            return mappingUnit;
        }
        return null;
    }

    /**
     * 单位资质信息
     * @return
     */
    public List<MappingUnitVo> selectQualificationLevel(){
        List<MappingUnitVo> list = mappingUnitMapper.selectQualificationLevel();
        if(null != list && 0 < list.size()){
            return list;
        }
        return null;
    }

    /**
     * 单位所属技术员和项目数量
     * @return
     */
    public List selectTechnicist(Integer userId){
        List list = new ArrayList();
        List<Map> technicist = mappingUnitMapper.selectTechnicist(userId);
        List<Map> projectNum = mappingUnitMapper.selectProjectNum(userId);
        List<Map> specialNum = mappingUnitMapper.selectSpecialNum(userId);
        list.add(0,technicist);
        list.add(1,projectNum);
        list.add(2,specialNum);
        if(null != list && 0 < list.size()){
            return list;
        }
        return null;
    }

    /**
     * 所有单位人员设备汇总统计
     * @return
     */
    public List selectEquipmentByUnit(){
        List list = new ArrayList();
        List<Map> allEquipment = mappingUnitMapper.selectAllEquipment();
        List<Map> allUnit = mappingUnitMapper.selectAllUnit();
        List<Map> allTech = mappingUnitMapper.selectAllTech();
        list.add(0,allEquipment);
        list.add(1,allUnit);
        list.add(2,allTech);
        if(null != list && 0 < list.size()){
            return list;
        }
        return null;
    }

    /**
     * 单位修改待审核、单位注册待审核
     * @param status 2:单位修改待审核  3:单位修改待审核
     * @param name  根据姓名进行模糊查询
     * @return
     */
    public List<MappingUnit> selectUnitByAuditStatus(String status, String name) {
        List<MappingUnit> mappingUnits = mappingUnitMapper.selectUnitByAuditStatus(status, name);
        if(null != mappingUnits && 0 < mappingUnits.size()){
            return mappingUnits;
        }
        return null;
    }
}
