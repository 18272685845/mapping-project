package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.Dept;
import com.aaa.service.DeptService;
import com.aaa.redis.RedisService;
import com.aaa.vo.DeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Author 郭航宇
 * @Date 17:56 2020/7/8
 * Description:
 **/

@RestController
public class DeptController extends CommonController<Dept> {

    @Autowired
    private DeptService deptService;

    @Autowired
    private RedisService redisService;

    @Override
    public BaseService<Dept> getBaseService() {
        return deptService;
    }

    /**
     * 查询所有部门
     * @return
     */
    @GetMapping("/selectAllDept")
    public ResultData selectAllDept(){
        List<Dept> deptList = deptService.selectAll();
        if (deptList!=null){
            return selectSuccess(deptList);
        }

        return selectFailed();
    }

    /**
     * 添加部门
     * @param dept
     * @return
     */
    @PostMapping("/insertDept")
    public ResultData insertDept(@RequestBody Dept dept){
        Integer add = deptService.add(dept);
        if (add > 0){
            return addDataSuccess();
        }
        return addDataFailed();

    }

    /**
     * 修改部门
     * @param dept
     * @return
     */
    @PostMapping("/updateDept")
    public ResultData updateDept(@RequestBody Dept dept){
        Integer update = deptService.update(dept);
        if (update > 0){
            return updateDataSuccess();
        }
        return updateDataFailed();
    }

    /**
     * 根据主键删除部门
     * @param dept
     * @return
     */
    @DeleteMapping("/deleteDept")
    public ResultData deleteDept(@RequestBody Dept dept){
        Integer delete = deptService.delete(dept);
        if (delete > 0){
            return delDataSuccess();
        }
        return delDataFailed();
    }

    /**
     * redis测试
     * @return
     */
    @GetMapping("/deptList")
    public ResultData deptList(){
        List<Dept> deptList = deptService.deptList(redisService);
        if (deptList!=null){
            return selectSuccess(deptList);
        }
        return selectFailed();
    }

    /**
     * 批量删除dept
     * @param ids
     * @return
     */
    @DeleteMapping ("/deleteBatchDept")
    public ResultData deleteBatchDept(@RequestBody List<Dept> ids){
        Integer deleteBatchDept = deptService.deleteBatchDept(ids);
        if (deleteBatchDept>0){
            return delDataSuccess("批量删除成功");
        }
        return delDataFailed("批量删除失败");
    }

    /**
     * 搜索+查询
     * @param deptVo
     * @return
     */
    @PostMapping("/selectAndSearch")
    public ResultData selectAndSearch(@RequestBody DeptVo deptVo){
        List<Dept> selectAndSearch = deptService.selectAndSearch(deptVo);
        if (selectAndSearch.size() > 0){
            return selectSuccess(selectAndSearch);
        }else {
            return selectFailed();
        }
    }


}
