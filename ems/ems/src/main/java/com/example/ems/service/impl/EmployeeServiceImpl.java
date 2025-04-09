package com.example.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ems.entity.Employee;
import com.example.ems.repo.EmployeeRepository;
import com.example.ems.requestdto.EmployeeRequestDto;
import com.example.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(EmployeeRequestDto requestDto) {
		
		// TODO Auto-generated method stub
		try {
			if(requestDto.getFirstName()==null || requestDto.getFirstName().trim().isEmpty()) {
				throw new RuntimeException("First must not be blank");
			}
			if(requestDto.getLastName()==null || requestDto.getLastName().trim().isEmpty()) {
				throw new RuntimeException("First must not be blank");
			}
			if(requestDto.getEmail()==null || requestDto.getEmail().trim().isEmpty()) {
				throw new RuntimeException("First must not be blank");
			}
			if(requestDto.getSalary()<0) {
				throw new RuntimeException("Salary must be positive value");
			}
			Employee employee=new Employee();
			employee.setFirstName(requestDto.getFirstName());
			employee.setLastName(requestDto.getLastName());
			employee.setEmail(requestDto.getEmail());
			employee.setSalary(requestDto.getSalary());
			
			Employee savedEmployee= employeeRepository.save(employee);
			return savedEmployee;

		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Unable to add Employee"+e.getMessage());
		}
		

	}

	@Override
	public Employee updateEmployee(Long id, EmployeeRequestDto requestDto) {
		// TODO Auto-generated method stub
		try {
			Employee existingEmployee = employeeRepository.findById(id)
										.orElseThrow(()-> new RuntimeException("Employee not found with id "+id));
			if(requestDto.getFirstName()==null || requestDto.getFirstName().trim().isEmpty()) {
				throw new RuntimeException("First name not be blank");
			}
			if(requestDto.getLastName()==null || requestDto.getLastName().trim().isEmpty()) {
				throw new RuntimeException("Last name not be blank");
			}
			if(requestDto.getEmail()==null || requestDto.getEmail().trim().isEmpty()) {
				throw new RuntimeException("Email not be blank");
			}
			if(requestDto.getSalary()<0) {
				throw new RuntimeException("Salary must be positive value");
			}
			existingEmployee.setFirstName(requestDto.getFirstName());
			existingEmployee.setLastName(requestDto.getLastName());
			existingEmployee.setEmail(requestDto.getEmail());
			existingEmployee.setSalary(requestDto.getSalary());
			Employee updateEmployee=employeeRepository.save(existingEmployee);
			return updateEmployee;
		} catch (Exception e) {
			// TODO: handle exception
			
			throw new RuntimeException("Unable to update employee"+e.getMessage());
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> response=employeeRepository.findAll();
		return response;
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		Employee employee=employeeRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Employee not found "));
		employeeRepository.delete(employee);
		
	}
	
	

}
