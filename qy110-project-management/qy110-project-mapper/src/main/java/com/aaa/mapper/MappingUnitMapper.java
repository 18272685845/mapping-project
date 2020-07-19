package com.aaa.mapper;

import com.aaa.model.MappingUnit;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


import java.util.HashMap;
import java.util.List;
/**
 * @Author 郭航宇 LQY
 * @Date 8:39 2020/7/18
 * Description:
 **/

@Repository
public interface MappingUnitMapper extends Mapper<MappingUnit> {


    public List<HashMap> selectMappingUnitById(Long userId);

    /**
     * 查询单位资质等级
     */
    List selectQualificationLevel();

    /**
     * 单位所属技术人员
     *
     * @param userId
     * @return
     */
    List<Integer> selectTechnicist(Integer userId);

    /**
     * 单位所属项目数量
     *
     * @param userId
     * @return
     */
    List<Integer> selectProjectNum(Integer userId);

    /**
     * 各个等级的单位的设备数量
     *
     * @return
     */
    List<Integer> selectAllEquipment();

    /**
     * 各个等级的单位数量
     *
     * @return
     */
    List<Integer> selectAllUnit();


}