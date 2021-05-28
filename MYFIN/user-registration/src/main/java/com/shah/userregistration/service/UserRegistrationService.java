package com.shah.userregistration.service;

import com.shah.userregistration.entity.UserPersonalDetails;
import com.shah.userregistration.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserRegistrationService {

    @Autowired
    UserRegistrationRepository userRegistrationRepository;

    public UserPersonalDetails registerUser(UserPersonalDetails userPersonalDetails) {
        return userRegistrationRepository.save(userPersonalDetails);

    }
}
