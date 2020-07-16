package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.Dict;
import com.aaa.service.TDictService;
import com.aaa.vo.DictVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DictController extends CommonController<Dict> {

    @Autowired
    private TDictService dictService;

    @Override
    public BaseService<Dict> getBaseService() {
        return dictService;
    }

    /**
     * 分页查询字典列表
     * @param dictVo
     * @return
     */
    @PostMapping("/selectPageDict")
    public ResultData selectPageDict(@RequestBody DictVo dictVo){
        PageInfo<Dict> dictPageInfo = dictService.selectPageDict(dictVo);
        if (dictPageInfo!=null){
            return super.selectSuccess(dictPageInfo);
        }
        return super.selectFailed();
    }

    /**
     * 根据id查询字典
     * @param dict
     * @return
     */
    @PostMapping("/selectById")
    public ResultData selectById(@RequestBody Dict dict){
        Dict selectById = dictService.selectById(dict);
        if (selectById!=null){
            return selectSuccess(selectById);
        }
        return selectFailed();
    }

    /**
     * 根据id修改字典信息
     * @param dict
     * @return
     */
    @PostMapping("/updateById")
    public ResultData updateById(@RequestBody Dict dict){
        Integer updateById = dictService.updateById(dict);
        if (updateById>0){
            return updateDataSuccess();
        }
        return updateDataFailed();
    }

    /**
     * 添加字典信息
     * @param dict
     * @return
     */
    @PostMapping("/addDict")
    public ResultData addDict(@RequestBody Dict dict){
        Integer addDict = dictService.addDict(dict);
        if (addDict>0){
            return addDataSuccess();
        }
        return addDataFailed();
    }

    /**
     * 批量删除字典信息
     * @param ids
     * @return
     */
    @PostMapping("/deleteBatchByIds")
    public ResultData deleteBatchByIds(@RequestBody List<Integer> ids){
        Integer deleteBatchByIds = dictService.deleteBatchByIds(ids);
        if (deleteBatchByIds>0){
            return delDataSuccess("批量删除成功");
        }
        return delDataFailed("批量删除失败");
    }

}
