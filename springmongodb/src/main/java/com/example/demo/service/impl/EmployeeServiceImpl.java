package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	private TypeMap<Employee, EmployeeResponseDto> propertyMapper = null;
	
	public TypeMap<Employee, EmployeeResponseDto>createPropertyMapper(){
		if(this.propertyMapper == null) {
			return this.mapper.createTypeMap(Employee.class, EmployeeResponseDto.class);
		}else {
			return this.propertyMapper;
		}
		
	}
	
	
	@Override
	public List<Employee> getEmployeeFilterBySalary(Double from, Double to) {
		
		return employeeRepository.getEmployeesFilterBySalary(from, to);
	}


	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
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
		List<EmployeeResponseDto>resp = new ArrayList<>();
		propertyMapper = this.createPropertyMapper();
		try {
			propertyMapper.addMappings(
				//mapper -> mapper.map(employee -> employee.getName()+ "--", EmployeeResponseDto::setDatosPersonales)
				mapper -> {
					mapper.map(employee -> employee.personalData(),EmployeeResponseDto::setDatosPersonales);
					mapper.map(employee -> employee.getAdress().getCity() ,EmployeeResponseDto::setCity);
				}
			);
		}catch (Exception e) {
			System.out.println("exception".concat(e.getMessage()));
		}
		
		employeeRepository.findAll().forEach(employee ->{
			resp.add(this.mapper.map(employee, EmployeeResponseDto.class));
		});
		return resp;
	}

}
