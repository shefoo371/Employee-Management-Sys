package com.myProject.Employee.Management.System.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DepartmentCreate(@NotNull(message ="first name is required ")
                               @Size(min=2,max=20,message = "name from 2 to 20")
                               String name) {
}
