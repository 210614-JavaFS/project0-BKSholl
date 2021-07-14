package com.revature.controllers;

import java.util.List;

import com.revature.model.User;
import com.revature.services.UserService;

public class UserController {
	
	public UserService us;
	
	public UserController(UserService us) {
		this.us = us;
	}
	
	public User getUser(String username) {
		return us.getUser(username);
	}

	public List<User> getAllUsers() {
		return us.getAllUsers();
	}

	public boolean addUser(User u) {
		return us.addUser(u);
	}

	public boolean updateUser(User u) {
		return us.updateUser(u);
	}

	public boolean deleteUser(String username) {
		return us.deleteUser(username);
	}

}
