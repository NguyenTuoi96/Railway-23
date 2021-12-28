package com.vti.backend.DataLayer.Iplm;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.ConstantPack;
import com.vti.Utils.JdbcUtils;
import com.vti.backend.DataLayer.IUserRepository;
import com.vti.entity.Admin;
import com.vti.entity.Employee;
import com.vti.entity.User;

/**
 * This class is User Repository Implement
 * 
 * @Description:
 * @author: NTTuoi
 * @create_date: Dec 27, 2021
 * @version: 1.0
 * @modifer: NTTuoi
 * @modifer_date: Dec 27, 2021
 */
public class IplmUserRepository implements IUserRepository {
	@Override
	public List<User> getListInfoUsers() throws SQLException, ClassNotFoundException, Exception {
		try {
			List<User> list = new ArrayList<User>();
			String sql = "SELECT * FROM `user`;";
			ResultSet resultSet = JdbcUtils.executeQuery(sql);
			while (resultSet.next()) {
				list.add(new User(resultSet.getInt("id"), resultSet.getString("fullName"), resultSet.getString("email"),
						resultSet.getString("password"), (byte) resultSet.getInt("user_type")));
			}
			return list;
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public User getUsersById(int id) throws SQLException, ClassNotFoundException, Exception {
		try {
			String sql = "SELECT * FROM `user` WHERE id = ?;";
			PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();	
			if (resultSet.next()) {
				if((byte) resultSet.getInt("user_type") == ConstantPack.CONSTANT_USER_TYPE_ADMIN) {
					// Admin(int id, String fullName, String email, String passWord, int expInYear, byte userType)
					User admin = new Admin(resultSet.getInt("id"), resultSet.getString("fullname"), resultSet.getString("email"),
							resultSet.getString("password"), Byte.valueOf(resultSet.getString("exp_in_year")), (byte) resultSet.getInt("user_type"));
					return admin;
				} else if((byte) resultSet.getInt("user_type") == ConstantPack.CONSTANT_USER_TYPE_EMPLOYEE) {
					// Employee(int id, String fullName, String email, String passWord, String proSkill, byte userType)
					User employee = new Employee(resultSet.getInt("id"), resultSet.getString("fullname"), resultSet.getString("email"),
							resultSet.getString("password"), resultSet.getString("pro_skill"), (byte) resultSet.getInt("user_type"));
					return employee;
				} else {
					// User(int id, String fullName, String email, String passWord, byte userType)
					User user = new User(resultSet.getInt("id"), resultSet.getString("fullname"), resultSet.getString("email"),
							resultSet.getString("password"), (byte) resultSet.getInt("user_type"));
					return user;
				}				
				
			} else {
				throw new SQLException(ConstantPack.ERROR_USER_NOT_FOUND + id);
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public User getUsersByEmailAndPassWord(String email, String password) throws SQLException, ClassNotFoundException, Exception {
		try {
			String sql = "SELECT * FROM `user` WHERE email = ? AND password = ?;";
			PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();	
			if (resultSet.next()) {
				if((byte) resultSet.getInt("user_type") == ConstantPack.CONSTANT_USER_TYPE_ADMIN) {
					// Admin(int id, String fullName, String email, String passWord, int expInYear, byte userType)
					User admin = new Admin(resultSet.getInt("id"), resultSet.getString("fullname"), resultSet.getString("email"),
							resultSet.getString("password"), Byte.valueOf(resultSet.getString("exp_in_year")), (byte) resultSet.getInt("user_type"));
					return admin;
				} else if((byte) resultSet.getInt("user_type") == ConstantPack.CONSTANT_USER_TYPE_EMPLOYEE) {
					// Employee(int id, String fullName, String email, String passWord, String proSkill, byte userType)
					User employee = new Employee(resultSet.getInt("id"), resultSet.getString("fullname"), resultSet.getString("email"),
							resultSet.getString("password"), resultSet.getString("pro_skill"), (byte) resultSet.getInt("user_type"));
					return employee;
				} else {
					// User(int id, String fullName, String email, String passWord, byte userType)
					User user = new User(resultSet.getInt("id"), resultSet.getString("fullname"), resultSet.getString("email"),
							resultSet.getString("password"), (byte) resultSet.getInt("user_type"));
					return user;
				}				
				
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public boolean isUserEmailExists(String email) throws SQLException, ClassNotFoundException, Exception {
		try {
			String sql = "SELECT * FROM `user` WHERE email = ?;";

			PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(sql);
			preparedStatement.setString(1, email);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public boolean isUserIdExists(int id) throws SQLException, ClassNotFoundException, Exception {
		try {
			String sql = "SELECT * FROM `user` WHERE id = ?;";

			PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(sql);
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public boolean isUserPasswordExists(String password) throws SQLException, ClassNotFoundException, Exception {
		try {
			String sql = "SELECT * FROM `user` WHERE `password` = ?;";

			PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(sql);
			preparedStatement.setString(1, password);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	public int createUser(String fullname, String email, String password, Byte expInYear, String proSkill,
			byte userType) throws SQLException, ClassNotFoundException, Exception {
		try {

			String sql = "INSERT INTO `user` (fullname, email, `password`, exp_in_year, pro_skill, user_type) VALUES (?, ?, ?, ?, ?, ?);";
			PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(sql);
			preparedStatement.setString(1, fullname);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, password);
			if(expInYear == null) {				
				preparedStatement.setString(4, null );
			}else {
				preparedStatement.setInt(4, expInYear);
			}
			preparedStatement.setString(5, proSkill);
			preparedStatement.setInt(6, userType);

			int effectedRecordAmount = preparedStatement.executeUpdate();
			return effectedRecordAmount;
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public int deleteUser(int id) throws SQLException, ClassNotFoundException, Exception {
		try {
			String sql = "DELETE FROM `user` WHERE id = ?;";

			PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(sql);
			preparedStatement.setInt(1, id);

			int effectedRecordAmount = preparedStatement.executeUpdate();
			return effectedRecordAmount;
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
