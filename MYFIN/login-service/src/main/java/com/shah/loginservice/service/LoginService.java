package com.shah.loginservice.service;

import com.shah.loginservice.VO.LoginInputVO;
import com.shah.loginservice.util.LoginUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginService {

    @Autowired
    LoginUtil loginUtil;

    public boolean loginAndAuthenticateUser(LoginInputVO loginInputVO) throws Exception {
        boolean isUserAuthenticated = false;
        log.info("Reached loginAndAuthenticateUser in Service");
        try{
            Long userId = loginUtil.getUserIdFromUsername(loginInputVO.getUsername());

            loginInputVO.setUserId(userId);
            isUserAuthenticated = loginUtil.authenticateUser(loginInputVO);
        }catch (Exception e){
            throw new Exception("User Authentication Failed for "+loginInputVO.getUsername()+" ",e);
        }

        return isUserAuthenticated;
    }
}
