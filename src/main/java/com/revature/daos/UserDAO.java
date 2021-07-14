package com.revature.daos;

import java.util.List;

import com.revature.model.User;

public interface UserDAO {
	
	public User getUser(String username);
	
	public List<User> getAllUsers();
	
	public boolean addUser(User u);
	
	public boolean updateUser(User u);
	
	public boolean deleteUser(String username);

}
