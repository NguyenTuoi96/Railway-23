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
	private Connection connection = null;

	public JdbcUtils() throws ClassNotFoundException, SQLException {
		isConnectedForTesting(false);
	}

	public void isConnectedForTesting(boolean showMsg) throws ClassNotFoundException, SQLException {
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
			this.connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);

			if (showMsg) {
				System.out.println("Kết nối DB thành công!");
			}

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

	public Connection connect() throws SQLException, ClassNotFoundException {
		try {
			if (!this.connection.isClosed() && this.connection != null) {
				return this.connection;
			} else {
				this.isConnectedForTesting(false);
				return this.connection;
			}
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException("Lỗi đăng kí Driver");
		} catch (SQLException e) {
			throw new SQLException("Lỗi kết nối sql");
		}

	}

	public void disconnect() throws SQLException {
		try {
			if (!this.connection.isClosed() && this.connection != null) {
				this.connection.close();
			}
		} catch (SQLException e) {
			throw new SQLException("Lỗi kết nối sql");
		}
	}

	public ResultSet executeQuery(String sql) throws SQLException, ClassNotFoundException {
		if (this.connection.isClosed() || this.connection == null) {
			this.isConnectedForTesting(false);
		}
		Statement statement = this.connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		return resultSet;
	}

	public PreparedStatement getpreparedStatement(String sql) throws SQLException, ClassNotFoundException {
		if (this.connection.isClosed() || this.connection == null) {
			this.isConnectedForTesting(false);
		}
		PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
		return preparedStatement;
	}
}
