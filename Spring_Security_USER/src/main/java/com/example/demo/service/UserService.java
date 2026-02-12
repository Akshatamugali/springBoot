package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        super();
        this.userRepo = userRepo;
    }

    public String getName(User user) {
        User us = userRepo.findByName(user.getName());

        if (us == null) {
            return "User not found";
        }

        if (!us.getPassword().equals(user.getPassword())) {
            return "User credential is wrong";
        }

        return us.getRole().toString();
    }
}