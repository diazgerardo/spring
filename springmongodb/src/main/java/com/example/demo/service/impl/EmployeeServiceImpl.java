package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.dto.EmployeeResponseDto;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public List<Employee> getEmployeeFilterBySalary(Double from, Double to) {
		
		return employeeRepository.getEmployeesFilterBySalary(from, to);
	}


	@Override
	public List<Employee> getAllEmployees() {
		Pageable firstPageWithTwoElements = PageRequest.of(2, 2);
		return employeeRepository.findAll(firstPageWithTwoElements).toList();
	}


	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getEmployeeFilterBySalaryAndPosition(Double from, Double to, String position) {
		return employeeRepository.getEmployeesFilterBySalaryAndPosition(from, to, position);
	}
	
	
	

	@Override
	public List<EmployeeResponseDto> getEmployeesDto() {
		List<EmployeeResponseDto>employees = new ArrayList<>();
		employeeRepository.findAll().forEach(employee ->{
			employees.add(this.mapper.map(employee, EmployeeResponseDto.class));
		});
		return employees;
	}

}
