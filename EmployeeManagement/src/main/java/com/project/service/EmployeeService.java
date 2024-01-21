package com.project.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.project.entity.Employee;

public interface EmployeeService {

	public ResponseEntity<String> addEmployee(Employee employee);

	public ResponseEntity<List<Employee>> findAllEmployees();
	
	public ResponseEntity<String> updateEmployee(Long id,Employee employee);
	
	public ResponseEntity<String> deleteEmployee(Long id);
	
	public ResponseEntity<Employee> findEmployeeById(Long id);
}
