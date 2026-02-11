package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Student;
import java.util.List;


public interface StudentRepo extends JpaRepository<Student, Integer>{

	Student findByEmail(String email);
}
