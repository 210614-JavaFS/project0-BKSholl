package com.revature;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controllers.AccountController;
import com.revature.controllers.UserController;
import com.revature.daos.AccountDAO;
import com.revature.daos.AccountDAOImpl;
import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.model.Account;
import com.revature.model.User;
import com.revature.services.AccountService;
import com.revature.services.AccountServiceImpl;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

public class Main {
	
	
	public static Logger log = LoggerFactory.getLogger(Main.class);
//	private static MenuController menuController = new MenuController();
//	private static LogInController logInController = new LogInController();
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Hello, welcome to Revature Banking!");
		UserDAO ud = new UserDAOImpl();
		UserService us = new UserServiceImpl(ud);
		UserController uc = new UserController(us);
		AccountDAO ad = new AccountDAOImpl();
		AccountService as = new AccountServiceImpl(ad);
		AccountController ac = new AccountController(as);
		
		boolean running = true;
		
		Scanner scan = new Scanner(System.in);
		
		while(running) {
			System.out.println("Please Enter your User Name: ");
			String input = scan.nextLine();
			User user = uc.getUser(input);
			if(user != null) {
				System.out.println("Please enter your password");
				input = scan.nextLine();
				Account account = ac.getAccount(user.getUsername());
				if(account != null && account.getPassword().equals(input)) {
					System.out.println("Password Mathes");
					running = false;
					if(account.isApproved()) {
						
					}
				}else {
					System.out.println("Incorrect Password");
				}
				
			} else {
				System.out.println("User not found, try again");
			}
			
			
			if(input.equals("Exit")) {
				running = false;
			}
			
		}
		
//		System.out.println(ud.getAllUsers());
//		User test = new User("bsholl", "kevin", "loser", 3333);
//		ud.addUser(test);
//		ud.updateUser(test);
//		System.out.println(ud.getUser("bsholl"));
//		
//		
//		System.out.println(ud.deleteUser("knguyen"));
		
//		System.out.println(ad.getAccount("bsholl"));

//		System.out.println(ad.getAllAccounts());
//		Account test = new Account(1, "user", "pass", 100, 2, false);
//		System.out.println(ad.addAccount(test));
		
//		System.out.println(ad.deleteAccount("knguyen"));
		
		
		
	
	}
}
