package com.masai.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UMutil {

	private static EntityManagerFactory emf;
	
	static {
		
		emf = Persistence.createEntityManagerFactory("employee");
	}
	
	public static EntityManager provideConnection() {
		
		return emf.createEntityManager();
	}
}
