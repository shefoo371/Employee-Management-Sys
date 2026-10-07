package com.myProject.Employee.Management.System.service;

import com.myProject.Employee.Management.System.dtos.SignUpRequest;
import com.myProject.Employee.Management.System.entities.Employee;
import com.myProject.Employee.Management.System.entities.UserAccount;
import com.myProject.Employee.Management.System.repository.EmployeeRepo;
import com.myProject.Employee.Management.System.repository.UserAccountRepo;
import com.myProject.Employee.Management.System.shared.CustomeResException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService  {
    @Autowired
    private UserAccountRepo userAccountRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void signup(SignUpRequest signUpRequest) {
        Employee employee = employeeRepo.findById(signUpRequest.employeeId())
                .orElseThrow(() ->
                        CustomeResException.ResourceNotFound(
                                "Employee with id " + signUpRequest.employeeId() + " not found"
                        ));

        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(signUpRequest.username());
        userAccount.setPassword(passwordEncoder.encode(signUpRequest.password()));
        userAccount.setEmployee(employee);

        userAccountRepo.save(userAccount);
    }


}
