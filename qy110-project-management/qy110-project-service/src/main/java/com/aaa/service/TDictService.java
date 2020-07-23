package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.DictMapper;
import com.aaa.model.Dict;
import com.aaa.vo.DictVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TDictService  extends BaseService<Dict> {
    @Autowired
    private DictMapper dictMapper;

    /**
     * 分页查询字典列表 带条件
     * @return
     */
    public PageInfo<Dict> selectPageDict(DictVo dictVo){
        if (dictVo.getPageNum()==null){
            dictVo.setPageNum(1);
        }
        if (dictVo.getPageSize()==null){
            dictVo.setPageSize(10);
        }
        PageInfo<Dict> dictPageInfo = selectListByPage(dictVo.getDict(), dictVo.getPageNum(), dictVo.getPageNum());
        return dictPageInfo;
    }

    /**
     * 根据id查询字典信息
     * @return
     */
    public Dict selectById(Dict dict){
        Dict selectOne = super.selectOne(dict);
        return selectOne;
    }

    /**
     * 根据id修改字典信息
     * @param dict
     * @return
     */
    public Integer updateById(Dict dict){
        return super.update(dict);
    }

    /**
     * 添加字典信息
     * @param dict
     * @return
     */
    public Integer addDict(Dict dict){
        return super.add(dict);
    }

    /**
     * 批量删除字典信息
     * @param ids
     * @return
     */
    public Integer deleteBatchByIds(List<Integer> ids){
       return dictMapper.deleteBachById(ids);
    }



}
