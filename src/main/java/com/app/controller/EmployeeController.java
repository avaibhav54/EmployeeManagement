package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		 List<Employee> employees = this.employeeService.getEmployees();
		 if(employees.size()==0)
		 {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
		 return ResponseEntity.of(Optional.of(employees));
	}
	

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") String id)
	{
		long empid=Long.parseLong(id);
		System.out.println(empid);
		Employee employee= this.employeeService.getEmployeeById(empid);
		System.out.println(employee);
		if(employee==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(employee);
	}
	@GetMapping("/employeebyname/{name}")
	public ResponseEntity<Employee> getEmployeeByName(@PathVariable("name") String name)
	{
		Employee employeeByName=null;
		try {
			 employeeByName = this.employeeService.getEmployeeByName(name);
			 if(employeeByName!=null)
			 return ResponseEntity.ok(employeeByName);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Void> addEmployee(@RequestBody Employee employee)
	{
		
		System.out.println(employee);
		if(employee==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		try {
			Employee addEmployee = this.employeeService.addEmployee(employee);
			 return ResponseEntity.of(null);
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		
	}
	
	@PutMapping("/employee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
	{
		 try {
			 Employee updatEmployee = this.employeeService.updatEmployee(employee);
				
			 return ResponseEntity.ok(updatEmployee);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Void> deltetEmployee(@PathVariable("id") String id)
	{
		long empid=Long.parseLong(id);
		try {
			 this.employeeService.deleteEmployee(empid);
			 return ResponseEntity.ok().build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
				
	}


}
