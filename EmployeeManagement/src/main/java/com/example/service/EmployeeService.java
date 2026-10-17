package com.example.service;

import com.example.entity.Employee;

public interface EmployeeService {

	public void addEmployee(Employee employee);
	
	public Employee getEmployeeById(int id);
	
	public String login(String uname, String pass);
}
