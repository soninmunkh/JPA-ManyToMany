package com.example.ManyToMany.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employees")
public class Employee {
	private EmployeeIdentity employeeidentity;
	@NotNull
	private String email;
	@Email
	private String name;
	@NotNull
	private long phoneNumber;
	public EmployeeIdentity getEmployeeidentity() {
		return employeeidentity;
	}
	public void setEmployeeidentity(EmployeeIdentity employeeidentity) {
		this.employeeidentity = employeeidentity;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Employee(EmployeeIdentity employeeidentity, @NotNull String email, @Email String name,
			@NotNull long phoneNumber) {
		super();
		this.employeeidentity = employeeidentity;
		this.email = email;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [employeeidentity=" + employeeidentity + ", email=" + email + ", name=" + name
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
	
}
