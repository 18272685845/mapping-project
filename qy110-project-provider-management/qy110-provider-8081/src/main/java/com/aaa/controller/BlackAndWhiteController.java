package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.MappingUnit;
import com.aaa.service.MappingUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class BlackAndWhiteController extends CommonController {
    @Override
    public BaseService getBaseService() {
        return null;
    }

    @Autowired
    private MappingUnitService mappingUnitService;
    /**
     *      白名单
     * @return
     */
    @GetMapping("/selectByWhite")
    public ResultData selectByWhite(){
        List<MappingUnit> mappingUnits = mappingUnitService.selectByWhite();
        if (mappingUnits.size() > 0 && mappingUnits !=null ){
            return selectSuccess(mappingUnits);
        }else {
            return selectFailed();
        }
    }

    /**
     *      黑名单
     * @return
     */
    @GetMapping("/selectByBlack")
    public ResultData selectByBlack(){
        List<MappingUnit> mappingUnits = mappingUnitService.selectByBlack();
        if (mappingUnits.size() > 0 && mappingUnits !=null ){
            return selectSuccess(mappingUnits);
        }else {
            return selectFailed();
        }
    }


}
