package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.EquipmentMapper;
import com.aaa.model.Equipment;
import com.aaa.model.Technicist;
import com.aaa.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author 郭航宇
 * @Date 9:48 2020/7/18
 * Description:
 **/

@Service
public class EquipmentService extends BaseService<Equipment> {
    @Autowired
    private EquipmentMapper equipmentMapper;

    /**
     * 根据用户id查询设备仪器信息
     * @param userId
     * @return
     */
    public List<HashMap> selectEquipmentById(Integer userId){
        if (userId !=null){
            List<HashMap> maps = equipmentMapper.selectEquipmentById(userId);
            if (maps!=null && maps.size() >0){
                return maps;
            }
        }
        return null;
    }

    /**
     * 增加设备仪器信息
     * @param equipment
     * @return
     */
    public Integer addEquipment(Equipment equipment){
        if (equipment != null){
            //设置创建时间
            equipment.setCreateTime(new Date());
            //设置主键id
            equipment.setId(IdUtils.getLongID());
            Integer insert = equipmentMapper.insert(equipment);
            if (insert > 0){
                return insert;
            }
        }
        return null;
    }
    /**
     * 修改设备仪器信息
     * @param equipment
     * @return
     */
    public Integer updateEquipment(Equipment equipment){
        if (equipment != null){
            //设置创建时间
            equipment.setModifyTime(new Date());
            Integer update = equipmentMapper.updateByPrimaryKey(equipment);
            if (update > 0){
                return update;
            }
        }
        return null;
    }

}
