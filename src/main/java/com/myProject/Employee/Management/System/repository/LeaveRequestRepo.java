package com.myProject.Employee.Management.System.repository;

import com.myProject.Employee.Management.System.entities.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LeaveRequestRepo extends JpaRepository<LeaveRequest, UUID> {
    List<LeaveRequest> findAllByEmployeeId(UUID employeeId);
}
