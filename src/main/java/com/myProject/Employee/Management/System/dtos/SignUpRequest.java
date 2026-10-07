package com.myProject.Employee.Management.System.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record SignUpRequest(
        @NotNull(message = "username is required")
        @Size(min = 2,max = 50,message = "min is 2 and max is 50")
        String username,
        @NotNull(message = "password is required")
        @Size(min = 2,max = 50,message = "min is 2 and max is 50")
        String password,
        @NotNull(message = "empId is required")
        UUID employeeId
) {
}
