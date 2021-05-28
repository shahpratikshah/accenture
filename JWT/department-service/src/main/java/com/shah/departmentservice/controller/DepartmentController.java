package com.shah.departmentservice.controller;

import com.shah.departmentservice.Service.DepartmentService;
import com.shah.departmentservice.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable(value = "id") Long departmentId){
        return departmentService.findByDepartmentId(departmentId);
    }
}
