package com.masai.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roll;
	private String name;
	private String email;
	private int mobile;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Student_Course", joinColumns = @JoinColumn(name = "Student_Id"),
	inverseJoinColumns = @JoinColumn(name = "CourseId"))
	List<Course> courses = new ArrayList<>();

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int roll, String name, String email, int mobile, List<Course> courses) {
		super();
		this.roll = roll;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.courses = courses;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", courses="
				+ courses + "]";
	}
	
	
}
