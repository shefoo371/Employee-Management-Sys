package com.myProject.Employee.Management.System.service;

import com.myProject.Employee.Management.System.entities.UserAccount;
import com.myProject.Employee.Management.System.repository.UserAccountRepo;
import com.myProject.Employee.Management.System.shared.CustomeResException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDetailsServiceIml implements UserDetailsService {
    @Autowired
    private UserAccountRepo userAccountRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserAccount> userAccount=userAccountRepo.findOneByUsername(username);
        if(userAccount.isEmpty()){
            throw CustomeResException.BadCredentials();
        }
        UserAccount user=userAccount.get();

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole()).
                build();
    }
}
