package com.shah.userregistration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPersonalDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String firstName;
    private String lastName;
    private String address;
    @Email
    private String email;
    @NumberFormat
    private String mobileNumber;
    private String companyName;
    private String designation;

}
