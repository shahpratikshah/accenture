package com.shah.loginservice.controller;

import com.shah.loginservice.VO.LoginInputVO;
import com.shah.loginservice.VO.LoginOutputVO;
import com.shah.loginservice.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;


    @PostMapping("/")
    public LoginOutputVO loginUser(@RequestBody LoginInputVO loginInputVO) throws Exception {
        LoginOutputVO loginOutputVO = new LoginOutputVO();
        log.info("Reached loginUser in controller");

        boolean isUserAuthenticated =  loginService.loginAndAuthenticateUser(loginInputVO);

        return loginOutputVO;
    }

}
