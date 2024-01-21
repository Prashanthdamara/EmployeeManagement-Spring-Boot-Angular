package com.project.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.entity.Employee;
import com.project.repository.EmployeeRepo;
import com.project.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public ResponseEntity<String> addEmployee(Employee employee) {
		try {
			String empId = UUID.randomUUID().toString();
			employee.setEmployeeCode(empId);
			employeeRepo.save(employee);
			return new ResponseEntity<String>("Employee Added Successfully", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Something Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<List<Employee>> findAllEmployees() {
		try {
			return new ResponseEntity<List<Employee>>(employeeRepo.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> updateEmployee(Long id, Employee employee) {
		try {
			Optional<Employee> optional = employeeRepo.findById(id);
			if (optional.isPresent()) {
				Employee existEmployee = optional.get();
				existEmployee.setEmail(employee.getEmail());
				existEmployee.setImageUrl(employee.getImageUrl());
				existEmployee.setJobTitle(employee.getJobTitle());
				existEmployee.setName(employee.getName());
				existEmployee.setPhone(employee.getPhone());
				employeeRepo.save(existEmployee);
				return new ResponseEntity<String>("Employee Updated Sucessfully", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Employee id not exist", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Something Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> deleteEmployee(Long id) {
		try {
			Optional<Employee> optional = employeeRepo.findById(id);
			if(optional.isPresent()) {
				employeeRepo.deleteById(id);
				return new ResponseEntity<String>("Employee Deleted Successfully",HttpStatus.OK);
			}else {
				return new ResponseEntity<String>("Employee id not exist", HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Something Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<Employee> findEmployeeById(Long id) {
		try {
			Optional<Employee> optional = employeeRepo.findById(id);
			if(optional.isPresent()) {
				Employee employee = optional.get();
				return new ResponseEntity<Employee>(employee,HttpStatus.OK);
			}else {
				return new ResponseEntity<>(new Employee(), HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new Employee(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
