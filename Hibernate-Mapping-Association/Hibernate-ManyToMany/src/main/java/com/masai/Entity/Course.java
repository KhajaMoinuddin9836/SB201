package com.masai.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int couseId;
	private String courseName;
	private int duration;
	private int fee;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "courses")
	List<Student> students = new ArrayList<>();

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(int couseId, String courseName, int duration, int fee, List<Student> students) {
		super();
		this.couseId = couseId;
		this.courseName = courseName;
		this.duration = duration;
		this.fee = fee;
		this.students = students;
	}

	public int getCouseId() {
		return couseId;
	}

	public void setCouseId(int couseId) {
		this.couseId = couseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [couseId=" + couseId + ", courseName=" + courseName + ", duration=" + duration + ", fee=" + fee
				+ ", students=" + students + "]";
	}
	
	
	
}
