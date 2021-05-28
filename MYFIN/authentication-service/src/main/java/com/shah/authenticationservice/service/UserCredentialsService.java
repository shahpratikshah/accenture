package com.shah.authenticationservice.service;

import com.shah.authenticationservice.entity.UserCredentials;
import com.shah.authenticationservice.repository.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialsService {

    @Autowired
    UserCredentialsRepository userCredentialsRepository;

    public UserCredentials createCredentials(UserCredentials userCredentials) {
        return userCredentialsRepository.save(userCredentials);
    }

    public boolean authenticateCredentials(UserCredentials userCredentials) {
        return userCredentialsRepository.getOne(userCredentials.getUserId()).getPassword().equals(userCredentials.getPassword());
    }
}
