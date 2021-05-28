package com.shah.userregistration.service;

import com.shah.userregistration.entity.UserLoginDetails;
import com.shah.userregistration.model.UserCredentials;
import com.shah.userregistration.repository.UserLoginDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserLoginDetailsService {
    @Autowired
    UserLoginDetailsRepository userLoginDetailsRepository;

    @Value("${url.authentication-base-url}")
    private String authenticationBaseUrl;

    @Autowired
    RestTemplate restTemplate;


    public UserLoginDetails saveLoginDetails(UserLoginDetails userLoginDetails) {
        return userLoginDetailsRepository.save(userLoginDetails);
    }


    public UserCredentials saveUserCredentials(UserCredentials userCredentials) {
        ResponseEntity<UserCredentials> responseEntity =
                restTemplate.postForEntity(authenticationBaseUrl, userCredentials, UserCredentials.class);
        return userCredentials;
    }

    public Long fetchUserIdByUsername(String username) {
        return userLoginDetailsRepository.getOne(username).getUserId();
    }
}
