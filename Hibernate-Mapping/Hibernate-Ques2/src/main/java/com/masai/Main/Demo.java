package com.masai.Main;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.masai.Entity.Address;
import com.masai.Entity.Customer;
import com.masai.utility.EMUtil;

public class Demo {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Customer name");
		String name = sc.next();
		
		System.out.println("Enter Customer mobileNumber");
		int mobile = sc.nextInt();
		
		System.out.println("Enter Customer Email");
		String email = sc.next();
		
		System.out.println("Enter home address");
		
		System.out.println("Enter home state");
		String Hstate = sc.next();
		
		System.out.println("Enter home city");
		String Hcity = sc.next();
		
		System.out.println("Enter home pincode");
		String Hpincode = sc.next();
		
		
		System.out.println("Enter type");
		String Htype = sc.next();
		
		EntityManager em = EMUtil.provideEntitymanager();
		
		Customer c = new Customer();
		
		c.setName(name);
		c.setMobileNumber(mobile);
		c.setEmail(email);
		
		System.out.println("Enter office address");
		
		System.out.println("Enter office state");
		String office_state = sc.next();
		
		System.out.println("Enter office city");
		String office_city = sc.next();
		
		System.out.println("Enter office pincode");
		String office_pincode = sc.next();
		
		System.out.println("Enter type");
		String office_type = sc.next();
		
		Address home_address = new Address(Hstate, Hcity, Hpincode, Htype);
		
		Address office_address = new Address(office_state, office_city, office_pincode, office_type);
		
		em.getTransaction().begin();
		
		em.persist(c);
		
		em.getTransaction().commit();
		
		em.close();
		
		System.out.println("done......");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
