package com.masai.EntityUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityUtil {
	
	private static EntityManagerFactory emf;
	
	static {
		
		emf = Persistence.createEntityManagerFactory("employee");
		
	}
	
	public static EntityManager provideEntityManager() {
		
		EntityManager em = emf.createEntityManager();
		
		return em;
	}

}
