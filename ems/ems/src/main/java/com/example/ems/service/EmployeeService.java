package com.example.ems.service;

import java.util.List;

import com.example.ems.entity.Employee;
import com.example.ems.requestdto.EmployeeRequestDto;

public interface EmployeeService {
	Employee addEmployee(EmployeeRequestDto requestDto);
	Employee updateEmployee(Long id, EmployeeRequestDto requestDto);
	List<Employee> getAllEmployees();
	void deleteEmployee(Long id);
}
