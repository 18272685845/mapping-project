package com.aaa.mapper;

import com.aaa.model.MappingUnit;
import com.aaa.vo.MappingUnitVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @auther LQY
 * @date 2020-07-17
 **/
@Repository
public interface MappingUnitMapper extends Mapper<MappingUnit> {

    /**
     * 查询单位资质等级
     */
    List<MappingUnitVo> selectQualificationLevel();

    /**
     * 单位所属技术人员
     * @param userId
     * @return
     */
    List<Map> selectTechnicist(@Param("userId") Integer userId);

    /**
     * 单位所属特岗人员数量
     * @param userId
     * @return
     */
    List<Map> selectSpecialNum(@Param("userId") Integer userId);

    /**
     * 单位所属项目数量
     * @param userId
     * @return
     */
    List<Map> selectProjectNum(@Param("userId") Integer userId);
    
    /**
     * 单位审核中：单位列表
     * 根据单位名称进行查询
     * @param name
     * @return
     */
    MappingUnit selectOneUnitByName(@Param("name") String name);

    /**
     * 各个等级的单位的设备数量
     * @return
     */
    List selectAllEquipment();

    /**
     * 各个等级的单位数量
     * @return
     */
    List selectAllUnit();

    /**
     * 各个单位资质的人员数量
     * @return
     */
    List selectAllTech();



    /**
     * 单位修改待审核、单位注册待审核
     * @param status 2:单位修改待审核  3:单位修改待审核
     * @param name  根据姓名进行模糊查询
     * @return
     */
    List<MappingUnit> selectUnitByAuditStatus(@Param("name") String name,@Param("status") String status);


}