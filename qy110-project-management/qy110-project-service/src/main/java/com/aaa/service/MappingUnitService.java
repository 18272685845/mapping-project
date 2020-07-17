package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.MappingUnitMapper;
import com.aaa.model.MappingUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * 项目单位信息
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
     * 单位资质信息
     * @return
     */
    public List selectQualificationLevel(){
        List list = mappingUnitMapper.selectQualificationLevel();
        if(null != list && 0 < list.size()){
            return list;
        }
        return null;
    }

    /**
     * 单位所属技术员和项目数量
     * @return
     */
    public Map selectTechnicist(Integer userId){
        Map map = null;
        List<Integer> technicist = mappingUnitMapper.selectTechnicist(userId);
        List<Integer> projectNum = mappingUnitMapper.selectProjectNum(userId);
        map.put("technicist",technicist);
        map.put("projectNum",projectNum);
        if(null != map && 0 < map.size()){
            return map;
        }
        return null;
    }

    /**
     * 所有单位人员设备汇总统计
     * @return
     */
    public Map selectEquipmentByUnit(){
        Map map = null;
        List<Integer> equipment = mappingUnitMapper.selectAllEquipment();
        List<Integer> unit = mappingUnitMapper.selectAllUnit();
        map.put("equipment",equipment);
        map.put("unit",unit);
        if(null != map && 0 < map.size()){
            return map;
        }
        return null;
    }

}
