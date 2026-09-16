package com.myProject.Employee.Management.System.dtos;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.UUID;

public record EmployeeCreate(
        @NotNull(message ="first name is required ")
        @Size(min=2,max=20,message = "name from 2 to 20")
         String firstName,

        @NotNull(message ="last name is required ")
        @Size(min=2,max=20,message = "name from 2 to 20")
         String lastName,

        @NotNull
        @Email
        String email,

        @NotNull
        @Pattern(regexp = "^\\+?[0-9]{10,15}$")
        String phoneNumber,

        @NotNull
        @PastOrPresent
        LocalDate hireDate,

        @NotNull
        String position,

        @NotNull
        UUID departmentId
) {

}
