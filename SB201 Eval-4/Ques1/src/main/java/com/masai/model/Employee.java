package com.masai.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;
	
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Invalid name")
	@Size(min = 3, max = 20, message = "Invalid name min 3 letters and max 20 required")
	private String empName;

	private Integer salary;
	
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Invalid Address")
	@Size(min = 3, max = 10, message = "Address must be min 3 and max 10 letters required")
	private String address;
	
	@Pattern(regexp =  "^[a-zA-Z0-9+_.-]+@[a-xA-Z0-9.-]+$", message = "Invalid email")
	private String email;
	
	@Pattern(regexp = "^\\d{10}$")
	@Size(max = 10, message = "Mobile must be 10 numbers")
	private String mobile;
	
	@Size(min = 6, max = 12, message = "Password must contain at least 8 characters")
	private String password;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer empId, String empName, Integer salary, String address, String email, String mobile,
			String password) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, email, empId, empName, mobile, password, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(address, other.address) && Objects.equals(email, other.email)
				&& Objects.equals(empId, other.empId) && Objects.equals(empName, other.empName)
				&& Objects.equals(mobile, other.mobile) && Objects.equals(password, other.password)
				&& Objects.equals(salary, other.salary);
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", address=" + address
				+ ", email=" + email + ", mobile=" + mobile + ", password=" + password + "]";
	}
	
	
}
