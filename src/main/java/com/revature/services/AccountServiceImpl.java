package com.revature.services;

import java.util.List;

import com.revature.daos.AccountDAO;
import com.revature.model.Account;

public class AccountServiceImpl implements AccountService {
	
	public AccountDAO ad;
	
	public AccountServiceImpl(AccountDAO ad) {
		this.ad = ad;
	}

	@Override
	public Account getAccount(String username) {
		return ad.getAccount(username);
	}

	@Override
	public List<Account> getAllAccounts() {
		return ad.getAllAccounts();
	}

	@Override
	public boolean addAccount(Account a) {
		return ad.addAccount(a);
	}

	@Override
	public boolean updateAccount(Account a) {
		return ad.updateAccount(a);
	}

	@Override
	public boolean updateAccountBalance(Account a) {
		return ad.updateAccountBalance(a);
	}

	@Override
	public boolean deleteAccount(String username) {
		return ad.deleteAccount(username);
	}

	@Override
	public double withdrawFromAccount(String username, double amount) {
		Account account = ad.getAccount(username);
		if(account != null) {
			if(amount >= 0) {
				double currentBalance = account.getBalance();
				if(currentBalance >= amount) {
					double newBalance = currentBalance - amount;
					account.setBalance(newBalance);
					ad.updateAccountBalance(account);
					return newBalance;
				}
			}
		}
		return 0;
	}

	@Override
	public double depositToAccount(String username, double amount) {
		Account account = ad.getAccount(username);
		if(account != null) {
			if(amount >= 0) {
				double currentBalance = account.getBalance();
				double newBalance = currentBalance + amount;
				account.setBalance(newBalance);
				ad.updateAccountBalance(account);
				return newBalance;
			}
		}
		return 0;
	}

	@Override
	public double transferFromAccount(String username1, String username2, double amount) {
		Account account1 = ad.getAccount(username1);
		Account account2 = ad.getAccount(username2);
		if(account1 != null && account2 != null) {
			if(amount >= 0) {
				double currentBalance1 = account1.getBalance();
				double currentBalance2 = account2.getBalance();
				if(currentBalance1 >= amount) {
					double newBalance1 = currentBalance1 - amount;
					double newBalance2 = currentBalance2 + amount;
					account1.setBalance(newBalance1);
					account2.setBalance(newBalance2);
					ad.updateAccountBalance(account1);
					ad.updateAccountBalance(account2);
					return newBalance2;
				}
				
				
			}
		}
		return 0;
	}

}
