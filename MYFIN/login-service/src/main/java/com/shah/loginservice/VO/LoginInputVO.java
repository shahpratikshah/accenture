package com.shah.loginservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInputVO {
    private String username;
    private String password;
    private Long userId;
}
