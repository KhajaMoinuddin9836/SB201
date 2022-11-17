package com.masai;

public class Collage {

	
private String collage_name;
	
	private Student student;
	
	private String collage_address;

	public String getCollage_name() {
		return collage_name;
	}

	public void setCollage_name(String collage_name) {
		this.collage_name = collage_name;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getCollage_address() {
		return collage_address;
	}

	public void setCollage_address(String collage_address) {
		this.collage_address = collage_address;
	}
	
	

	
	public Collage(String collage_name, Student student, String collage_address) {
		super();
		this.collage_name = collage_name;
		this.student = student;
		this.collage_address = collage_address;
	}

	public void showDetails() {
		
		System.out.println("Collage Name is :"+" "+collage_name);
		System.out.println("Collage Address is :"+" "+collage_address);
		System.out.println("Collage Student is :"+" "+student);
	}
}
