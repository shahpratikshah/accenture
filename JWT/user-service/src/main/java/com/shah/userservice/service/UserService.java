package com.shah.userservice.service;

import com.shah.userservice.entity.User;
import com.shah.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findByUserId(Long userId) {
        return userRepository.findByUserId(userId);
    }
}
