package com.revature.services;

import java.util.List;

import com.revature.daos.UserDAO;
import com.revature.model.User;

public class UserServiceImpl implements UserService {
	
	public UserDAO ud;
	
	public UserServiceImpl(UserDAO ud) {
		this.ud = ud;
	}

	@Override
	public User getUser(String username) {
		return ud.getUser(username);
	}

	@Override
	public List<User> getAllUsers() {
		return ud.getAllUsers();
	}

	@Override
	public boolean addUser(User u) {
		return ud.addUser(u);
	}

	@Override
	public boolean updateUser(User u) {
		return ud.updateUser(u);
	}

	@Override
	public boolean deleteUser(String username) {
		return ud.deleteUser(username);
	}

}
