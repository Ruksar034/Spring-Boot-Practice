package com.example.service;

import java.util.InputMismatchException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customException.EmployeeCustomException;
import com.example.dao.EmployeeDao;
import com.example.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeDao employeeDao;

	@Override
	public void addEmployee(Employee employee) {

		
//		employeeDao.addEmployee(employee);
		List<Employee> listOfEmployee = employeeDao.getAllEmployee();

		for (Employee employee2 : listOfEmployee) {
			System.out.println("Existing Email Id : " + employee2.getEmail());
			System.out.println("Existing Email Id : " + employee.getEmail());
			if (employee2.getEmail().equals(employee.getEmail())) {
				throw new EmployeeCustomException("Employee with given Email Already Registered...");
			} else {
				employeeDao.addEmployee(employee);
			}
		}
	}

	@Override
	public Employee getEmployeeById(int id) {

		Employee emp = employeeDao.getEmployeebyId(id);
		return emp;
	}

	@Override
	public String login(String uname, String pass) {
		if(uname.equalsIgnoreCase("Admin") && pass.equals("admin")) {
			return "success";
		}else {
			throw new InputMismatchException();
		}
	}

}
