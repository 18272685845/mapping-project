package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.model.Dict;
import com.aaa.service.SpringCloudService;
import com.aaa.vo.DictVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dict")
@Api(value = "字典管理模块",tags = "字典管理接口")
public class DictController {

    @Autowired
    private SpringCloudService springCloudService;

    /**
     *  分页查询字典列表，带条件
     * @param dictVo
     * @return
     */
    @PostMapping("/selectPageDict")
    @ApiOperation(value = "分页查询字典列表",notes = "<span style='color:red;'>描述：</span>分页查询字典列表")
    public ResultData selectPageDict(@RequestBody DictVo dictVo){
        return springCloudService.selectPageDict(dictVo);
    }

    /**
     * 根据id查询字典
     * @param dict
     * @return
     */
    @PostMapping("/selectById")
    @ApiOperation(value = "根据id查询字典",notes = "<span style='color:red;'>描述：</span>根据id查询字典")
    public ResultData selectById(@RequestBody Dict dict){
        return springCloudService.selectById(dict);
    }

    /**
     * 根据id修改字典信息
     * @param dict
     * @return
     */
    @PostMapping("/updateById")
    @ApiOperation(value = "根据id修改字典信息",notes = "<span style='color:red;'>描述：</span>根据id修改字典信息")
    public ResultData updateById(@RequestBody Dict dict){
        return springCloudService.updateById(dict);
    }

    /**
     * 添加字典信息
     * @param dict
     * @return
     */
    @PostMapping("/addDict")
    @ApiOperation(value = "添加字典信息",notes = "<span style='color:red;'>描述：</span>添加字典信息")
    public ResultData addDict(@RequestBody Dict dict){
        return springCloudService.addDict(dict);
    }
    /**
     * 批量删除字典信息
     * @param ids
     * @return
     */
    @PostMapping("/deleteBatchByIds")
    @ApiOperation(value = "批量删除字典信息",notes = "<span style='color:red;'>描述：</span>批量删除字典信息")
    public ResultData deleteBatchByIds(@RequestBody List<Integer> ids){
        return springCloudService.deleteBatchByIds(ids);
    }

}
