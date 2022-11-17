package com.masai.Main;

import javax.persistence.EntityManager;

import com.masai.Entity.Address;
import com.masai.Entity.Employee;
import com.masai.utility.EMutil;

public class Main {

	public static void main(String[] args) {
		
		EntityManager em = EMutil.provideEntityManager();
		
		Address A1 = new Address("s1","c1","585103");
		Address A2 = new Address("s2", "c2", "5851001");
		Address A3 = new Address("s3", "c3", "57451");
		Address A4 = new Address("s4","c4","600081");
		
		Employee emp = new Employee();
		
		emp.setHomeAddress(A2);
		emp.setName("Monu");
		emp.setSalary(50000);
		emp.setOfficeAddress(A2);
		
		Employee emp1 = new Employee();
		
		emp1.setHomeAddress(A3);
		emp1.setOfficeAddress(A3);
		emp1.setName("Sonu");
		emp1.setSalary(70000);
		
		Employee emp2 = new Employee();
		
		emp2.setHomeAddress(A1);
		emp2.setOfficeAddress(A1);
		emp2.setName("Gonu");
		emp2.setSalary(40000);
		
		Employee emp3 = new Employee();
		
		emp3.setHomeAddress(A4);
		emp3.setOfficeAddress(A4);
		emp3.setName("Golu");
		emp3.setSalary(80000);
		
		em.getTransaction().begin();
		
		em.persist(emp);
		em.persist(emp1);
		em.persist(emp2);
		em.persist(emp3);
		
		em.getTransaction().commit();
		
		System.out.println("done....");
		em.close();
		
	}
}

