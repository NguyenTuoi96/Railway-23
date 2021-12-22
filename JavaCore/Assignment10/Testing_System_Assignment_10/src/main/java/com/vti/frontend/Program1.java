package com.vti.frontend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.vti.Utils.ScannerUtils;
import com.vti.backend.Exercise1;

public class Program1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		new ScannerUtils(scanner);
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("src/main/resource/database.properties"));

			final String DB_URL = properties.getProperty("url");
			final String USER_NAME = properties.getProperty("username");
			final String PASSWORD = properties.getProperty("password");

			// Đăng kí Driver Class với DriverManager
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Lấy 1 connection đến database
			Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);

			System.out.println("Kết nối thành công!");

			// Các Question
			Exercise1 ex1 = new Exercise1();
			ex1.question2(connection);
//			ex1.question3(connection);
//			ex1.question4(connection);
//			ex1.question5(connection);

			// Đóng kết nối
			connection.close();

		} catch (ClassNotFoundException e) {
			System.out.println("Lỗi đăng kí Driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Lỗi kết nối sql");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("Lỗi không tìm thấy file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Lỗi không đọc được file");
			e.printStackTrace();
		} finally {
			scanner.close();
		}

	}

}
