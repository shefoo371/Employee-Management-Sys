package com.myProject.Employee.Management.System.service;

import com.myProject.Employee.Management.System.abstracts.DepartmentService;
import com.myProject.Employee.Management.System.dtos.DepartmentCreate;
import com.myProject.Employee.Management.System.entities.Department;
import com.myProject.Employee.Management.System.entities.Employee;
import com.myProject.Employee.Management.System.repository.DepartmentRepo;
import com.myProject.Employee.Management.System.shared.CustomeResException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepo departmentRepo;

    @Override
    public Department findOne(UUID departmentId) {
        Department department=departmentRepo.findById(departmentId)
                .orElseThrow(() -> CustomeResException.ResourceNotFound(
                        "department with id " + departmentId + " not found")
                );

        return department;
    }

    @Override
    public List<Department> findAll() {
        return departmentRepo.findAll();
    }

    @Override
    public Department createOne(DepartmentCreate department) {
        Department nwdepartment=new Department();

        nwdepartment.setName(department.name());

          departmentRepo.save(nwdepartment);
          return nwdepartment;
    }

    @Override
    public void deleteOne(UUID departmentId) {
          departmentRepo.deleteById(departmentId);
    }
}
