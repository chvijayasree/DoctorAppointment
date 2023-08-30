package com.amdocs.model;
//import java.util.*;

public class Customer {
	
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private int age;
	public Customer(String firstname, String lastname, String email, String password, int age) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.age = age;
	}
	public Customer() {
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User_Registration [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", age=" + age + "]";
	}
	
	

			 
		
}
	
	
	

