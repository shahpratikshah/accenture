package com.shah.userservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department {
    private Integer departmentId;
    private String departmentName;
    private String departmentCode;
}
