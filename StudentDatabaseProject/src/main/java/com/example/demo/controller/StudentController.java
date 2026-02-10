package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Student;
import com.example.demo.service.Student_Service;

@Controller
public class StudentController {
	
	@Autowired
	Student_Service studService;

	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@PostMapping("/studetails")
	@ResponseBody
	public Student details(@RequestParam int rollNo, @RequestParam String name, @RequestParam String gender, @RequestParam int age, @RequestParam String email) {
		
		 return studService.serviceStudent(rollNo, name, gender, age, email);
	}
}
