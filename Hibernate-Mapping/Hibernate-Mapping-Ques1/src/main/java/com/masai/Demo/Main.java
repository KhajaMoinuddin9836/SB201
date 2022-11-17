package com.masai.Demo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import com.masai.Entity.College;
import com.masai.Entity.Student;
import com.masai.utility.EMUtil;

public class Main {

	public static void main(String[] args) {
		
		EntityManager em = EMUtil.getEntityManager();
		
		em.getTransaction().begin();
		
		College c1 = new College();
		
		c1.setCollegeAddress("Bangalore");
		c1.setCollegeName("Masai");
		
		Student s1 = new Student();
		
		s1.setStudentName("Khaja");
		s1.setMobileNumber(961131);
		s1.setEmail("khaja@gmail.com");
		s1.setC(c1);
		
		Student s2 = new Student();
		
		s2.setC(c1);
		s2.setMobileNumber(724061);
		s2.setEmail("moin@gmail.com");
		s2.setStudentName("Moin");
		
		Set<Student> ss = new HashSet<>();
		
		ss.add(s1);
		ss.add(s2);
		
		c1.setS(ss);
		em.persist(c1);
		
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		
		College c2 = em.find(College.class, 1);
		
		System.out.println(c2.getCollegeName());
		
		Set<Student> student = c2.getS();
		
		for(Student st:student) {
			
			System.out.println(st.getStudentName());
			System.out.println(st.getStudentRoll());
			System.out.println(st.getMobileNumber());
			System.out.println(st.getEmail());
		}
		
		em.getTransaction().commit();
		
		em.close();
		em.close();
	}
}
