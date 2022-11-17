package com.masai.EmployeeDao;

import javax.persistence.EntityManager;

import com.masai.EmployeeBean.Employee;
import com.masai.EntityUtil.EntityUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public String insertEmployee(Employee e) {
		
		
		String str = "Not inserted";
		
		
		EntityManager em = EntityUtil.getEntityManager();
		
		if(e !=null) {
			
			em.getTransaction().begin();
			
			em.persist(e);
			
			em.getTransaction().commit();
			
			str = "Employee data inserted succesfully....";
			
			em.close();
		}
		else {
			str = "do not pass null value";
		}
		
		return str;
	}
	

	@Override
	public String getAddressOfEmployee(int empId) {
		
		
		EntityManager em = EntityUtil.getEntityManager();
		
		Employee e = em.find(Employee.class, empId);
		
		return e.getAddress();
	}

	@Override
	public String giveBonusToEmployee(int empId, int bonus) {
		
		String str = "Employee not found....";
		
		EntityManager em = EntityUtil.getEntityManager();
		
		Employee e = em.find(Employee.class, empId);
		
		if(e !=null) {
			
			em.getTransaction().begin();
			
			e.setSalary(e.getSalary()+bonus);
			
			em.persist(e);
			
			str = "Bonus added Succesfully";
			
			em.getTransaction().commit();
		}
		em.close();
		
		return str;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		
		boolean flag = false;
		
		EntityManager em = EntityUtil.getEntityManager();
		
		Employee e = em.find(Employee.class, empId);
		
		if(e !=null) {
			
			em.getTransaction().begin();
			
			em.remove(e);
			
			em.getTransaction().commit();
			
			flag = true;
		}
		
		em.close();
		
		return flag;
	}
	
	

}