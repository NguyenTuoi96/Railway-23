package com.vti.backend.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vti.Utils.JdbcUtils;
import com.vti.entity.Account;
import com.vti.entity.Department;

//Tạo class AccountDao trong package backend để cung cấp các method chuyên thao tác với table Account trong database
public class AccountDao {
	private JdbcUtils jdbcUtils;

	public AccountDao() throws ClassNotFoundException, SQLException {
		jdbcUtils = new JdbcUtils();
	}

	public List<Account> getAccounts() throws SQLException, ClassNotFoundException {
		try {
			List<Account> list = new ArrayList<Account>();
			String sql = "SELECT * FROM `account`;";
			ResultSet resultSet = jdbcUtils.executeQuery(sql);
			while (resultSet.next()) {
				DepartmentDao depDao = new DepartmentDao();
				Department department = depDao.getDepartmentsById((byte) resultSet.getInt(6));
				
				list.add(new Account((byte) resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), department,
						null, resultSet.getDate(8)));
			}
			return list;
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} finally {
			jdbcUtils.disconnect();
		}
	}

	public Account getAccountsById(byte id) throws SQLException, ClassNotFoundException {
		try {

			String sql = "SELECT * FROM `account` WHERE account_id = " + id + ";";
			ResultSet resultSet = jdbcUtils.executeQuery(sql);
			if (resultSet.next()) {
				DepartmentDao depDao = new DepartmentDao();
				Department department = depDao.getDepartmentsById((byte) resultSet.getInt(6));
				
				Account ac = new Account((byte) resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), department,
						null, resultSet.getDate(8));
				return ac;
			} else {
				System.out.println("Cannot find account which has id = " + id);
				return null;
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} finally {
			jdbcUtils.disconnect();
		}
	}

	public boolean isAccountNameExists(String name) throws SQLException, ClassNotFoundException {
		try {
			String sql = "SELECT * FROM `account` WHERE username = ?;";

			PreparedStatement preparedStatement = jdbcUtils.getpreparedStatement(sql);
			preparedStatement.setString(1, name);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} finally {
			jdbcUtils.disconnect();
		}
	}

	public boolean isAccountEmailExists(String email) throws SQLException, ClassNotFoundException {
		try {
			String sql = "SELECT * FROM `account` WHERE email = ?;";

			PreparedStatement preparedStatement = jdbcUtils.getpreparedStatement(sql);
			preparedStatement.setString(1, email);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} finally {
			jdbcUtils.disconnect();
		}
	}

	public boolean isAccountIdExists(int id) throws SQLException, ClassNotFoundException {
		try {
			String sql = "SELECT * FROM `account` WHERE account_id = ?;";

			PreparedStatement preparedStatement = jdbcUtils.getpreparedStatement(sql);
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} finally {
			jdbcUtils.disconnect();
		}
	}

	public void createAccount(String email, String userName, String fullName, String gender, byte department_id, byte position_id) throws SQLException, ClassNotFoundException {
		try {
			boolean isCheckNameExists = isAccountNameExists(userName);
			if (isCheckNameExists) {
				System.out.println("UserName Name is Exists!");
				return;
			}
			
			boolean isCheckEmailExists = isAccountNameExists(email);
			if (isCheckEmailExists) {
				System.out.println("Email Name is Exists!");
				return;
			}
			
			String sql = "INSERT INTO `account` (email, username, fullname, gender, department_id, position_id, create_date) VALUES (?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement preparedStatement = jdbcUtils.getpreparedStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, userName);
			preparedStatement.setString(3, fullName);
			preparedStatement.setString(4, gender);
			preparedStatement.setInt(5, department_id);
			preparedStatement.setInt(6, position_id);
			preparedStatement.setDate(7, (java.sql.Date) new Date());

			int effectedRecordAmount = preparedStatement.executeUpdate();
			System.out.println("Đã thêm " + effectedRecordAmount + " dòng");
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} finally {
			jdbcUtils.disconnect();
		}
	}

	public void updateAccount(int id, String email, String userName, String fullName, String gender, byte department_id, byte position_id) throws SQLException, ClassNotFoundException {
		try {
			// check id
			boolean isCheckIdExists = isAccountIdExists(id);
			if (!isCheckIdExists) {
				System.out.println("Cannot find account which has id = " + id);
				return;
			}
			
			// check userName
			boolean isCheckNameExists = isAccountNameExists(userName);
			if (isCheckNameExists) {
				System.out.println("UserName Name is Exists!");
				return;
			}
			
			// check email
			boolean isCheckEmailExists = isAccountNameExists(email);
			if (isCheckEmailExists) {
				System.out.println("Email Name is Exists!");
				return;
			}
			
			String sql = "UPDATE `account` SET email = ?"
						+ ", username = ?"
						+ ", fullname = ?"
						+ ", gender = ?"
						+ ", department_id = ?"
						+ ", position_id = ?"
						+ " WHERE account_id = ?;";

			PreparedStatement preparedStatement = jdbcUtils.getpreparedStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, userName);
			preparedStatement.setString(3, fullName);
			preparedStatement.setString(4, gender);
			preparedStatement.setInt(5, department_id);
			preparedStatement.setInt(6, position_id);
			preparedStatement.setInt(7, id);

			int effectedRecordAmount = preparedStatement.executeUpdate();
			System.out.println("Đã sửa " + effectedRecordAmount + " dòng");
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} finally {
			jdbcUtils.disconnect();
		}
	}

	public void deleteAccount(int id) throws SQLException, ClassNotFoundException {
		try {
			// check id
			boolean isCheckIdExists = isAccountIdExists(id);
			if (!isCheckIdExists) {
				System.out.println("Cannot find account which has id = " + id);
				return;
			}

			String sql = "DELETE FROM `account` WHERE account_id = ?;";

			PreparedStatement preparedStatement = jdbcUtils.getpreparedStatement(sql);
			preparedStatement.setInt(1, id);

			int effectedRecordAmount = preparedStatement.executeUpdate();
			System.out.println("Đã xóa " + effectedRecordAmount + " dòng");
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} finally {
			jdbcUtils.disconnect();
		}
	}
}
