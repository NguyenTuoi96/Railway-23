package com.vti.backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.vti.Utils.ScannerUtils;
import com.vti.entity.enums.PositionName;

public class Exercise1 {
	// Question 2: Tạo method để in ra các thông tin của position gồm có id, name
	public void question2(Connection connection) {

		try {
			Statement statement = connection.createStatement();
			String sql = "SELECT position_id, position_name FROM position";

			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				System.out.println("Position Id: " + resultSet.getInt("position_id") + ", Position Name: "
						+ resultSet.getString("position_name"));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	// Question 3: Tạo method để tạo position, user sẽ nhập vào name.
	public void question3(Connection connection) {
		String sql = "INSERT INTO position (position_name) VALUES (?)";

		try {
			// Tạo 1 đối tượng PreparedStatement
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// Lấy positionName
			String positionName = "";
			System.out.println("Hãy nhâp mã tên của vị trí: 1. Dev, 2. Test, 3. Scrum Master, 4. PM");
			while (true) {
				int positionNameNum = ScannerUtils.inputInt("Bạn nhập sai, hãy nhập lại 1 giá trị số");
				if (1 <= positionNameNum && positionNameNum <= 4) {
					positionName = PositionName.values()[positionNameNum - 1].getPositionName();
					break;
				} else {
					System.out.println(
							"Bạn nhập sai mã. Hãy nhâp đúng mã của vị trí: 1. Dev, 2. Test, 3. Scrum Master, 4. PM");
				}
			}

			// Set param
			preparedStatement.setString(1, positionName);
			// Thực hiện truy vấn sql
			int effectedRecordAmount = preparedStatement.executeUpdate();

			System.out.println("Số bản ghi bị ảnh hưởng: " + effectedRecordAmount);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	// Question 4: Tạo method để update tên của position gồm có id = 5 thành "Dev".
	public void question4(Connection connection) {
		String sql = "UPDATE position SET position_name = ? WHERE position_id = ?";

		try {
			// Tạo 1 đối tượng PreparedStatement
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// Lấy positionName
			String positionName = PositionName.POSITION_DEV.getPositionName();

			// Set param
			preparedStatement.setString(1, positionName);
			preparedStatement.setInt(2, 5);
			
			// Thực hiện truy vấn sql
			int effectedRecordAmount = preparedStatement.executeUpdate();

			System.out.println("Số bản ghi bị ảnh hưởng: " + effectedRecordAmount);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	// Question 5: Tạo method để delete của position theo id và user sẽ nhập vào id
	public void question5(Connection connection) {
		String sql = "DELETE FROM position WHERE position_id = ?";

		try {
			// Tạo 1 đối tượng PreparedStatement
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			System.out.println("Hãy nhập vào id bạn muốn xóa");
			int id = ScannerUtils.inputInt("Bạn nhập sai, hãy nhập lại 1 giá trị số");

			// Set param
			preparedStatement.setInt(1, id);
			
			// Thực hiện truy vấn sql
			int effectedRecordAmount = preparedStatement.executeUpdate();

			System.out.println("Số bản ghi bị ảnh hưởng: " + effectedRecordAmount);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
