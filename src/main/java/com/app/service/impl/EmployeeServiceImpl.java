package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Model.Employee;
import com.app.dao.EmployeeDao;
import com.app.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	@Autowired
	public EmployeeDao employeeDao;
	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return this.employeeDao.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		try {

			Employee employee= this.employeeDao.getById(id);
			System.out.println(employee);
			return employee;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Not found");
			return null;
		}
		
	}

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return this.employeeDao.save(employee);
	}

	@Override
	public Employee updatEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return this.employeeDao.save(employee);
	}

	@Override
	public Employee getEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return  this.employeeDao.getEmployeeByName(name);
	}

	@Override
	public List<Employee> getEmployeesByDesignation(String designation) {
		// TODO Auto-generated method stub
		return this.employeeDao.getEmployeeByDesignation(designation);
	}

	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		this.employeeDao.deleteById(id);
		
	}

}
