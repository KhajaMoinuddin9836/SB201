package com.masai.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Stud_Id")
	private int studentRoll;
	
	@Column(name = "Stud_name")
	private String studentName;
	
	@Column(name = "Stud_Mob")
	private int mobileNumber;
	
	@Column(name = "Stud_Email")
	private String email;
	
	@ManyToOne
	private College c;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int studentRoll, String studentName, int mobileNumber, String email, College c) {
		super();
		this.studentRoll = studentRoll;
		this.studentName = studentName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.c = c;
	}

	public int getStudentRoll() {
		return studentRoll;
	}

	public void setStudentRoll(int studentRoll) {
		this.studentRoll = studentRoll;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public College getC() {
		return c;
	}

	public void setC(College c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "Student [studentRoll=" + studentRoll + ", studentName=" + studentName + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + ", c=" + c + "]";
	}
	
	
	
}
