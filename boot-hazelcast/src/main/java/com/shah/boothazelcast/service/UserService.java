package com.shah.boothazelcast.service;

import com.shah.boothazelcast.entity.UserAccount;
import com.shah.boothazelcast.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserAccount getUser(String accountNumber) {
        log.info("Fetching the user from DB");
        return userRepository.findUserAccountByAccountNumber(accountNumber);
    }

    public Long createUser(UserAccount userAccount) {
       return userRepository.save(userAccount).getId();
    }

    public UserAccount deleteByAccountNumber(String accountNumber) {
        return userRepository.deleteByAccountNumber(accountNumber);
    }

    public UserAccount updateUser(UserAccount userAccount) {
        UserAccount account = userRepository.findUserAccountByAccountNumber(userAccount.getAccountNumber());
        account.setBalance(userAccount.getBalance());
        return userRepository.save(account);
    }

    public List<UserAccount> loadToMap(){
      return  userRepository.findAll();
    }
}
