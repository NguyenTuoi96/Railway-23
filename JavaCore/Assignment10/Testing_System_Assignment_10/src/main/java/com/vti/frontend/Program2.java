package com.vti.frontend;
import java.sql.SQLException;
import java.util.Scanner;

import com.vti.Utils.ScannerUtils;
import com.vti.backend.Exercise2;

public class Program2 {

	public static void main(String[] args) {
		Exercise2 ex2 = new Exercise2();
		Scanner scanner = new Scanner(System.in);
		new ScannerUtils(scanner);
		try {
//			ex2.question1();
//			ex2.question2();
//			ex2.question3();
//			ex2.question4();
//			ex2.question5();
//			ex2.question6();
			ex2.question7();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			scanner.close();
		}
	}

}
