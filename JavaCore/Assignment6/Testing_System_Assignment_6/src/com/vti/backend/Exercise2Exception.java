package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.ScannerUtils;

public class Exercise2Exception {

	public void question1() {
		try {
			float result = divide(7, 0);
			System.out.println(result);
		} catch (ArithmeticException e) {
			System.out.println("Cannot divide 0");
		} finally {
			System.out.println("divide completed!");
		}
	}

	private float divide(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException();
		} else {
			return (float) a / b;
		}
	}

	public void question3() {
		try {
			int[] numbers = { 1, 2, 3 };
			System.out.println(numbers[10]);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void question4() {
		getIndex(1);
	}

	private void getIndex(int index) {
		try {
			Department department1 = new Department("Phòng sale");
			Department department2 = new Department("Phòng phát triển");
			Department department3 = new Department("Phòng giám đốc");
			Department[] departmentArr = new Department[] { department1, department2, department3 };

			System.out.println(departmentArr[index]);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Cannot find department.");
		}

	}

	public void question5(Scanner sc) {
		Integer output = inputAge(sc);
		if (output != null) {
			System.out.println(output);
		}
	}

	private Integer inputAge(Scanner sc) {
		while (true) {
			try {
				System.out.println("Mời bạn nhập vào 1 số");
				String iput = sc.next();
				int num = Integer.valueOf(iput).intValue();
				checkLessThan0(num);
				return num;
			} catch (NumberFormatException e) {
				System.out.println("wrong inputing! Please input an age as int, input again.");
				
			} catch (ArithmeticException e) {
				System.out.println(e.getMessage());
				return null;
			}
		}

	}

	private void checkLessThan0(int number) {
		if (number < 0) {
			throw new ArithmeticException("Wrong inputing! The age must be greater than 0, please input again.");
		}
	}

	public void question8(ScannerUtils scUtils) {
		
		System.out.println("Hãy nhập 1 số float");
		float floatVal = scUtils.inputFloat("bạn đã nhập sai, mời nhập lại");
		System.out.println("bạn vừa nhập: " + floatVal);
		
		System.out.println("Hãy nhập 1 số double");
		double doubleVal = scUtils.inputDouble("bạn đã nhập sai, mời nhập lại");
		System.out.println("bạn vừa nhập: " + doubleVal);
		
		System.out.println("Hãy nhập 1 chuỗi");
		String strVal = scUtils.inputString();
		System.out.println("bạn vừa nhập chuỗi: '" + strVal + "'");
		
	}

	public void question9(ScannerUtils scUtils) {
		
		Department dp = new Department(scUtils);
		System.out.println(dp);
		
		Position po = new Position(scUtils);
		System.out.println(po);
		
	}

	public void question10(ScannerUtils scUtils) {
		
		Group gr = new Group(scUtils);
		System.out.println(gr);
	}
}
