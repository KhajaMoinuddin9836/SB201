package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DTO.EmployeeDTO;
import com.masai.Exceptions.EmployeeException;
import com.masai.model.Employee;
import com.masai.repository.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao empDao;
	
	
	@Override
	public Employee registerEmployee(Employee emp) throws EmployeeException {
		// TODO Auto-generated method stub
		
		return empDao.save(emp);
	}

	@Override
	public Employee getEmployeeById(Integer empId) throws EmployeeException {
		// TODO Auto-generated method stub
		
		
		Optional<Employee> emp = empDao.findById(empId);
		
		if(emp.isPresent()) {
			
			Employee ee = emp.get();
			
			return ee;
		}
		else {
			
			throw new EmployeeException("Employee no found");
		}
			
		
		
	}

	@Override
	public List<Employee> getAllEmployeeDetails() throws EmployeeException {
		// TODO Auto-generated method stub
		
		List<Employee> emp = empDao.findAll();
		
		if(emp==null) throw new EmployeeException("Employees are not found");
		
		return emp;
	}

	@Override
	public Employee deleteEmployeeById(Integer empId) throws EmployeeException {
		// TODO Auto-generated method stub
		
		Optional<Employee> emp = empDao.findById(empId);
		
		if(emp.isPresent()) {
			
			Employee ee = emp.get();
			
			return ee;
		}
		else {
			
			throw new EmployeeException("Employee not found with id: "+empId);
		}
		
		
	}

	@Override
	public Employee updateEmployee(Employee emp) throws EmployeeException {
		// TODO Auto-generated method stub
		
		Optional<Employee> ee = empDao.findById(emp);
		
		if(!ee.isPresent()) throw new EmployeeException("No Employee are fonud");
		
		Employee e = ee.get();
		
		return e;
		
	}

	@Override
	public List<Employee> getAllDetailsByAddress(String address) throws EmployeeException {
		// TODO Auto-generated method stub
		
		List<Employee> e = empDao.findByAddress(address);
		
		if(e != null) {
			
			return e;
		}
		else {
			
			throw new EmployeeException("Employee not found with Address");
		}
	}

	@Override
	public List<EmployeeDTO> getNameAddressSalaryofAllEmployee() throws EmployeeException {
		// TODO Auto-generated method stub
		List<EmployeeDTO> emp = empDao.findAllEmployee();
		
		if(emp==null) {
			throw new EmployeeException("Employee not found");
		}
		else {
			
			return emp;
		}
	}

	
}
