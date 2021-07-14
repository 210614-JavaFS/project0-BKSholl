package com.revature.model;

public class Account {
	
	private String username;
	private String pass;
	private int id;
	private double balance;
	private int accountLevel;
	private boolean approved;
	
	public Account() {
		super();
	}
	
	public Account(int id, String username, String password, double balance, int accountLevel, boolean approved) {
		super();
		this.username = username;
		this.pass = password;
		this.id = id;
		this.balance = balance;
		this.accountLevel = accountLevel;
		this.approved = approved;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return pass;
	}
	
	public void setPassword(String password) {
		this.pass = password;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public int getAccountLevel() {
		return accountLevel;
	}
	
	public void setAccountLevel(int accountLevel) {
		this.accountLevel = accountLevel;
	}
	
	public boolean isApproved() {
		return approved;
	}
	
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
	@Override
	public String toString() {
		return "Account [username=" + username + ", password=" + pass + ", id=" + id + ", balance=" + balance
				+ ", accountLevel=" + accountLevel + ", approved=" + approved + "]";
	}
	
	
}
