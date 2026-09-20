package com.myProject.Employee.Management.System.service;

import com.myProject.Employee.Management.System.abstracts.LeaveRequestService;
import com.myProject.Employee.Management.System.dtos.LeaveRequestCreate;
import com.myProject.Employee.Management.System.entities.Department;
import com.myProject.Employee.Management.System.entities.Employee;
import com.myProject.Employee.Management.System.entities.LeaveRequest;
import com.myProject.Employee.Management.System.repository.EmployeeRepo;
import com.myProject.Employee.Management.System.repository.LeaveRequestRepo;
import com.myProject.Employee.Management.System.shared.CustomeResException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LeaveRequestIml implements LeaveRequestService {
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    LeaveRequestRepo leaveRequestRepo;

    @Override
    public LeaveRequest createOne(LeaveRequestCreate leaveRequest, UUID employeeId) {
        LeaveRequest curleaveRequest=new LeaveRequest();
        Employee curemployee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> CustomeResException.ResourceNotFound("Employee with employeeId " + employeeId + " not found"));

        curleaveRequest.setEmployee(curemployee);
        curleaveRequest.setStatus("Pending");
        curleaveRequest.setReason(leaveRequest.reason());
        curleaveRequest.setStartDate(leaveRequest.startDate());
        curleaveRequest.setEndDate(leaveRequest.endDate());

        leaveRequestRepo.save(curleaveRequest);

        return curleaveRequest;
    }

    @Override
    public List<LeaveRequest> findAllByEmployeeId(UUID employeeId) {
       List<LeaveRequest> leaveRequests= leaveRequestRepo.findAllByEmployeeId(employeeId);
        return leaveRequests;
    }
}
