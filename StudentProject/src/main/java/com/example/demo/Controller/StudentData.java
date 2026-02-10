package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Student;
import com.example.demo.Service.StudentDetails;

@Controller
public class StudentData {

	@Autowired
	StudentDetails std;
	
	@GetMapping("/")
	public String home() {
		return "HtmlPage1";
	}
	
	@PostMapping("/studetails")
	@ResponseBody
	Student details(@RequestParam int rollNo, @RequestParam String name, @RequestParam String gender, @RequestParam int age, @RequestParam String email, Model m) {
		
		Student student = std.createStu(rollNo, name, gender, age, email);
		
		m.addAttribute("message", student);
		
		return student;
	}
}
