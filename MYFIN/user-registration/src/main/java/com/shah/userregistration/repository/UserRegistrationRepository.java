package com.shah.userregistration.repository;

import com.shah.userregistration.entity.UserPersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistrationRepository extends JpaRepository<UserPersonalDetails, Long> {

}
