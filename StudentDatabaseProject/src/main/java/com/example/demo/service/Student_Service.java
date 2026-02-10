package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.StudentRepo;
import com.example.demo.entity.Student;

@Service
public class Student_Service {

	@Autowired
	StudentRepo studentrepo;
	
	public Student serviceStudent(int rollNo, String name, String gender,int age,String email) {
		Student student = new Student(rollNo, name, gender, age, email);
		 return studentrepo.save(student);
	}
}
