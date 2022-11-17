package com.masai.EmployeeDao;

import com.masai.EmployeeBean.Employee;

public interface EmployeeDao {

	public String insertEmployee(Employee e);
	
	public String getAddressOfEmployee(int empId);
	
	public String giveBonusToEmployee(int empId, int bonus);
	
	public boolean deleteEmployee(int empId);
}
