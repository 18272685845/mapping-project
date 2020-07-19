package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.MappingProject;
import com.aaa.service.MappingProjectService;
import com.aaa.vo.InsertProjectVo;
import com.aaa.vo.MappingProjectVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 郭航宇
 * @Date 15:10 2020/7/18
 * Description:
 **/
@RestController
public class MappingProjectController extends CommonController<MappingProject> {

    @Autowired
    private MappingProjectService mappingProjectService;
    @Override
    public BaseService<MappingProject> getBaseService() {
        return mappingProjectService;
    }
    /**
     * 带条件查询的 分页查询项目信息
     * @param mappingProjectVo
     * @return
     */
    @PostMapping("/selectMappingProjectByPage")
    public ResultData selectMappingProjectByPage(@RequestBody MappingProjectVo mappingProjectVo){
        PageInfo pageInfo = mappingProjectService.selectMappingProjectByPage(mappingProjectVo);
        if (pageInfo.getList().size()>0){
            return selectSuccess(pageInfo);
        }
        return selectFailed();
    }
    /**
     * 新增项目信息
     * @return
     */
    @PostMapping("/insertMappingProject")
    public ResultData insertMappingProject(@RequestBody InsertProjectVo insertProjectVo){
        Integer integer = mappingProjectService.insertMappingProject(insertProjectVo);
        if (integer > 0){
            return insertRoleSuccess();
        }
        return insertRoleFailed();
    }
    /**
     * 修改项目信息
     * @return
     */
    @PostMapping("/updateMappingProject")
    public ResultData updateMappingProject(@RequestBody MappingProject mappingProject){
        Integer integer = mappingProjectService.updateMappingProject(mappingProject);
        if (integer > 0){
            return updateDataSuccess();
        }
        return updateDataFailed();
    }
    /**
     * 根据项目id修改项目提交状态
     * @param id
     * @return
     */
    @GetMapping("/updateProjectResultsStatusById")
    public ResultData updateProjectResultsStatusById(@RequestParam("id") Long id){
        Integer integer = mappingProjectService.updateProjectResultsStatusById(id);
        if (integer > 0){
            return updateDataSuccess();
        }
        return updateDataFailed();
    }

}
