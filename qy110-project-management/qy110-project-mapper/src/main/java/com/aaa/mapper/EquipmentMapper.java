package com.aaa.mapper;

import com.aaa.model.Equipment;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;
/**
 * @Author 郭航宇
 * @Date 9:46 2020/7/18
 * Description:
 **/

@Repository
public interface EquipmentMapper extends Mapper<Equipment> {
    /**
     * 根据用户id查询仪器设备信息
     * @return
     */
    public List<HashMap> selectEquipmentById(Integer userId);
}