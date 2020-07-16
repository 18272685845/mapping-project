package com.aaa.controller;

import com.aaa.base.ResultData;
import com.aaa.model.Dept;
import com.aaa.service.SpringCloudService;
import com.aaa.vo.DeptVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/dept")
@Api(value = "部门管理模块",tags = "部门管理接口")
public class DeptController {
    @Autowired
    private SpringCloudService springCloudService;


    @GetMapping("/selectAll")
    @ApiOperation(value = "查询部门",notes = "<span style='color:red;'>描述：</span>查询部门")
    public ResultData selectAll(){
        return springCloudService.selectAllDept();
    }

    @PostMapping("/insert")
    @ApiOperation(value = "新增部门",notes = "<span style='color:red;'>描述：</span>新增部门")
    public ResultData insert(@RequestBody Dept dept){
        return springCloudService.insertDept(dept);
    }
    @PostMapping("/update")
    @ApiOperation(value = "修改部门",notes = "<span style='color:red;'>描述：</span>修改部门")
    public ResultData update(@RequestBody Dept dept){
        return springCloudService.updateDept(dept);
    }
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除部门",notes = "<span style='color:red;'>描述：</span>删除部门")
    public ResultData delete(@RequestBody Dept dept){
        return springCloudService.deleteDept(dept);
    }


    @GetMapping("/deptList")
    @ApiOperation(value = "测试Redis查询部门",notes = "测试Redis查询部门")
    public ResultData deptList(){
        return springCloudService.deptList();
    }

    @DeleteMapping ("/deleteBatchDept")
    @ApiOperation(value = "批量删除部门",notes = "<span style='color:red;'>描述：</span>批量删除部门")
    public ResultData deleteBatchDept(@RequestBody List<Dept> ids){
        return springCloudService.deleteBatchDept(ids);
    }

    @PostMapping("/selectAndSearch")
    @ApiOperation(value = "搜索+查询部门",notes = "<span style='color:red;'>描述：</span>搜索+查询部门")
    public ResultData selectAndSearch(@RequestBody DeptVo deptVo){
        return springCloudService.selectAndSearch(deptVo);
    }


}
