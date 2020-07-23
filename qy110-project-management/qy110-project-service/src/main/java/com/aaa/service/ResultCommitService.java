package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.model.ResultCommit;
import com.aaa.utils.IdUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ResultCommitService extends BaseService<ResultCommit> {
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
