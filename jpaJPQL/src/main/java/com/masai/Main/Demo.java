package com.masai.Main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.Entity.Address;
import com.masai.Entity.Customer;
import com.masai.utility.UMutil;

public class Demo {

	public static void main(String[] args) {
		
		EntityManager em = UMutil.provideConnection();
		
		em.getTransaction().begin();
		
		Address addr = new Address();
		
		addr.setCity("Mumbai");
		addr.setPincode("10010");
		addr.setState("Maharashtra");
		
		Address addr2 = new Address();
		
		addr2.setCity("Gulbarga");
		addr2.setState("Karnataka");
		addr2.setPincode("585103");
		
		List<Address> list = new ArrayList<>();
		
		list.add(addr);
		
		List<Address> list2 = new ArrayList<>();
		
		list2.add(addr2);
		
		Customer c = new Customer();
		
		c.setEmail("moin@gmail.com");
		c.setMobileNumber(961131);
		c.setName("Moin");
		
		Customer cc = new Customer();
		
		cc.setEmail("khaja@gmail.com");
		cc.setMobileNumber(720481);
		cc.setName("Khaja");
		
		c.getAddress().add(addr);
		cc.getAddress().add(addr2);
		
		em.persist(c);
		em.persist(cc);
		
		em.getTransaction().commit();
		
		
		String Jpql = "select name.address,email,mobilenumber from Customer";
		
		Query sql = em.createQuery(Jpql);
		
		List<Object[]> result = sql.getResultList();
		
		for(Object[] or:result) {
			
			String name = (String) or[0];
			String add = (String) or[1];
			String email = (String) or[2];
			int mob = (Integer) or[3];
			
			System.out.println(name);
			System.out.println(add);
			System.out.println(email);
			System.out.println(mob);
		}
    }
}
