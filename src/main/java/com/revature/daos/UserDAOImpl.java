package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.User;
import com.revature.utils.ConnectionUtil;

public class UserDAOImpl implements UserDAO {
	
	private Connection conn = null;
	
	@Override
	public User getUser(String username) {
		try {
			conn = setUpConnection();
			String sql = "SELECT * FROM users WHERE username = ?";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					return setUpUser(rs);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			conn = setUpConnection();
			String sql = "SELECT * FROM users";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					users.add(setUpUser(rs));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public boolean addUser(User u) {
		try {
			conn = setUpConnection();
			String sql = "INSERT INTO users VALUES (?, ?, ?, ?) RETURNING *";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, u.getUsername());
				ps.setString(2, u.getFirstName());
				ps.setString(3, u.getLastName());
				ps.setInt(4, u.getLast4SSN());
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateUser(User u) {
		try {
			conn = setUpConnection();
			String sql = "UPDATE users SET firstName = ?, lastName = ? WHERE username = ? RETURNING *";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, u.getFirstName());
				ps.setString(2, u.getLastName());
				ps.setString(3, u.getUsername());
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUser(String username) {
		try {
			conn = setUpConnection();
			String sql = "DELETE FROM users WHERE username = ? RETURNING *";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Connection setUpConnection() throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		return conn;
	} 
	
	public User setUpUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setUsername(rs.getString("username"));
		user.setFirstName(rs.getString("firstName"));
		user.setLastName(rs.getString("lastName"));
		user.setLast4SSN(rs.getInt("last4SSN"));
		return user;
	}

}
