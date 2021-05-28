package com.shah.userregistration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCredentials {
    private Long userId;
    private String password;
    private Integer invalidAttempts;
    private Boolean loginEnabled;
}

