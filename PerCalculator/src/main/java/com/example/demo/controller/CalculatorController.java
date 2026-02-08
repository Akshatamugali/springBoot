package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.CalculatorService;
@Controller
public class CalculatorController {

	@Autowired
	CalculatorService calService;
	
	@GetMapping("/")
	public String home() {
		return "Percentage";
	}
	
	@PostMapping("/calc")
	public String submitName(@RequestParam String username, @RequestParam int m1, @RequestParam int m2, @RequestParam int m3, Model model) {
		double Result = calService.calculatePer(m1, m2, m3);
		model.addAttribute("name", username);
		model.addAttribute("per", Result);
		return "Result";
	}
}
