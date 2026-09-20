package com.myProject.Employee.Management.System.abstracts;

import com.myProject.Employee.Management.System.dtos.LeaveRequestCreate;
import com.myProject.Employee.Management.System.entities.LeaveRequest;

import java.util.List;
import java.util.UUID;

public interface LeaveRequestService {
    LeaveRequest createOne(LeaveRequestCreate leaveRequest, UUID employeeId);

    List<LeaveRequest> findAllByEmployeeId(UUID employeeId);
}
