package com.masai.usecases;

import javax.persistence.EntityManager;

import com.masai.Entity.Course;
import com.masai.Entity.Student;
import com.masai.utility.EMutil;

public class Main {

	public static void main(String[] args) {
		
		EntityManager em = EMutil.provideEntityManager();
		
		Course c1 = new Course();
		
		c1.setCourseName("JavaScript");
		c1.setDuration(3);
		c1.setFee(70000);
		
		Course c2 = new Course();
		
		c2.setCourseName("JAVA");
		c2.setDuration(4);
		c2.setFee(80000);
		
		Course c3 = new Course();
		
		c3.setCourseName("React");
		c3.setDuration(5);
		c3.setFee(60000);
		
		Student s1 = new Student();
		
		s1.setName("Monu");
		s1.setEmail("monu@gmail.com");
		s1.setMobile(12345);
		
		
		Student s2 = new Student();
		
		s2.setName("sonu");
		s2.setEmail("sonu@gmail.com");
		s2.setMobile(76543);
		
		Student s3 = new Student();
		
		s3.setName("Golu");
		s3.setEmail("golu@gmail.com");
		s3.setMobile(987654);
		
		s1.getCourses().add(c1);
		s2.getCourses().add(c1);
		
		c1.getStudents().add(s1);
		c1.getStudents().add(s2);
		
		s2.getCourses().add(c2);
		c2.getStudents().add(s2);
		
		s1.getCourses().add(c3);
		c3.getStudents().add(s2);
		
		s3.getCourses().add(c2);
		c2.getStudents().add(s2);
		
		em.getTransaction().begin();
		
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		
		em.getTransaction().commit();
		
		System.out.println("done...");
		
		em.close();
		
		
		
		

	}

}
