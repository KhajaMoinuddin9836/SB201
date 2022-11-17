package com.masai.Service;

import java.util.List;


import com.masai.DTO.EmployeeDTO;
import com.masai.Exceptions.EmployeeException;
import com.masai.model.Employee;

public interface EmployeeService {
	
	public Employee registerEmployee(Employee emp)throws EmployeeException;
	
	public Employee getEmployeeById(Integer empId)throws EmployeeException;
	
	public List<Employee> getAllEmployeeDetails()throws EmployeeException;
	
	public Employee deleteEmployeeById(Integer empId)throws EmployeeException;
	
	public Employee updateEmployee( Employee emp)throws EmployeeException;
	
	public List<Employee> getAllDetailsByAddress(String address)throws EmployeeException;
	
	public List<EmployeeDTO> getNameAddressSalaryofAllEmployee()throws EmployeeException;
	

}
