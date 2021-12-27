package com.vti.backend.DataLayer.Iplm;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.vti.ConstantPack;
import com.vti.Utils.JdbcUtils;
import com.vti.backend.DataLayer.IAccountRepository;
import com.vti.backend.DataLayer.IDepartmentRepository;
import com.vti.backend.DataLayer.IGroupRepository;
import com.vti.backend.DataLayer.IPositionRepository;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;

/**
 * This class is Account Repository Implement
 * 
 * @Description:
 * @author: NTTuoi
 * @create_date: Dec 27, 2021
 * @version: 1.0
 * @modifer: NTTuoi
 * @modifer_date: Dec 27, 2021
 */
public class IplmAccountRepository implements IAccountRepository {
	@Override
	public List<Account> getListAccounts() throws SQLException, ClassNotFoundException, Exception {
		try {
			List<Account> list = new ArrayList<Account>();
			String sql = "SELECT * FROM `account`;";
			ResultSet resultSet = JdbcUtils.executeQuery(sql);
			IDepartmentRepository departmentRepository = new IplmDepartmentRepository();
			IPositionRepository positionRepository = new IplmPositionRepository();
			IGroupRepository groupRepository = new IplmGroupRepository();
			while (resultSet.next()) {
				Department department = departmentRepository
						.getDepartmentsById((byte) resultSet.getInt("department_id"));
				Position position = positionRepository.getPositionById((byte) resultSet.getInt("position_id"));
				List<Group> groupList = groupRepository.getListGroupInAccount((byte) resultSet.getInt("account_id"));

				list.add(new Account((byte) resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), department, position, groupList,
						resultSet.getDate(8)));
			}
			return list;
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Account getAccountsById(int id) throws SQLException, ClassNotFoundException, Exception {
		try {

			String sql = "SELECT * FROM `account` WHERE account_id = " + id + ";";
			ResultSet resultSet = JdbcUtils.executeQuery(sql);
			if (resultSet.next()) {
				IplmDepartmentRepository depRepository = new IplmDepartmentRepository();
				Department department = depRepository.getDepartmentsById((byte) resultSet.getInt(6));

				IplmPositionRepository positionRepository = new IplmPositionRepository();
				Position position = positionRepository.getPositionById((byte) resultSet.getInt(7));

				Account ac = new Account((byte) resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), department, position, null,
						resultSet.getDate(8));
				return ac;
			} else {
				throw new SQLException(ConstantPack.ERROR_ACCOUNT_NOT_FOUND + id);
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public boolean isAccountUserNameExists(String name) throws SQLException, ClassNotFoundException, Exception {
		try {
			String sql = "SELECT * FROM `account` WHERE username = ?;";

			PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(sql);
			preparedStatement.setString(1, name);

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
	public boolean isAccountEmailExists(String email) throws SQLException, ClassNotFoundException, Exception {
		try {
			String sql = "SELECT * FROM `account` WHERE email = ?;";

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
	public boolean isAccountIdExists(int id) throws SQLException, ClassNotFoundException, Exception {
		try {
			String sql = "SELECT * FROM `account` WHERE account_id = ?;";

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
	public int createAccount(String email, String userName, String fullName, String gender, byte department_id,
			byte position_id, Date sqlCreateDate) throws SQLException, ClassNotFoundException, Exception {
		try {

			String sql = "INSERT INTO `account` (email, username, fullname, gender, department_id, position_id, create_date) VALUES (?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, userName);
			preparedStatement.setString(3, fullName);
			preparedStatement.setString(4, gender);
			preparedStatement.setInt(5, department_id);
			preparedStatement.setInt(6, position_id);
			preparedStatement.setDate(7, sqlCreateDate);

			int effectedRecordAmount = preparedStatement.executeUpdate();
			return effectedRecordAmount;
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public int updateAccount(int id, String email, String userName, String fullName, String gender, byte departmentId,
			byte positionId) throws SQLException, ClassNotFoundException, Exception {
		try {
			String sql = "UPDATE `account` SET email = ?" + ", username = ?" + ", fullname = ?" + ", gender = ?"
					+ ", department_id = ?" + ", position_id = ?" + " WHERE account_id = ?;";

			PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, userName);
			preparedStatement.setString(3, fullName);
			preparedStatement.setString(4, gender);
			preparedStatement.setInt(5, departmentId);
			preparedStatement.setInt(6, positionId);
			preparedStatement.setInt(7, id);

			int effectedRecordAmount = preparedStatement.executeUpdate();
			return effectedRecordAmount;
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public int deleteAccount(int id) throws SQLException, ClassNotFoundException, Exception {
		try {
			String sql = "DELETE FROM `account` WHERE account_id = ?;";

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
