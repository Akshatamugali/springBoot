package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Employee;
import com.example.demo.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	EmployeeRepository empRepo;
	
	public EmployeeService(EmployeeRepository empRepo) {
		super();
		this.empRepo = empRepo;
	}

	public void createEmployee(Employee emp) {
		empRepo.save(emp);
	}
	
	public Employee getEmployee(int empId) {
		Employee emp =empRepo.findById(empId).orElse(null);
		return emp;
	}
	
	public List<Employee> getAllEmployee() {
		List<Employee> list =empRepo.findAll();
		return list;
	}
	
	public void updateEmployee(Employee emp) {
		empRepo.save(emp);
	}
	
	public void deleteEmployee(int empId) {
		empRepo.deleteById(empId);
	}
}
