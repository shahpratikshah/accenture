package com.shah.userregistration.repository;

import com.shah.userregistration.entity.UserLoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginDetailsRepository extends JpaRepository<UserLoginDetails, String> {
}
