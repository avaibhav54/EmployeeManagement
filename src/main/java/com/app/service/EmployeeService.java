package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.Model.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();
	public Employee getEmployeeById(long id);
	public Employee addEmployee(Employee employee);
	public Employee updatEmployee(Employee employee);
	public Employee getEmployeeByName(String name);
	public List<Employee> getEmployeesByDesignation(String designation);
	public void deleteEmployee(long id);
	
}
