package com.shah.loginservice.repository;

import com.shah.loginservice.entity.LoginUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface LoginRepository extends JpaRepository<LoginUserDetails, String> {
}
