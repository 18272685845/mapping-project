package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.ResultCommitMapper;
import com.aaa.model.ResultCommit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.aaa.model.ResultCommit;
import com.aaa.utils.IdUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

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
    public List<ResultCommit> selectResultCommitByNum(String num) {
        List<ResultCommit> resultCommits = resultCommitMapper.selectResultCommitByNum(num);
        if (resultCommits != null && resultCommits.size() > 0) {
            return resultCommits;
        }
        return null;
    }

    /**
     * 新增项目汇交表
     * @param resultCommit
     * @return
     */
    public Integer insertResultCommit(ResultCommit resultCommit,Long refId ){
        resultCommit.setCreateDate(new Date());
        resultCommit.setRefId(refId);
        resultCommit.setId(IdUtils.getLongID());
        Integer add = super.add(resultCommit);
        if (add >0){
            return add;
        }
        return null;
    }
}
