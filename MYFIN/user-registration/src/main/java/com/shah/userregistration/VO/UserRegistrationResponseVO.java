package com.shah.userregistration.VO;

import com.shah.userregistration.entity.UserLoginDetails;
import com.shah.userregistration.entity.UserPersonalDetails;
import com.shah.userregistration.model.UserCredentials;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationResponseVO {
    private UserLoginDetails userLoginDetails;
    private UserPersonalDetails userPersonalDetails;
    private UserCredentials userCredentials;
}
