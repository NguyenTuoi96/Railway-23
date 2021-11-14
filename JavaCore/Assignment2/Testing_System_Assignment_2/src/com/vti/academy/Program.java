package com.vti.academy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.vti.academy.enums.PositionName;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
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
		account1.createDate = dateFormat.parse("01-01-1996");
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
		account3.accountId = 3;
		account3.email = "nguyenphuong@gmail.com";
		account3.userName = "PhuongNguyen";
		account3.fullName = "Nguyễn Thảo Phương";
		account3.department = department3;
		account3.position = position3;
		account3.createDate = new Date();
		account3.groups = new Group[] { group1, group2, group3 };

		// thêm creator, acoounts cho group
		group1.creator = account1;
		group1.accounts = new Account[] { account1, account2, account3 };

		group2.creator = account2;
		group2.accounts = new Account[] { account1, account3 };

		group3.creator = account3;
		group3.accounts = new Account[] { account3 };

		// tạo đối tượng GroupAccount
		GroupAccount groupAccount1 = new GroupAccount();
		groupAccount1.group = group2;
		groupAccount1.account = account2;
		groupAccount1.JoinDate = new Date();

		GroupAccount groupAccount2 = new GroupAccount();
		groupAccount2.group = group3;
		groupAccount2.account = account3;
		groupAccount2.JoinDate = new Date();

		GroupAccount groupAccount3 = new GroupAccount();
		groupAccount3.group = group2;
		groupAccount3.account = account3;
		groupAccount3.JoinDate = new Date();
		
	}

}
