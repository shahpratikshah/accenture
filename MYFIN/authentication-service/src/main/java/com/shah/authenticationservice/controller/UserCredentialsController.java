package com.shah.authenticationservice.controller;

import com.shah.authenticationservice.entity.UserCredentials;
import com.shah.authenticationservice.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credentials")
public class UserCredentialsController {

    @Autowired
    UserCredentialsService userCredentialsService;

    @PostMapping("/")
    public UserCredentials createCredentials(@RequestBody UserCredentials userCredentials) {
        return userCredentialsService.createCredentials(userCredentials);
    }

    @PostMapping("/authenticate")
    public boolean authenticateCredentials(@RequestBody UserCredentials userCredentials) {
        return userCredentialsService.authenticateCredentials(userCredentials);
    }
}
