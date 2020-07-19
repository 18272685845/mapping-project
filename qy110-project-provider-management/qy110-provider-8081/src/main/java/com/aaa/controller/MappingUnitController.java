package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.MappingUnit;
import com.aaa.redis.RedisService;
import com.aaa.service.MappingUnitService;
import com.aaa.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @Author 郭航宇
 * @Date 16:05 2020/7/17
 * Description:
 * 测绘单位Controller
 **/
@RestController
public class MappingUnitController  extends CommonController<MappingUnit> {

    @Autowired
    private MappingUnitService mappingUnitService;

    @Override
    public BaseService<MappingUnit> getBaseService() {
        return mappingUnitService;
    }

    /**
     * 根据登陆用户查询其单位信息
     * @param
     * @return
     */
    @GetMapping("/selectMappingUnitById")
    public ResultData selectMappingUnitById(){
        //获取session
        HttpSession session = getSession();
        //执行查询
        List<HashMap> mappingUnitList = mappingUnitService.selectMappingUnitById(session);
        if (mappingUnitList != null){
            return selectSuccess(mappingUnitList);
        }
        return selectFailed();
    }
    /**
     *  根据前端传递id获取单位信息
     * @param userId
     * @return
     */
    @GetMapping("/getMappingUnitByUserId")
    public ResultData getMappingUnitByUserId(@RequestParam("userId") Long userId){
        List<HashMap> byUserId = mappingUnitService.getMappingUnitByUserId(userId);
        if (byUserId != null && byUserId.size()>0 ){
            return selectSuccess(byUserId);
        }
        return selectFailed();
    }

    /**
     * 修改单位信息
     * @return
     */
    @PostMapping("/updateMappingUnit")
    public ResultData updateMappingUnit(@RequestBody MappingUnit mappingUnit){
        Integer integer = mappingUnitService.updateMappingUnit(mappingUnit);
        if (integer > 0){
            return updateDataSuccess();
        }
        return updateDataFailed();
    }

    /**
     * 查询一条单位信息
     * @param mappingUnit
     * @return
     */
    @PostMapping("/selectOneMappingUnit")
    public ResultData selectOneMappingUnit(@RequestBody MappingUnit mappingUnit){
        MappingUnit unit = mappingUnitService.selectOneMappingUnit(mappingUnit);
        if (unit != null){
            return selectSuccess(unit);
        }
        return selectFailed();
    }
}
