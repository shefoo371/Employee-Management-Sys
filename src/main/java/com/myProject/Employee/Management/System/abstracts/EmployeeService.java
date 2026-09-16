package com.myProject.Employee.Management.System.abstracts;

import com.myProject.Employee.Management.System.dtos.EmployeeCreate;
import com.myProject.Employee.Management.System.dtos.EmployeeUpdate;
import com.myProject.Employee.Management.System.entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    Employee findOne(UUID employeeId);

    List<Employee> findAll();

    void deleteOne(UUID employeeId);

    Employee updateOne(UUID employeeId, EmployeeUpdate employee);

    Employee createOne(EmployeeCreate employee);
}