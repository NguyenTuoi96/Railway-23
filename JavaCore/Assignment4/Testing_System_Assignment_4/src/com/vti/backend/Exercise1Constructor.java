package com.vti.backend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;

public class Exercise1Constructor {
	static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");	
	//	Question 1:
	//	Tạo constructor cho department:
	//	a) không có parameters
	//	b) Có 1 parameter là nameDepartment và default id của Department = 0
	//	Khởi tạo 1 Object với mỗi constructor ở trên
	public void question1() {
		// không có parameters
		Department departmentNoparam = new Department();		
		departmentNoparam.setDepartmentId((byte) 1);
		departmentNoparam.setDepartmentName("Phòng Sale");
		System.out.println("departmentNoparam:");
		System.out.println("departmentId = " + departmentNoparam.getDepartmentId());
		System.out.println("departmentName = " + departmentNoparam.getDepartmentName());
		
		// có parameters
		Department departmentParam = new Department("Phòng Marketing");
		System.out.println("\ndepartmentParam:");
		System.out.println("departmentId = " + departmentParam.getDepartmentId());
		System.out.println("departmentName = " + departmentParam.getDepartmentName());
		
	}
	
//	Question 2:
//		Tạo constructor cho Account:
//		a) Không có parameters
//		b) Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName)
//		c) Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName) và Position của User, default createDate = now
//		d) Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName) và Position của User, createDate
//		Khởi tạo 1 Object với mỗi constructor ở trên	
	public void question2() throws ParseException {
		// không có parameters
		Account accountNonParam = new Account();		
		accountNonParam.setAccountId(1);
		accountNonParam.setEmail("xxx@gmail.com");
		accountNonParam.setUserName("thanhanh");
		accountNonParam.setFullName("Nguyễn Thanh Anh");
		accountNonParam.setDepartment(null);
		accountNonParam.setPosition(null);
		accountNonParam.setCreateDate(new Date());
		accountNonParam.setGroups(null);
		accountNonParam.setSalary(10000000f);
		System.out.println("\naccountNoparam:");
		System.out.println(accountNonParam.toString());
		
		// có 5 parameters
		Account account5Param = new Account(2, "yyy@gmail.com", "namphong", "Nam Phong", "Nguyễn");
		System.out.println("\naccount5Param:");
		System.out.println(account5Param.toString());
		
		// có 6 parameters
		Position ps = new Position();
		ps.setPositionId((byte) 1);
		ps.setPositionName("Dev");
		Account account6Param = new Account(3, "zzz@gmail.com", "namanh", "Nam Anh", "Nguyễn", ps);
		System.out.println("\naccount6Param:");
		System.out.println(account6Param.toString());
		
		// có 7 parameters
		Account account7Param = new Account(4, "www@gmail.com", "ngochoa", "Ngọc Hoa", "Nguyễn", ps, dateFormat.parse("02-11-2019"));
		System.out.println("\naccount7Param:");
		System.out.println(account7Param.toString());
	}
	
//	Question 3:
//		Tạo constructor cho Group:
//		a) không có parameters
//		b) Có các parameter là GroupName, Creator, array Account[] accounts, CreateDate
//		c) Có các parameter là GroupName, Creator, array String[] usernames , CreateDate
//		Với mỗi username thì sẽ khởi tạo 1 Account (chỉ có thông tin username, các thông tin còn lại = null).
//		Khởi tạo 1 Object với mỗi constructor ở trên
	public void question3() throws ParseException {
		Account account = new Account(2, "yyy@gmail.com", "namphong", "Nam Phong", "Nguyễn");
		// không có parameters
		Group groupNonParam = new Group();
		groupNonParam.setGroupId((byte) 0);
		groupNonParam.setGroupName("Group 1");
		groupNonParam.setCreator(account);
		groupNonParam.setCreateDate(new Date());
		groupNonParam.setAccounts(new Account[] {account});
		
		System.out.println("\ngroupNonParam:");
		System.out.println(groupNonParam.toString());
		
		// Có các parameter là GroupName, Creator, array Account[] accounts, CreateDate
		Group groupParam1 = new Group("Group 2", account, new Account[] {account}, dateFormat.parse("01-11-2019"));
		System.out.println("\ngroupParam1:");
		System.out.println(groupParam1.toString());
//		
		// Có các parameter là GroupName, Creator, array String[] usernames , CreateDate
		Group groupParam2 = new Group("Group 3", account, new String[] {}, dateFormat.parse("01-12-2020"));
		System.out.println("\ngroupParam2:");
		System.out.println(groupParam2.toString());
	}

}
