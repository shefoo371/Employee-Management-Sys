package com.myProject.Employee.Management.System.controller;

import com.myProject.Employee.Management.System.dtos.SignUpRequest;
import com.myProject.Employee.Management.System.entities.LeaveRequest;
import com.myProject.Employee.Management.System.service.AuthService;
import com.myProject.Employee.Management.System.shared.GlobalResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<GlobalResponse<String>> signup(
            @RequestBody @Valid SignUpRequest signUpRequest
            ){
        authService.signup(signUpRequest);
        return new ResponseEntity<>(new GlobalResponse<>("Signed up"), HttpStatus.OK);
    }

}
