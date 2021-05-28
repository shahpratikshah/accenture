package com.shah.userregistration.controller;

import com.shah.userregistration.VO.UserRegistrationResponseVO;
import com.shah.userregistration.entity.UserLoginDetails;
import com.shah.userregistration.entity.UserPersonalDetails;
import com.shah.userregistration.model.UserCredentials;
import com.shah.userregistration.service.UserLoginDetailsService;
import com.shah.userregistration.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/users")
public class UserRegistrationController {


    @Autowired
    UserRegistrationService userRegistrationService;

    @Autowired
    UserLoginDetailsService userLoginDetailsService;

    @GetMapping("/{username}")
    public Long getUserIdByUsername(@PathVariable(value = "username") String username){
        return userLoginDetailsService.fetchUserIdByUsername(username);
    }

    @PostMapping("/")
    @Transactional
    public UserRegistrationResponseVO registerUser(@RequestBody UserPersonalDetails userPersonalDetails) {
        userPersonalDetails = userRegistrationService.registerUser(userPersonalDetails);
        UserLoginDetails userLoginDetails = new UserLoginDetails();
        userLoginDetails.setUserId(userPersonalDetails.getUserId());
        userLoginDetails.setUsername(userPersonalDetails.getMobileNumber());
        UserLoginDetails userLoginDetailsResponse = userLoginDetailsService.saveLoginDetails(userLoginDetails);

        UserRegistrationResponseVO registrationResponseVO = new UserRegistrationResponseVO();
        registrationResponseVO.setUserLoginDetails(userLoginDetailsResponse);
        registrationResponseVO.setUserPersonalDetails(userPersonalDetails);

        UserCredentials userCredentials = new UserCredentials();

        userCredentials.setUserId(userPersonalDetails.getUserId());
        userCredentials.setInvalidAttempts(0);
        userCredentials.setLoginEnabled(false);
        userCredentials.setPassword("password");

        userCredentials = userLoginDetailsService.saveUserCredentials(userCredentials);


        registrationResponseVO.setUserCredentials(userCredentials);
        return registrationResponseVO;
    }
}
