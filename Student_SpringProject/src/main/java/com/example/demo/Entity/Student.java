package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Student {
@Id
int rollNo;
@Column
String name;
@Column
String gender;
@Column
int age;
@Column
String email;

public Student() {
	super();
	// TODO Auto-generated constructor stub
}

public Student(int rollNo, String name, String gender, int age, String email) {
	super();
	this.rollNo = rollNo;
	this.name = name;
	this.gender = gender;
	this.age = age;
	this.email = email;
}

public int getRollNo() {
	return rollNo;
}

public void setRollNo(int rollNo) {
	this.rollNo = rollNo;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}


}
