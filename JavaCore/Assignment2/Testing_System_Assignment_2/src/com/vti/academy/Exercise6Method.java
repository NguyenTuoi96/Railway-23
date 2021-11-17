package com.vti.academy;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.vti.academy.enums.PositionName;

public class Exercise6Method {

	public static void main(String[] args) {
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

		// tạo đối tượng Group
		Group group1 = new Group();
		group1.groupId = 1;
		group1.groupName = "Group 1";
		group1.createDate = new Date();

		Group group2 = new Group();
		group2.groupId = 2;
		group2.groupName = "Group 2";
		group2.createDate = new Date();

		Group group3 = new Group();
		group3.groupId = 3;
		group3.groupName = "Group 3";
		group3.createDate = new Date();

		// tạo đối tượng Account
		Account account1 = new Account();
		account1.accountId = 1;
		account1.email = "nguyenanh@gmail.com";
		account1.userName = "NguyenAnh";
		account1.fullName = "Nguyễn Văn Anh";
		account1.department = department1;
		account1.position = position1;
		account1.createDate = new Date();
		account1.groups = new Group[] { group1, group2 };

		Account account2 = new Account();
		account2.accountId = 2;
		account2.email = "nguyenhoa@gmail.com";
		account2.userName = "HoaNguyen";
		account2.fullName = "Nguyễn Thị Hoa";
		account2.department = department2;
		account2.position = position2;
		account2.createDate = new Date();
		account2.groups = new Group[] { group1 };

		Account account3 = new Account();
		account3.accountId = 4;
		account3.email = "nguyenphuong@gmail.com";
		account3.userName = "PhuongNguyen";
		account3.fullName = "Nguyễn Thảo Phương";
		account3.department = department3;
		account3.position = position3;
		account3.createDate = new Date();
		account3.groups = new Group[] { group1, group2, group3 };

		Account account4 = new Account();
		account4.accountId = 3;
		account4.email = "nguyenmy@gmail.com";
		account4.userName = "MyNguyen";
		account4.fullName = "Nguyễn Thảo My";
		account4.department = department3;
		account4.position = position3;
		account4.createDate = new Date();
		account4.groups = new Group[] {};

		// thêm creator, acoounts cho group
		group1.creator = account1;
		group1.accounts = new Account[] { account1, account2, account3 };

		group2.creator = account2;
		group2.accounts = new Account[] { account1, account3 };

		group3.creator = account3;
		group3.accounts = new Account[] { account3 };

		Account[] accArr = new Account[] { account1, account2, account3, account4 };
		
		
		question1();
		
		question2(accArr);
		
		question3();

	}

	/**
	 * Question 1: Tạo method để in ra các số chẵn nguyên dương nhỏ hơn 10
	 * 
	 */
	public static void question1() {
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				System.out.println("số chẵn nguyên dương nhỏ hơn 10: " + i);
			}
		}
	}

	/**
	 * Question 2: Tạo method để in thông tin các account
	 * 
	 */
	public static void question2(Account[] accArr) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("Thông tin account: ");
		// khởi tạo giá trị in
		String printValue = "";
		for (int i = 0; i < accArr.length; i++) {
			// In các thông tin của account
			printValue = "accountId: " + accArr[i].accountId
					+ "\nEmail: " + accArr[i].email + "\nUserName: " + accArr[i].userName
					+ "\nFullName: " + accArr[i].fullName + "\nDepartment: " + accArr[i].department.departmentName
					+ "\nPosition: " + accArr[i].position.positionName + "\nCreateDate: " + dateFormat.format(accArr[i].createDate);
			int cntGroups = accArr[i].groups != null ? accArr[i].groups.length : 0;
			if(cntGroups > 0) {
				// Khi account tham gia vào các group thì lặp mảng group và in các tên group mà account đó tham gia ra
				printValue += "\nCác group tham gia: ";
				for(int j = 0; j < accArr[i].groups.length; j++) {
					if(j == 0) {
						printValue += accArr[i].groups[j].groupName;
					}else {
						printValue += ", " + accArr[i].groups[j].groupName;
					}
				}
				printValue += "\n";
			}else {
				// Nếu không có group nào thì in là không có
				printValue += "\nCác group tham gia: không có\n";
			}
			System.out.println(printValue);
		}
	}

	/**
	 * Question 3: Tạo method để in ra các số nguyên dương nhỏ hơn 10
	 * 
	 */
	public static void question3() {
		for (int i = 0; i < 10; i++) {
			System.out.println("số nguyên dương nhỏ hơn 10: " + i);
		}
	}
}
