package com.revature.controllers;

import java.util.List;

import com.revature.model.Account;
import com.revature.services.AccountService;

public class AccountController {
	
	public AccountService as;
	
	public AccountController(AccountService as) {
		this.as = as;
	}
	
	public Account getAccount(String username) {
		return as.getAccount(username);
	}
	
	public List<Account> getAllAccounts(){
		return as.getAllAccounts();
	}
	
	public boolean addAccount(Account a) {
		return as.addAccount(a);
	}
	
	public boolean updateAccount(Account a) {
		return as.updateAccount(a);
	}
	
	public boolean updateAccountBalance(Account a) {
		return as.updateAccountBalance(a);
	}
	
	public boolean deleteAccount(String username) {
		return as.deleteAccount(username);
	}
	
	public double withdrawFromAccount(String username, double amount) {
		return as.withdrawFromAccount(username, amount);
	}
	
	public double depositToAccount(String username, double amount) {
		return as.depositToAccount(username, amount);
	}
	
	public double transferFromAccount(String username1, String username2, double amount) {
		return as.transferFromAccount(username1, username2, amount);
	}

}
