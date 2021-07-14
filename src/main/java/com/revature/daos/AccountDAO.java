package com.revature.daos;

import java.util.List;

import com.revature.model.Account;

public interface AccountDAO {
	//gets account through ID
	public Account getAccount(String username);
	//gets all accounts
	public List<Account> getAllAccounts();
	//adds a new account
	public boolean addAccount(Account a);
	//updates an existing account
	public boolean updateAccount(Account a);
	
	public boolean updateAccountBalance(Account a);
	//deletes account
	public boolean deleteAccount(String username);
}
