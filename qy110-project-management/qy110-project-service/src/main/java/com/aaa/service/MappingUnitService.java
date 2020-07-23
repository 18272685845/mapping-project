package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.MappingUnitMapper;
import com.aaa.model.MappingUnit;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * @author LQY
 * @date 2020-07-17 11:25
 */
@Service
public class MappingUnitService extends BaseService<MappingUnit> {

    public static List<MappingUnit> list;

    public static void setList(List<MappingUnit> list) {
        MappingUnitService.list = list;
    }

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

    /**
     *      双随机抽查
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<MappingUnit> selectByRound(String address,Double scale,Integer pageNum,Integer pageSize){
        if (list == null || list.isEmpty()){
            List<MappingUnit> mappingUnits = mappingUnitMapper.selectByRound();
            if (mappingUnits.size() > 0 && mappingUnits != null){
                    if (scale == 1 ){
                        Collections.shuffle(mappingUnits);
                        list=mappingUnits;
                    }
                    if (scale > 0 && scale < 1){
                        Collections.shuffle(mappingUnits);
                        int size = mappingUnits.size();
                        long round = Math.round(size * scale);
                        ArrayList arrayList=new ArrayList();
                        for (int j = 0;j < round; j++){
                            arrayList.add(mappingUnits.get(j));
                        }
                        list=arrayList;
                    }
                return list;
            }
        }
        return null;
    }

    /**
     *      白名单
     * @return
     */
    public List<MappingUnit> selectByWhite(){
        List<MappingUnit> mappingUnits = mappingUnitMapper.selectByWhite();
        if ( mappingUnits.size() > 0 && mappingUnits !=null ){
            return mappingUnits;
        }else {
            return null;
        }
    }
    /**
     *      黑名单
     * @return
     */
    public List<MappingUnit> selectByBlack(){
        List<MappingUnit> mappingUnits = mappingUnitMapper.selectByBlack();
        if ( mappingUnits.size() > 0 && mappingUnits !=null ){
            return mappingUnits;
        }else {
            return null;
        }
    }
}
