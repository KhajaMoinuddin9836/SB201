package com.masai.EmployeeDao;

import com.masai.EmployeeBean.Employee;
import com.masai.EmployeeException.EmployeeException;

public interface EmployeeDao {
	
	public Employee registerEmployee(Employee emp) throws EmployeeException;
	
	public Employee getEmployeeById(int empId) throws EmployeeException;
	
	public Employee deleteEmployee(int empId) throws EmployeeException;
	
	public Employee updateEmployee(Employee emp) throws EmployeeException;

}
