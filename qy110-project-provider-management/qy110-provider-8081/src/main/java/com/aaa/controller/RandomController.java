package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.MappingUnit;
import com.aaa.service.MappingUnitService;
import com.aaa.utils.PageInfoRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 王登辉
 * @date 2020/7/21
 *          双随机抽查
**/
@RestController
public class RandomController extends CommonController {
    @Override
    public BaseService getBaseService() {
        return null;
    }

//    @Autowired
//    private MappingUnitService mappingUnitService;
//
//    /**
//     *      抽查分页查询
//     * @param pageNum
//     * @param pageSize
//     * @return
//     */
//    @GetMapping("/selectByRound")
//    public ResultData selectByRound(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
//        PageInfoRandom pageInfoRandom=new PageInfoRandom<>(mappingUnitService.list,pageNum,pageSize);
//        return selectSuccess(pageInfoRandom);
//    }
//    /**
//     *      抽查表初始化
//     * @param pageNum
//     * @param pageSize
//     * @return
//     */
//    @GetMapping("/selectByRounds")
//    public ResultData selectByRounds(@RequestParam String address,@RequestParam Double scale,@RequestParam Integer pageNum,@RequestParam Integer pageSize){
//        mappingUnitService.setList(null);
//         List<MappingUnit> mappingUnits = mappingUnitService.selectByRound(address, scale, pageNum, pageSize);
//        if (mappingUnits.size() > 0 && mappingUnits != null){
//            PageInfoRandom pageInfo = new PageInfoRandom<>(mappingUnits,pageNum,pageSize);
//            return selectSuccess(pageInfo);
//        }else {
//            return selectFailedZ();
//        }
//    }
}
