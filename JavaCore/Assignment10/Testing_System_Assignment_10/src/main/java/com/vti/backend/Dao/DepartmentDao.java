package com.vti.backend.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.vti.Utils.JdbcUtils;
import com.vti.entity.Department;

//Tạo class DepartmentDao trong package backend để cung cấp các method chuyên thao tác với table Department trong database
public class DepartmentDao {
	private JdbcUtils jdbcUtils;

	public DepartmentDao() throws ClassNotFoundException, SQLException {
		jdbcUtils = new JdbcUtils();
	}

	public List<Department> getDepartments() throws SQLException, ClassNotFoundException {
		try {
			List<Department> list = new ArrayList<Department>();
			String sql = "SELECT * FROM department;";
			ResultSet resultSet = jdbcUtils.executeQuery(sql);
			while (resultSet.next()) {
				list.add(new Department((byte) resultSet.getInt(1), resultSet.getString(2)));
			}
			return list;
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} finally {
			jdbcUtils.disconnect();
		}
	}

	public Department getDepartmentsById(byte id) throws SQLException, ClassNotFoundException {
		try {

			String sql = "SELECT * FROM department WHERE department_id = " + id + ";";
			ResultSet resultSet = jdbcUtils.executeQuery(sql);
			if (resultSet.next()) {
				Department department = new Department((byte) resultSet.getInt(1), resultSet.getString(2));
				return department;
			} else {
				System.out.println("Cannot find department which has id = " + id);
				return null;
			}
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} finally {
			jdbcUtils.disconnect();
		}
	}

	public boolean isDepartmentNameExists(String name) throws SQLException, ClassNotFoundException {
		try {
			String sql = "SELECT * FROM department WHERE department_name = ?;";

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

	public boolean isDepartmentIdExists(byte id) throws SQLException, ClassNotFoundException {
		try {
			String sql = "SELECT * FROM department WHERE department_id = ?;";

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

	public void createDepartment(String name) throws SQLException, ClassNotFoundException {
		try {
//			// Check name
//			List<Department> listDepartment = this.getDepartments();
//			Optional<Department> obj = listDepartment.stream()
//					.filter(d -> d.getDepartmentName().equals(name))
//					.findFirst();
//			if(!obj.isEmpty()) {
//				System.out.println("Department Name is Exists!");
//				return;
//			}	
			boolean isCheckNameExists = isDepartmentNameExists(name);
			if(isCheckNameExists) {
				System.out.println("Department Name is Exists!");
				return;
			}
			String sql = "INSERT INTO department (department_name) VALUES (?);";

			PreparedStatement preparedStatement = jdbcUtils.getpreparedStatement(sql);
			preparedStatement.setString(1, name);

			int effectedRecordAmount = preparedStatement.executeUpdate();
			System.out.println("Đã thêm " + effectedRecordAmount + " dòng");
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} finally {
			jdbcUtils.disconnect();
		}
	}

	public void updateDepartment(int id, String name) throws SQLException, ClassNotFoundException {
		try {
			// check id
			boolean isCheckIdExists = isDepartmentIdExists((byte) id);
			if(!isCheckIdExists) {
				System.out.println("Cannot find department which has id = " + id);
				return;
			}
			
			// check name
			boolean isCheckNameExists = isDepartmentNameExists(name);
			if(isCheckNameExists) {
				System.out.println("Department Name is Exists!");
				return;
			}
			String sql = "UPDATE department SET department_name = ? WHERE department_id = ?;";

			PreparedStatement preparedStatement = jdbcUtils.getpreparedStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);

			int effectedRecordAmount = preparedStatement.executeUpdate();
			System.out.println("Đã sửa " + effectedRecordAmount + " dòng");
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		} finally {
			jdbcUtils.disconnect();
		}
	}

	public void deleteDepartment(int id) throws SQLException, ClassNotFoundException {
		try {
			// check id
			boolean isCheckIdExists = isDepartmentIdExists((byte) id);
			if(!isCheckIdExists) {
				System.out.println("Cannot find department which has id = " + id);
				return;
			}
			
			String sql = "DELETE FROM department WHERE department_id = ?;";

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
