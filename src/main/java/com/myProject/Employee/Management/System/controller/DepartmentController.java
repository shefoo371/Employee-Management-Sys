package com.myProject.Employee.Management.System.controller;

import com.myProject.Employee.Management.System.abstracts.DepartmentService;
import com.myProject.Employee.Management.System.dtos.DepartmentCreate;
import com.myProject.Employee.Management.System.dtos.EmployeeCreate;
import com.myProject.Employee.Management.System.entities.Department;
import com.myProject.Employee.Management.System.entities.Employee;
import com.myProject.Employee.Management.System.repository.DepartmentRepo;
import com.myProject.Employee.Management.System.service.DepartmentServiceImpl;
import com.myProject.Employee.Management.System.shared.GlobalResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
     @Autowired
     DepartmentServiceImpl departmentService;

     @Autowired
      DepartmentRepo  departmentRepo;

    @GetMapping
    public ResponseEntity<GlobalResponse<List<Department>>> getDepartments() {
        List<Department> departments=departmentService.findAll();
        return new ResponseEntity<>(new GlobalResponse<>(departments), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GlobalResponse<Department>> createOne(
            @RequestBody @Valid DepartmentCreate department) {
        Department newDepartment = departmentService.createOne(department);

        return new ResponseEntity<>(new GlobalResponse<>(newDepartment), HttpStatus.CREATED);
    }

    @GetMapping("/{depId}")
    public ResponseEntity<GlobalResponse<Department>> getOne(@PathVariable UUID depId){
        Department department=departmentService.findOne(depId);
        return new ResponseEntity<>(new GlobalResponse<>(department), HttpStatus.OK);
    }

    @DeleteMapping("/{depId}")
    public ResponseEntity<Void> deleteOne(@PathVariable UUID depID){
        departmentRepo.deleteById(depID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
