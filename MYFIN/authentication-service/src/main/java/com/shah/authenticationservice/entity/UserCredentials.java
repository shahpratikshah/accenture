package com.shah.authenticationservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCredentials {
    @Id
    private Long userId;
    private String password;
    private Integer invalidAttempts;
    private Boolean loginEnabled;
}
