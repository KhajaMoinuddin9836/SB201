package com.masai.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pId;
	
	private String name;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int pId, String name) {
		super();
		this.pId = pId;
		this.name = name;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [pId=" + pId + ", name=" + name + "]";
	}
	
	
	
}
