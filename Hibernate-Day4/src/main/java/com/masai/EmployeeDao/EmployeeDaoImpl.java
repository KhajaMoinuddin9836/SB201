package com.masai.EmployeeDao;

import javax.persistence.EntityManager;

import com.masai.EmployeeBean.Employee;
import com.masai.EmployeeException.EmployeeException;
import com.masai.EntityUtil.EntityUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public Employee registerEmployee(Employee emp) throws EmployeeException {
		
		boolean flag = false;
		
		EntityManager em = EntityUtil.provideEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(emp);
		
		flag = true;
		
		em.getTransaction().commit();
		
		em.close();
		
		if(flag) {
			
			return emp;
		}
		else {
		
		throw new EmployeeException("Employee doesnt exist");
	}
	}

	@Override
	public Employee getEmployeeById(int empId) throws EmployeeException{
		
		return EntityUtil.provideEntityManager().find(Employee.class, empId);
		
	}

	@Override
	public Employee deleteEmployee(int empId) throws EmployeeException {
		
		boolean flag = false;
		
		Employee emp = new Employee();
		
		EntityManager em = EntityUtil.provideEntityManager();
		
		emp = em.find(Employee.class, empId);
		
		if(emp != null) {
			
			em.getTransaction().begin();
			
			em.remove(emp);
			
			flag = true;
			
			em.getTransaction().commit();
		}
		em.close();
		
		if(flag) {
			
			return emp;
		}
		
		else {
			
			throw new EmployeeException("Employee dosnt exist");
		}
		
		
	}

	@Override
	public Employee updateEmployee(Employee emp) throws EmployeeException {
		
		boolean flag = false;
		
		EntityManager em = EntityUtil.provideEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(emp);
		
		flag = true;
		
		em.getTransaction().commit();
		
		em.close();
		
		if(flag) {
			
			return emp;
		}
		else {
			
			throw new EmployeeException("Employee is not updated");
		}
	}
	
	

}
