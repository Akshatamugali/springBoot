package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.Calc_service;

@Controller
public class Calc_Control {

    @Autowired
    Calc_service service;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam int num1,
                             @RequestParam int num2,
                             @RequestParam String operation,
                             Model model) {

        int result = 0;
        String symbol = "";

        switch (operation) {
            case "add":
                result = service.add(num1, num2);
                symbol = "+";
                break;
            case "sub":
                result = service.sub(num1, num2);
                symbol = "-";
                break;
            case "mul":
                result = service.mul(num1, num2);
                symbol = "*";
                break;
            case "div":
                result = service.div(num1, num2);
                symbol = "/";
                break;
        }

        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("symbol", symbol);
        model.addAttribute("result", result);

        return "result";
    }
}