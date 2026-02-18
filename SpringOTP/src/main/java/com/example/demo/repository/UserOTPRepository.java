package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserOTP;

public interface UserOTPRepository extends JpaRepository<UserOTP, Integer> {

	UserOTP findByOtp(String otp);
}
