package com.aaa.service;

import com.aaa.base.BaseService;

import com.aaa.mapper.DeptMapper;
import com.aaa.model.Dept;
import com.aaa.redis.RedisService;
import com.aaa.vo.DeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author 王登辉
 * @date 2020/7/23
 * 
**/
@Service
public class DeptService extends BaseService <Dept>{

    @Autowired
    private DeptMapper deptMapper;
    /**
     * 测试redis查询
     * redis
     */
    public List<Dept> deptList(RedisService redisService){
        List<Dept> selectAll = deptMapper.selectAll();
        redisService.set("selectAll2", selectAll,"nx",null,null);
        return selectAll;
    }

    /**
     * 批量删除部门
     * @return
     */
    public Integer deleteBatchDept(List<Dept> ids){
        return deptMapper.deleteBatchDept(ids);
    }

    /**
     * 搜索+查询
     * @param deptVo
     * @return
     */
    public List<Dept> selectAndSearch(DeptVo deptVo){
        List<Dept> deptList = deptMapper.selectAndSearch(deptVo);
        if (deptList != null){
            for (Dept dept : deptList) {
                Long deptId = dept.getDeptId();
                deptVo.setParentId(null);
                deptVo.setParentId(deptId);
                List<Dept> deptList1 = selectAndSearch(deptVo);
                dept.setDeptList(deptList1);
            }
            return deptList;
        }else {
            return null;
        }
    }



}
