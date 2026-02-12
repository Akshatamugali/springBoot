package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

    UserService userServ;

    public UserController(UserService userServ) {
        super();
        this.userServ = userServ;
    }

    @PostMapping("/check")
    public String check(@RequestBody User user) {
        return userServ.getName(user);
    }
}