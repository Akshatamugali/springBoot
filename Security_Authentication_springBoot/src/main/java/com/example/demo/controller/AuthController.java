package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.userRequest;
import com.example.demo.entity.User;
import com.example.demo.service.AuthService;

@RestController
public class AuthController {

	
	AuthService ser;

	public AuthController(AuthService ser) {
		super();
		this.ser = ser;
	}
	
	@PostMapping("/login")
	public String login(@RequestBody userRequest userreq) {
		return ser.checkUser(userreq);
	}
}
