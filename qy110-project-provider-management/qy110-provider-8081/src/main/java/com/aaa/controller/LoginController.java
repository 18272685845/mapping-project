package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.User;
import com.aaa.service.LoginService;
import com.aaa.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.aaa.status.LoginStatus.*;

@RestController
public class LoginController extends CommonController<User> {

    @Autowired
    private LoginService loginService;
    @Override
    public BaseService<User> getBaseService() {
        return loginService;
    }

    /**
     * 登陆操作
     * @param user
     * @return
     */
    @PostMapping("/doLogin")
    public ResultData doLogin(@RequestBody User user){
        TokenVo tokenVo = loginService.doLogin(user);
        if (tokenVo.getIfSuccess()){
            return loginSuccess(LOGIN_SUCCESS.getMsg());
        }else if (tokenVo.getType()== 1){
            return loginFailed(USER_NOT_EXIST.getMsg());
        }else if (tokenVo.getType()== 2){
            return loginFailed(PASSWORD_WRONG.getMsg());
        }else {
            return loginFailed(SYSTEM_EXCEPTION.getMsg());
        }

    }


}
