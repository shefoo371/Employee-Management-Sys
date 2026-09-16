package com.myProject.Employee.Management.System.controller;

import com.myProject.Employee.Management.System.abstracts.EmployeeService;
import com.myProject.Employee.Management.System.dtos.EmployeeCreate;
import com.myProject.Employee.Management.System.dtos.EmployeeUpdate;
import com.myProject.Employee.Management.System.entities.Employee;
import com.myProject.Employee.Management.System.shared.CustomeResException;
import com.myProject.Employee.Management.System.shared.GlobalResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<GlobalResponse<List<Employee>>> getEmployees() {
        List<Employee> employees=employeeService.findAll();
        return new ResponseEntity<>(new GlobalResponse<>(employees), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GlobalResponse<Employee>> addEmployee(@RequestBody @Valid EmployeeCreate employee) {
        Employee newEmployee=employeeService.createOne(employee);

       return new ResponseEntity<>(new GlobalResponse<>(newEmployee),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable UUID id) {
        Employee employee = employeeService.findOne(id);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable UUID id) {
        employeeService.deleteOne(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalResponse<Employee>> updateEmployee(@RequestBody @Valid EmployeeUpdate employee, @PathVariable UUID id) {
        Employee currentEmployee=employeeService.updateOne(id,employee);
        return new ResponseEntity<>(new GlobalResponse<>(currentEmployee),HttpStatus.OK);
    }

}
