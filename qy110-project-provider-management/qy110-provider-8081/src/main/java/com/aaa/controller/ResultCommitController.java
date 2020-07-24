package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.ResultCommit;
import com.aaa.service.ResultCommitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LQY
 * @date 2020-07-18 11:30
 * 项目成果汇交
 */
@RestController
public class ResultCommitController extends CommonController<ResultCommit> {

    @Autowired
    private ResultCommitService resultCommitService;

    @Override
    public BaseService<ResultCommit> getBaseService() {
        return resultCommitService;
    }

    /**
     * 根据用户编号查找汇交结果
     * @param num
     * @return
     */
    @GetMapping("/selectResultCommitByNum")
    public ResultData selectResultCommitByNum(@RequestParam("num") String num){
        List<ResultCommit> resultCommits = resultCommitService.selectResultCommitByNum(num);
        if(resultCommits != null && resultCommits.size() > 0){
            return selectSuccess(resultCommits);
        }
        return selectFailed();
    }


}
