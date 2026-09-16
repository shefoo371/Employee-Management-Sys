package com.myProject.Employee.Management.System.repository;

import com.myProject.Employee.Management.System.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DepartmentRepo extends JpaRepository<Department, UUID> {
}
