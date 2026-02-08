package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	public double calculatePer(int m1, int m2, int m3) {
		int total = m1 + m2 + m3;
		double per = (total/300.0) * 100;
		return per;
	}
}
