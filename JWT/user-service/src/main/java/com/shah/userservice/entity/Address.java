package com.shah.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String addLine1;
    private String addLine2;
    private String pinCode;
    private String city;
}
