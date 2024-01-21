package com.project.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.entity.Employee;

@RequestMapping(path = "/employee")
public interface EmployeeController {
	
	@PostMapping("/addemployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee);
	
	@GetMapping("/allemployees")
	public ResponseEntity<List<Employee>> findAllEmployee();
	
	@PutMapping("/updateemployee/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable Long id,@RequestBody Employee employee);
	
	@DeleteMapping("/deleteemployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id);
	
	@GetMapping("/employeebyid/{id}")
	public ResponseEntity<Employee> findEmployeeById(@PathVariable Long id);

}
