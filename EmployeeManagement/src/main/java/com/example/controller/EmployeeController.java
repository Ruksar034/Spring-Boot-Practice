package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Employee;
import com.example.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	public EmployeeService employeeService;
	
	
	@GetMapping("/")
	public String homepage() {
		
		return "index";
	}
	
	
	@GetMapping("/reg")
	public String register(@ModelAttribute Employee employee) {
		
		System.out.println("Register Called....." +employee);
		
		employeeService.addEmployee(employee);
		return "success";
	}
	
	@GetMapping("/search")
	public String getEmployeeById(@RequestParam("id") int id, Model model) {
		
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employeeById", employee);
		return "fetch";
	}
	
	@GetMapping("/log")
	public String login(@RequestParam("username")String uname, @RequestParam("password")String pass) {
		String response = employeeService.login(uname, pass);
		return response;
	}
}
