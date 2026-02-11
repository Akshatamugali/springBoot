package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepo;

@Service
public class StudentService {
	
	StudentRepo studentrepo;
	

	public StudentService(StudentRepo studentrepo) {
		super();
		this.studentrepo = studentrepo;
	}

	public void createStudent(Student stu) {
		studentrepo.save(stu);
	}
	
	public Student getStudent(int rollNo) {
		Student stu  =studentrepo.findById(rollNo).orElse(null);
		return stu;
	}
	
	public List<Student> getAllStudent() {
		List<Student> list = studentrepo.findAll();
		return list;
	}
	public void updateStudent(Student stu) {
		studentrepo.save(stu);
	}
	public void deleteStudent(int rollNo) {
		studentrepo.deleteById(rollNo);
	}
	
	public Student getStudentbyEmail(String email) {
		Student st=studentrepo.findByEmail(email);
		return st;
	}
}
