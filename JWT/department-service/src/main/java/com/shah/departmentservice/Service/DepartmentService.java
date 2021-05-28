package com.shah.departmentservice.Service;

import com.shah.departmentservice.entity.Department;
import com.shah.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department findByDepartmentId(Long departmentId) {
        return departmentRepository.findByDepartmentId(departmentId);

    }
}
