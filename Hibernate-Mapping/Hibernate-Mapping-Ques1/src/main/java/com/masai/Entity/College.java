package com.masai.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "college")
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cllg_Id")
	private int collegeId;
	
	@Column(name = "cllg_name")
	private String collegeName;
	
	@Column(name = "cllg_addr")
	private String collegeAddress;
	
	@OneToMany(mappedBy = "c", cascade = CascadeType.ALL)
	private Set<Student> s = new HashSet<>();

	public College() {
		super();
		// TODO Auto-generated constructor stub
	}

	public College(int collegeId, String collegeName, String collegeAddress, Set<Student> s) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.collegeAddress = collegeAddress;
		this.s = s;
	}

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getCollegeAddress() {
		return collegeAddress;
	}

	public void setCollegeAddress(String collegeAddress) {
		this.collegeAddress = collegeAddress;
	}

	public Set<Student> getS() {
		return s;
	}

	public void setS(Set<Student> s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return "College [collegeId=" + collegeId + ", collegeName=" + collegeName + ", collegeAddress=" + collegeAddress
				+ ", s=" + s + "]";
	}
	
	
	
}
