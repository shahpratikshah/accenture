package com.shah.departmentservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    private Integer departmentId;
    private String departmentName;
    private String departmentCode;

}
