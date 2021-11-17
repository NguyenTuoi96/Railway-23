package com.vti.academy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.vti.academy.enums.PositionName;

public class Exercise2SystemOutPrintf {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		// Tạo dữ liệu
		// tạo đối tượng Department
		Department department1 = new Department();
		department1.departmentId = 1;
		department1.departmentName = "Phòng giám đốc";

		Department department2 = new Department();
		department2.departmentId = 2;
		department2.departmentName = "Phòng Sale";

		Department department3 = new Department();
		department3.departmentId = 3;
		department3.departmentName = "Phòng marketting";

		// tạo đối tượng Position
		Position position1 = new Position();
		position1.positionId = 1;
		position1.positionName = PositionName.POSITION_DEV.getPositionName();

		Position position2 = new Position();
		position2.positionId = 2;
		position2.positionName = PositionName.POSITION_PM.getPositionName();

		Position position3 = new Position();
		position3.positionId = 3;
		position3.positionName = PositionName.POSITION_SCRUM_MASTER.getPositionName();
		
		// tạo đối tượng Account
		Account account1 = new Account();
		account1.accountId = 1;
		account1.email = "nguyenanh@gmail.com";
		account1.userName = "NguyenAnh";
		account1.fullName = "Nguyễn Văn Anh";
		account1.department = department1;
		account1.position = position1;
		account1.createDate = dateFormat.parse("01-01-1996");

		Account account2 = new Account();
		account2.accountId = 2;
		account2.email = "nguyenhoa@gmail.com";
		account2.userName = "HoaNguyen";
		account2.fullName = "Nguyễn Thị Hoa";
		account2.department = department2;
		account2.position = position2;
		account2.createDate = new Date();

		Account account3 = new Account();
		account3.accountId = 3;
		account3.email = "nguyenphuong@gmail.com";
		account3.userName = "PhuongNguyen";
		account3.fullName = "Nguyễn Thảo Phương";
		account3.department = department3;
		account3.position = position3;
		account3.createDate = new Date();
		
		Account[] accArr = new Account[] { account1, account2, account3 };

		// Question 1
		question1();
		System.out.println();

		// Question 2
		question2();
		System.out.println();

		// Question 3
		question3();
		System.out.println();

		// Question 4
		question4();
		System.out.println();

		// Question 5
		question5();
		System.out.println();

		// Question 6
		question6(accArr);
		System.out.println();

	}

	/**
	 * Question 1 Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in
	 * ra số nguyên đó
	 * 
	 */
	public static void question1() {
		System.out.println("Question 1:");
		int x = 5;
		System.out.printf("%d %n", x);
	}

	/**
	 * Question 2 Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out
	 * printf để in ra số nguyên đó thành định dạng như sau: 100,000,000
	 * 
	 */
	public static void question2() {
		System.out.println("Question 2:");
		int x = 100000000;
		System.out.printf(Locale.US, "%,d %n", x);
	}

	/**
	 * Question 3 Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để
	 * in ra số thực đó chỉ bao gồm 4 số đằng sau
	 * 
	 */
	public static void question3() {
		System.out.println("Question 3:");
		double x = 5.567098;
		System.out.printf("%6.4f %n", x);
	}

	/**
	 * Question 4 Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó
	 * theo định dạng như sau: Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console
	 * như sau: Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.
	 * 
	 */
	public static void question4() {
		System.out.println("Question 4:");
		String name = "Nguyễn Văn A";
		System.out.printf("%s %s %s", "Tên tôi là", name, "và tôi đang độc thân\n");
	}

	/**
	 * Question 5 Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó
	 * theo định dạng như sau: Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console
	 * như sau: Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.
	 * 
	 */
	public static void question5() {
		System.out.println("Question 5:");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
		SimpleDateFormat minuteFormat = new SimpleDateFormat("mm");
		SimpleDateFormat secondFormat = new SimpleDateFormat("ss");
		Date now = new Date();
		System.out.printf("%s %sh:%sp:%ss\n", dateFormat.format(now), hourFormat.format(now), minuteFormat.format(now),
				secondFormat.format(now));
	}

	/**
	 * Quesstion 6 In ra thông tin account (như Question 8 phần FOREACH) theo định dạng table (giống trong Database)
	 * 
	 * @param accountArr các account
	 */
	public static void question6(Account[] accountArr) {
		System.out.println("Question 6:");
		System.out.println("Thông tin account: ");
		System.out.printf("%s,%s,%s%n", "email", "fullName", "departmentName");
		for (Account account : accountArr) {
			System.out.printf("%s,%s,%s%n", account.email, account.fullName, account.department.departmentName);
		}
	}

}
