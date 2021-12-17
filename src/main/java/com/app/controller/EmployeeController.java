package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.Model.Employee;
import com.app.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	public EmployeeService employeeService;
	@GetMapping("/employee")
	public List<Employee> getAllEmployees()
	{
		return this.employeeService.getEmployees();
	}
	

	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable("id") String id)
	{
		long empid=Long.parseLong(id);
		Employee employee= this.employeeService.getEmployeeById(empid);
		System.out.println(employee);
		return employee;
	}
	@GetMapping("/employeebyname/{name}")
	public Employee getEmployeeByName(@PathVariable("name") String name)
	{
		return this.employeeService.getEmployeeByName(name);
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		return this.employeeService.addEmployee(employee);
		 
	}
	
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee)
	{
		return this.employeeService.updatEmployee(employee);
	}
	
	
	@DeleteMapping("/employee/{id}")
	public void deltetEmployee(@PathVariable("id") String id)
	{
		long empid=Long.parseLong(id);
		 this.employeeService.deleteEmployee(empid);
				
	}


}
