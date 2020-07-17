package com.aaa.mapper;

import com.aaa.model.MappingUnit;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @auther LQY
 * @date 2020-07-17
 **/
@Repository
public interface MappingUnitMapper extends Mapper<MappingUnit> {

    /**
     * 查询单位资质等级
     */
    List selectQualificationLevel();

    /**
     * 单位所属技术人员
     * @param userId
     * @return
     */
    List<Integer> selectTechnicist(Integer userId);

    /**
     * 单位所属项目数量
     * @param userId
     * @return
     */
    List<Integer> selectProjectNum(Integer userId);

    /**
     * 各个等级的单位的设备数量
     * @return
     */
    List<Integer> selectAllEquipment();

    /**
     * 各个等级的单位数量
     * @return
     */
    List<Integer> selectAllUnit();

}