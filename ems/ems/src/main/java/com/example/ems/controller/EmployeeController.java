package com.example.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ems.entity.Employee;
import com.example.ems.requestdto.EmployeeRequestDto;
import com.example.ems.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	//create employee
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeRequestDto requestDto){
		Employee response=employeeService.addEmployee(requestDto);
		if(response!=null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		
	}
	
	//get all employees
	@GetMapping("/")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees =employeeService.getAllEmployees();
		return ResponseEntity.status(HttpStatus.OK).body(employees);
		
	}
	
	//update employee
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id,@RequestBody EmployeeRequestDto requestDto){
		Employee response=employeeService.updateEmployee(id,requestDto);
		if(response!=null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		
	}
	
	//delete employee
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id){
		employeeService.deleteEmployee(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
}
