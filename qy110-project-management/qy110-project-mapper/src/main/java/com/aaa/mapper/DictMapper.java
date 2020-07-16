package com.aaa.mapper;

import com.aaa.model.Dict;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface DictMapper extends Mapper<Dict> {
    /**
     * 批量删除字典信息
     * @return
     */
    public Integer deleteBachById(List<Integer> ids);
}
