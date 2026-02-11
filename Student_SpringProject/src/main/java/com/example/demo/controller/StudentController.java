package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	StudentService studentServ;
	
	
	public StudentController(StudentService studentServ) {
		super();
		this.studentServ = studentServ;
	}

	@PostMapping("/create")
	public String create(@RequestBody Student st) {
		studentServ.createStudent(st);
		return "Student is create";
	}
	
	@GetMapping("/get/{rollNo}")
	public Student get(@PathVariable int rollNo) {
		Student st=studentServ.getStudent(rollNo);
		return st;
	}
	
	@GetMapping("/getall")
	public List<Student> getAll() {
		return studentServ.getAllStudent();
		
	}
	
	@PutMapping("/update")
	public String update(@RequestBody Student st) {
		studentServ.updateStudent(st);
		return "Updated the Student";
	}
	
	@DeleteMapping("/delete/{rollNo}")
	public String delete(@PathVariable int rollNo) {
		studentServ.deleteStudent(rollNo);
		return "Deleted successfully";
	}
	@GetMapping("/getemail/{email}")
	public Student getStudentbyEmail(@PathVariable String email) {
		return studentServ.getStudentbyEmail(email);
	}
}
