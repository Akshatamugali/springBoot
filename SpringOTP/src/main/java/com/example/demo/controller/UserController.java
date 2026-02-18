package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
@Controller
public class UserController {

    @Autowired
    UserService userServ;

    // Show Register Page
    @GetMapping("/")
    public String displaySignUpPage() {
        return "index";
    }

    // Show Login Page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // Register User
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userServ.register(user);
        return "login";
    }

    // Process Login
    @PostMapping("/login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password) {

        boolean status = userServ.loginAndGenerateOTP(email, password);

        if(status) {
            return "otp";
        }

        return "login";
    }

    // Verify OTP
    @PostMapping("/verify-otp")
    public String verifyOTP(@RequestParam String otp) {

        boolean status = userServ.verifyOtp(otp);

        if(status) {
            return "dashboard";
        }

        return "login";
    }
}
