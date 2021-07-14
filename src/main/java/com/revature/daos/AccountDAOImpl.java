package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Account;
import com.revature.model.User;
import com.revature.utils.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO {

	private Connection conn = null;

	@Override
	public Account getAccount(String username) {
		try {
			conn = setUpConnection();
			String sql = "SELECT * FROM accounts WHERE username = ?";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					return setUpAccount(rs);
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
	public List<Account> getAllAccounts() {
		List<Account> accounts = new ArrayList<Account>();
		try {
			conn = setUpConnection();
			String sql = "SELECT * FROM accounts WHERE approved = true";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					accounts.add(setUpAccount(rs));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public boolean addAccount(Account a) {
		try {
			conn = setUpConnection();
			String sql = "INSERT INTO accounts VALUES (DEFAULT, ?, ?, ?, ?, false) RETURNING *";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, a.getUsername());
				ps.setString(2, a.getPassword());
				ps.setDouble(3,a.getBalance());
				ps.setInt(4, a.getAccountLevel());
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
	public boolean updateAccount(Account a) {
		try {
			conn = setUpConnection();
			String sql = "UPDATE accounts SET balance = ?, approved = ? WHERE username = ? RETURNING *";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setDouble(1, a.getBalance());
				ps.setBoolean(2, a.isApproved());
				ps.setString(3, a.getUsername());
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
	public boolean updateAccountBalance(Account a) {
		try {
			conn = setUpConnection();
			String sql = "UPDATE accounts SET balance = ? WHERE username = ? RETURNING *";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setDouble(1, a.getBalance());
				ps.setString(2, a.getUsername());
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
	public boolean deleteAccount(String username) {
		try {
			conn = setUpConnection();
			String sql = "DELETE FROM accounts WHERE username = ? RETURNING *";
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

	public Account setUpAccount(ResultSet rs) throws SQLException {
		Account account = new Account();
		account.setId(rs.getInt("id"));
		account.setUsername(rs.getString("username"));
		account.setPassword(rs.getString("pass"));
		account.setBalance(rs.getDouble("balance"));
		account.setAccountLevel(rs.getInt("accountlevel"));
		account.setApproved(rs.getBoolean("approved"));
		return account;
	}
}
