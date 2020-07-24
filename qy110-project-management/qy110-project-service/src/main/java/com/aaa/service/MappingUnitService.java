package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.MappingUnitMapper;
import com.aaa.model.MappingUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.aaa.vo.MappingUnitVo;

import java.util.ArrayList;
import com.aaa.utils.ObjectUtil;
import com.aaa.vo.TokenVo;


import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 郭航宇 LQY
 * @Date 16:06 2020/7/17
 * Description:
 * 测绘单位service
 **/
@Service
public class MappingUnitService extends BaseService<MappingUnit> {

    public static List<MappingUnit> list;

    public static void setList(List<MappingUnit> list) {
        MappingUnitService.list = list;
    }

    @Autowired
    private MappingUnitMapper mappingUnitMapper;
    /**
     * 根据登陆用户查询其单位信息
     * @param
     * @return
     */
    public List<HashMap> selectMappingUnitById(HttpSession session){
        //获取tokenVo
        TokenVo tokenVo = (TokenVo)session.getAttribute("TokenVo");
        System.out.println(tokenVo.toString());
        //RedisKey就是用户的id
        String userId = tokenVo.getRedisKey();
        //转换类型
        Long id = ObjectUtil.transToLong(userId);
        //根据登陆用户id查询其单位信息
        List<HashMap> unitList = mappingUnitMapper.selectMappingUnitById(id);
        if (unitList != null && unitList.size() > 0 ){
            return unitList;
        }
        return null;

    }

    /**
     * 数据统计中：单位统计信息
     * 单位审核中：单位列表
     *  根据前端传递id获取单位信息
     * @param userId
     * @return
     */
    public List<HashMap> getMappingUnitByUserId(Long userId) {
        List<HashMap> units = mappingUnitMapper.selectMappingUnitById(userId);
        if (units != null && units.size() > 0) {
            return units;
        }
        return  null;
    }
    /**
     * 项目单位信息、
     * * @return
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
     * 修改单位信息
     * @param mappingUnit
     * @return
     */
    public Integer updateMappingUnit(MappingUnit mappingUnit) {
        Integer update = update(mappingUnit);
        if (update > 0) {
            return update;
        }
        return null;
    }

    /**
     * 单位所属技术员和项目数量
     * @param userId
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
     * 根据一条单位信息
     * @return
     */
    public MappingUnit selectOneMappingUnit(MappingUnit mappingUnit){
        MappingUnit unit = selectOne(mappingUnit);
        if (unit != null){
            return unit;
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
