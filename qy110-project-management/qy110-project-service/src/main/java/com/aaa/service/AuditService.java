package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.AuditMapper;
import com.aaa.model.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author LQY
 * @date 2020-07-18 15:07
 */
@Service
public class AuditService extends BaseService<Audit> {
    @Autowired
    private AuditMapper auditMapper;

    /**
     * 根据用户编号查找审核记录
     * @param num
     * @return
     */
    @PostMapping("/selectAuditByNum")
    public List<Audit> selectAuditByNum(String num){
        List<Audit> audits = auditMapper.selectAuditByNum(num);
        if(null != audits && 0 < audits.size()){
            return audits;
        }
        return null;
    }
}
