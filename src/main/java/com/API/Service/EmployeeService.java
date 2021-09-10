package com.API.Service;

import java.util.stream.Collectors;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.API.dto.EmployeeDTO;
import com.API.errors.ResourceNotFoundException;
import com.API.integrations.EmployeeRepository;
import com.API.model.Employee;

@Service
public class EmployeeService {
	@Autowired
    private EmployeeRepository employeeRepository;
	
	
	public EmployeeDTO convertToDto(Employee employee) {
		ModelMapper modelMapper = new ModelMapper();

		EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
	    return employeeDTO;
	}
	
	public Employee convertToDao(EmployeeDTO employee) {
		ModelMapper modelMapper = new ModelMapper();

		Employee dao = modelMapper.map(employee, Employee.class);
	    return dao;
	}
	
	public List<EmployeeDTO> getAllEmployees() {
		Iterable<Employee> all = employeeRepository.findAll();
		return convertAllDTO((List<Employee>) all);
	}
	
	public EmployeeDTO getEmployeeByID(Long Id) {
		Optional<Employee> emp = employeeRepository.findById(Id);
		Employee em = emp.orElse(null);
		System.out.println("emp : " + emp);
		return convertToDto(em);
	}
	
	public List<EmployeeDTO> convertAllDTO(List<Employee> dao) {
		 return dao.stream()
		          .map(this::convertToDto)
		          .collect(Collectors.toList());
	}
	
	public EmployeeDTO createEmployee(EmployeeDTO dto) {
		Employee dao = convertToDao(dto);
		dao = employeeRepository.save(dao);
		EmployeeDTO empdto = convertToDto(dao);
		return empdto;
	}
	
	public void deleteEmployee(Long Id) {
		employeeRepository.deleteById(Id);
	}
	
	
	
	
}
