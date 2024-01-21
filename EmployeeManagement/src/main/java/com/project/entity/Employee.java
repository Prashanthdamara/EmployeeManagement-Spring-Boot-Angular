package com.project.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Employee")
public class Employee implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false,updatable = false)
	private Long id;
	
	private String name;
	
	private String email;
	
	private String jobTitle;
	
	private String phone;
	
	private String imageUrl;
	
	@Column(nullable = false,updatable = false)
	private String employeeCode;
}