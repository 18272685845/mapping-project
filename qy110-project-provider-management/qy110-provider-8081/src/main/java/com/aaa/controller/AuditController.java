package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.Audit;
import com.aaa.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LQY
 * @date 2020-07-18 15:06
 */
@RestController
public class AuditController extends CommonController<Audit> {

    @Autowired
    private AuditService auditService;

    @Override
    public BaseService<Audit> getBaseService() {
        return auditService;
    }

    /**
     * 根据用户编号查找审核记录
     * @param num
     * @return
     */
    @GetMapping("/selectAuditByNum")
    public ResultData selectAuditByNum(@RequestParam("num") String num){
        List<Audit> audits = auditService.selectAuditByNum(num);
        if(null != audits && 0 < audits.size()){
            return selectSuccess(audits);
        }
        return selectFailed();
    }


}
