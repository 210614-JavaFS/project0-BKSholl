package com.revature.model;

public class User {
	
	private String firstName;
	private String lastName;
	private int last4SSN;
	private String username;
	
	public User() {
		super();
	}

	public User(String username, String firstName, String lastName, int last4ssn) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.last4SSN = last4ssn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getLast4SSN() {
		return last4SSN;
	}

	public void setLast4SSN(int last4ssn) {
		last4SSN = last4ssn;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", last4SSN=" + last4SSN + ", username="
				+ username + "]";
	}

}