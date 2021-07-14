package com.revature.services;

import java.util.List;

import com.revature.model.Account;

public interface AccountService {
	
	public Account getAccount(String username);
	
	public List<Account> getAllAccounts();
	
	public boolean addAccount(Account a);
	
	public boolean updateAccount(Account a);
	
	public boolean updateAccountBalance(Account a);
	
	public boolean deleteAccount(String username);
	
	public double withdrawFromAccount(String username, double amount);
	public double depositToAccount(String username, double amount);
	public double transferFromAccount(String username1, String username2, double amount);

}
