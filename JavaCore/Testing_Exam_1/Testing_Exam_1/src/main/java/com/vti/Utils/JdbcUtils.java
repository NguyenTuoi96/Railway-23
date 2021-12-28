package com.vti.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
	private static Connection connection = null;

	public static void isConnectedForTesting() throws ClassNotFoundException, SQLException {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("src/main/resource/database.properties"));

			final String DB_URL = properties.getProperty("url");
			final String USER_NAME = properties.getProperty("username");
			final String PASSWORD = properties.getProperty("password");
			final String DRIVER = properties.getProperty("driverName");

			// Đăng kí Driver Class với DriverManager
			Class.forName(DRIVER);

			// kết nối
			connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);

			System.out.println("Kết nối DB thành công!");

		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException("Lỗi đăng kí Driver");
		} catch (SQLException e) {
			throw new SQLException("Lỗi kết nối sql");
		} catch (FileNotFoundException e) {
			System.out.println("Lỗi không tìm thấy file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Lỗi không đọc được file");
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		try {
			if (connection != null && !connection.isClosed()) {
				return connection;
			}else {
				isConnectedForTesting();
				return connection;
			}
		} catch (SQLException e) {
			throw new SQLException("Lỗi kết nối sql");
		}

	}

	public static void disconnect() throws SQLException {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new SQLException("Lỗi kết nối sql");
		}
	}

	public static ResultSet executeQuery(String sql) throws SQLException, ClassNotFoundException {
		if (connection == null || connection.isClosed()) {
			isConnectedForTesting();
		}
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		return resultSet;
	}

	public static PreparedStatement getPreparedStatement(String sql) throws SQLException, ClassNotFoundException {
		if (connection == null || connection.isClosed()) {
			isConnectedForTesting();
		}
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		return preparedStatement;
	}
}
