package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.Student;

@Service
public class StudentDetails {

	public Student createStu(int rollNo, String name, String gender, int age, String email) {
		
		Student st = new Student(rollNo, name, gender, age, email);
		
		return st;
	}
}
