package com.shah.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private Integer userId;
    private String firstName;
    private String lastName;
    private String address;
    private Integer departmentId;
}
