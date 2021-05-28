package com.shah.userservice.repository;

import com.shah.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer > {
    User findByUserId(Long userId);

}
