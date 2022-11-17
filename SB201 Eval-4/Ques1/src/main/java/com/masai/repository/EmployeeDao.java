package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.masai.DTO.EmployeeDTO;
import com.masai.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

	
	public List<Employee> findByAddress(String address);

	public List<EmployeeDTO> findAllEmployee();
}
