package com.example.customException;

public class EmployeeCustomException extends RuntimeException{
	
	public EmployeeCustomException(String errormsg) {
		super(errormsg);
	}
}
