package com.example.dao;

import java.util.List;

import com.example.entity.Employee;

public interface EmployeeDao {

	public void addEmployee(Employee employee);
	
	public Employee getEmployeebyId(int id);
	
	public List<Employee> getAllEmployee();
}
