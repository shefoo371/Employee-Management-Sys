package com.myProject.Employee.Management.System.abstracts;

import com.myProject.Employee.Management.System.dtos.DepartmentCreate;
import com.myProject.Employee.Management.System.entities.Department;

import java.util.List;
import java.util.UUID;

public interface DepartmentService {
    Department findOne(UUID departmentId);

    List<Department> findAll();

    Department createOne(DepartmentCreate department);

    void deleteOne(UUID departmentId);
}
