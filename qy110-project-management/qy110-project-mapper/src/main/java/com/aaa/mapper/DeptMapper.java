package com.aaa.mapper;


import com.aaa.model.Dept;

import com.aaa.vo.DeptVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


@Repository
public interface DeptMapper extends Mapper<Dept> {

    /**
     * 批量删除部门
     * @param ids
     * @return
     */
    public Integer deleteBatchDept(List<Dept> ids);


    /**
     * 查询+搜索
     * @param deptVo
     * @return
     */
    public List<Dept> selectAndSearch(DeptVo deptVo);


}