package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.ResultCommitMapper;
import com.aaa.model.ResultCommit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LQY
 * @date 2020-07-18 11:30
 */
@Service
public class ResultCommitService extends BaseService<ResultCommit> {

    @Autowired
    private ResultCommitMapper resultCommitMapper;

    /**
     * 根据用户编号查找汇交结果
     * @param num
     * @return
     */
    public List<ResultCommit> selectResultCommitByNum(String num){
        List<ResultCommit> resultCommits = resultCommitMapper.selectResultCommitByNum(num);
        if(resultCommits != null && resultCommits.size() > 0){
            return resultCommits;
        }
        return null;
    }
}
