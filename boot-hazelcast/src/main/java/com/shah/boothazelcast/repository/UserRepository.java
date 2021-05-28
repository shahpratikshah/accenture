package com.shah.boothazelcast.repository;

import com.shah.boothazelcast.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserAccount, Long> {
    UserAccount findUserAccountByAccountNumber(String accountNumber);
    UserAccount deleteByAccountNumber(String accountNumber);
}
