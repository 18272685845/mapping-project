package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.Technicist;
import com.aaa.service.TechnicistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class TechnicistController extends CommonController<Technicist> {

    @Autowired
    private TechnicistService technicistService;
    @Override
    public BaseService<Technicist> getBaseService() {
        return technicistService;
    }

    /**
     * 根据用户Id查询技术人员信息
     * @param userId
     * @return
     */
    @GetMapping ("/selectTechnicistById")
    public ResultData selectTechnicistById(@RequestParam("userId") Integer userId){
        List<HashMap> maps = technicistService.selectTechnicistById(userId);
        if (maps != null){
            return selectSuccess(maps);
        }
        return selectFailed();
    }
    /**
     * 新增技术人员
     * @param technicist
     * @return
     */
    @PostMapping("/addTechnicist")
    public ResultData addTechnicist(@RequestBody Technicist technicist){
        Integer integer = technicistService.addTechnicist(technicist);
        if (integer >0){
            return addDataSuccess();
        }
        return addDataFailed();
    }
    /**
     * 修改技术人员信息
     * @param technicist
     * @return
     */
    @PostMapping("/updateTechnicist")
    public ResultData updateTechnicist(@RequestBody Technicist technicist){
        Integer integer = technicistService.updateTechnicist(technicist);
        if (integer > 0){
            return updateDataSuccess();
        }
        return updateDataFailed();
    }
    /**
     * 删除技术人员信息
     * @param technicist
     * @return
     */
    @PostMapping("/deleteTechnicist")
    public ResultData deleteTechnicist(@RequestBody Technicist technicist){
        Integer delete = technicistService.delete(technicist);
        if (delete > 0){
            return delDataSuccess();
        }
        return delDataFailed();
    }
}
