package com.project.controllerImpl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.project.controller.EmployeeController;
import com.project.entity.Employee;
import com.project.service.EmployeeService;

@RestController
public class EmployeeControllerImpl implements EmployeeController{
	
	@Autowired
	private EmployeeService employeeService;

	@Override
	public ResponseEntity<String> addEmployee(Employee employee) {
		try {
			return employeeService.addEmployee(employee);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Something Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<List<Employee>> findAllEmployee() {
		try {
			return employeeService.findAllEmployees();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> updateEmployee(Long id, Employee employee) {
		try {
			return employeeService.updateEmployee(id, employee);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Something Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> deleteEmployee(Long id) {
		try {
			return employeeService.deleteEmployee(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Something Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<Employee> findEmployeeById(Long id) {
		try {
			return employeeService.findEmployeeById(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Employee>(new Employee(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
