package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.entity.UserOTP;
import com.example.demo.repository.UserOTPRepository;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	@Autowired
	UserOTPRepository userOTPRepo;
	@Autowired
	JavaMailSender mailSender;
	
	public void register(User user) {
		userRepo.save(user);
	}
	
	public boolean loginAndGenerateOTP(String email, String pssword) {
		User user = userRepo.findByEmail(email);
		if(user == null) {
			return false;
		}
		if(!user.getPassword().equals(pssword)) {
			return false;
		}
		
		int otp = new Random().nextInt(100000,1000000);
		String otpstr = String.valueOf(otp);
		
		UserOTP userotp = new UserOTP();
		userotp.setOtp(otpstr);
		userotp.setUserid(user.getId());
		userotp.setCreatedTime(LocalDateTime.now());
		userOTPRepo.save(userotp);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("Login otp");
		message.setText("Hello " + user.getName() + ". your otp for login authentication is: " + otpstr);
		
		mailSender.send(message);
		return true;
	}
	public boolean verifyOtp(String otp) {
		UserOTP userotp = userOTPRepo.findByOtp(otp);
		
		if(userotp == null) {
			return false;
		}
		LocalDateTime expiryTime = userotp.getCreatedTime().plusMinutes(2);
		if(LocalDateTime.now().isAfter(expiryTime)) {
			return false;
		}
		return true;
	}
}
