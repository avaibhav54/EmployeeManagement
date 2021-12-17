package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Model.Employee;

public interface EmployeeDao extends JpaRepository<Employee,Long>{

	Employee getEmployeeByName(String name);

	List<Employee> getEmployeeByDesignation(String designation);

}
