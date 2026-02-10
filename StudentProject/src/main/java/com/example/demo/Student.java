package com.example.demo;

public class Student {
int rollNo;
String name;
String gender;
int age;
String email;

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
