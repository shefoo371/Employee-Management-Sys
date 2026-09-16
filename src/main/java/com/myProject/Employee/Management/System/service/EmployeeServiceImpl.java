package com.myProject.Employee.Management.System.service;

import com.myProject.Employee.Management.System.abstracts.EmployeeService;
import com.myProject.Employee.Management.System.dtos.EmployeeCreate;
import com.myProject.Employee.Management.System.dtos.EmployeeUpdate;
import com.myProject.Employee.Management.System.entities.Department;
import com.myProject.Employee.Management.System.entities.Employee;
import com.myProject.Employee.Management.System.repository.DepartmentRepo;
import com.myProject.Employee.Management.System.repository.EmployeeRepo;
import com.myProject.Employee.Management.System.shared.CustomeResException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    DepartmentRepo departmentRepo;

    @Override
    public Employee findOne(UUID employeeId) {

        return employeeRepo.findById(employeeId)
                .orElseThrow(() -> CustomeResException.ResourceNotFound("Employee with id " + employeeId + " not found"));
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public void deleteOne(UUID employeeId) {
        Optional<Employee> employee = employeeRepo.findById(employeeId);
        employee.ifPresent(value -> employeeRepo.deleteById(value.getId()));
    }

    @Override
    public Employee updateOne(UUID id, EmployeeUpdate employee) {
        Employee curemployee = employeeRepo.findById(id)
                .orElseThrow(() -> CustomeResException.ResourceNotFound("Employee with id " + id + " not found"));

        curemployee.setFirstName(employee.firstName());
        curemployee.setLastName(employee.lastName());
        curemployee.setPosition(employee.position());
        curemployee.setPhoneNumber(employee.phoneNumber());

        employeeRepo.save(curemployee);
        return curemployee;
    }

    @Override
    public Employee createOne(EmployeeCreate newemployee) {
        Employee employee=new Employee();

        Department department=departmentRepo.findById(newemployee.departmentId())
                        .orElseThrow(()->CustomeResException.ResourceNotFound("Department with id " + newemployee.departmentId() + " not found") );

        employee.setFirstName(newemployee.firstName());
        employee.setLastName(newemployee.lastName());
        employee.setPosition(newemployee.position());
        employee.setHireDate(newemployee.hireDate());
        employee.setPhoneNumber(newemployee.phoneNumber());
        employee.setEmail(newemployee.email());
        employee.setDepartment(department);

        employeeRepo.save(employee);

        return employee;
    }
}
