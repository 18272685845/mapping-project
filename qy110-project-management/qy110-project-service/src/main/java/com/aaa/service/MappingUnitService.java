package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.MappingUnitMapper;
import com.aaa.model.MappingUnit;
import com.aaa.redis.RedisService;
import com.aaa.utils.ObjectUtil;
import com.aaa.vo.TokenVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
/**
 * @Author 郭航宇
 * @Date 16:06 2020/7/17
 * Description:
 * 测绘单位service
 **/
@Service
public class MappingUnitService extends BaseService<MappingUnit> {
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
     *  根据前端传递id获取单位信息
     * @param userId
     * @return
     */
    public List<HashMap> getMappingUnitByUserId(Long userId){
        List<HashMap> units = mappingUnitMapper.selectMappingUnitById(userId);
        if (units != null && units.size() > 0){
            return units;
        }
        return null;
    }

    /**
     * 修改单位信息
     * @param mappingUnit
     * @return
     */
    public Integer updateMappingUnit(MappingUnit mappingUnit){
        Integer update = update(mappingUnit);
        if (update > 0){
            return update;
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
}
