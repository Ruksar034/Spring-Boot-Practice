package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired 
	public SessionFactory sf;
	
	@Override
	public void addEmployee(Employee employee) {
		
		Session session= sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(employee);
		tx.commit();
		System.out.println("Employee Saved...!");
	}

	
	@Override
	public Employee getEmployeebyId(int id) {

		Session session = sf.openSession();
		Employee emp = (Employee)session.get(Employee.class, id);
		return emp;
	}


	@Override
	public List<Employee> getAllEmployee() {
		Session session = sf.openSession();
		Query<Employee> query = session.createQuery("from Employee");
		List<Employee> listOfEmployee = query.getResultList();
		return listOfEmployee;
	}

}
