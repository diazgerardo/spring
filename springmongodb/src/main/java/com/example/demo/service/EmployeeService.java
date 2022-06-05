package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Employee;
import com.example.demo.service.dto.EmployeeResponseDto;

@Service
public interface EmployeeService {
	
	public List<Employee>getEmployeeFilterBySalary(Double from, Double to);
	
	public List<Employee>getEmployeeFilterBySalaryAndPosition(Double from, Double to,String position);
	
	public List<Employee>getAllEmployees();
	
	public List<EmployeeResponseDto> getEmployeesDto();
	
	void saveEmployee(Employee employee);
}
