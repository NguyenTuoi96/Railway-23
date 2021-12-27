package com.vti.backend.DataLayer.Iplm;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.Utils.JdbcUtils;
import com.vti.backend.DataLayer.IDepartmentRepository;
import com.vti.entity.Department;

/**
 * This class is Department Repository Implements
 * 
 * @Description:
 * @author: NTTuoi
 * @create_date: Dec 26, 2021
 * @version: 1.0
 * @modifer: NTTuoi
 * @modifer_date: Dec 26, 2021
 */
public class IplmDepartmentRepository implements IDepartmentRepository {
	@Override
	public List<Department> getDepartments() throws SQLException, ClassNotFoundException, Exception {
		try {
			List<Department> list = new ArrayList<Department>();
			String sql = "SELECT * FROM department;";
			ResultSet resultSet = JdbcUtils.executeQuery(sql);
			while (resultSet.next()) {
				list.add(new Department((byte) resultSet.getInt(1), resultSet.getString(2)));
			}
			return list;
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}

	@Override
	public Department getDepartmentsById(byte id) throws SQLException, ClassNotFoundException, Exception {
		try {

			String sql = "SELECT * FROM department WHERE department_id = " + id + ";";
			ResultSet resultSet = JdbcUtils.executeQuery(sql);
			if (resultSet.next() == true) {
				Department department = new Department((byte) resultSet.getInt(1), resultSet.getString(2));
				return department;
			} else {
				throw new SQLException("Cannot find department which has id = " + id);
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}

	@Override
	public boolean isDepartmentNameExists(String name) throws SQLException, ClassNotFoundException, Exception {
		try {
			String sql = "SELECT * FROM department WHERE department_name = ?;";

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
		}
	}

	@Override
	public boolean isDepartmentIdExists(byte id) throws SQLException, ClassNotFoundException, Exception {
		try {
			String sql = "SELECT * FROM department WHERE department_id = ?;";

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
		}
	}

	@Override
	public int createDepartment(String name) throws SQLException, ClassNotFoundException, Exception {
		try {
			boolean isCheckNameExists = isDepartmentNameExists(name);
			if (isCheckNameExists) {
				throw new SQLException("Department Name is Exists!");
			}
			String sql = "INSERT INTO department (department_name) VALUES (?);";

			PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(sql);
			preparedStatement.setString(1, name);

			int effectedRecordAmount = preparedStatement.executeUpdate();
			return effectedRecordAmount;
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}

	@Override
	public int updateDepartment(int id, String name) throws SQLException, ClassNotFoundException, Exception {
		try {
			// check id
			boolean isCheckIdExists = isDepartmentIdExists((byte) id);
			if (isCheckIdExists == false) {
				throw new SQLException("Cannot find department which has id = " + id);
			}

			// check name
			boolean isCheckNameExists = isDepartmentNameExists(name);
			if (isCheckNameExists == true) {
				throw new SQLException("Department Name is Exists!");
			}
			String sql = "UPDATE department SET department_name = ? WHERE department_id = ?;";

			PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);

			int effectedRecordAmount = preparedStatement.executeUpdate();
			return effectedRecordAmount;
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}

	@Override
	public int deleteDepartment(int id) throws SQLException, ClassNotFoundException, Exception {
		try {
			// check id
			boolean isCheckIdExists = isDepartmentIdExists((byte) id);
			if (isCheckIdExists == false) {
				throw new SQLException("Cannot find department which has id = " + id);
			}

			String sql = "DELETE FROM department WHERE department_id = ?;";

			PreparedStatement preparedStatement = JdbcUtils.getPreparedStatement(sql);
			preparedStatement.setInt(1, id);

			int effectedRecordAmount = preparedStatement.executeUpdate();
			return effectedRecordAmount;
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}
}
