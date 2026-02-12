package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.userRequest;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.AuthRepository;

@Service
public class AuthService {

    private final AuthRepository authRepository;

    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public String checkUser(userRequest userreq) {

     User user = authRepository.findByName(userreq.getName()).orElse(null);
     if(user.getPassword().equals(userreq.getPassword())) {
    	 if(user.getRole() == Role.ADMIN) {
    		 return "Welcome Admin";
    	 } else {
    		 return "Welcome User";
    	 }
     }
     else {
    	  return "Invalid Credentials";
     }
    }
}
