package com.vti.academy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Exercise2Defaultvalue {
	public static void main(String[] args) {
		
		// Question 1
		question1();
	}

	/**
	 * Question 1: Không sử dụng data đã insert từ bài trước, tạo 1 array Account và
	 * khởi tạo 5 phần tử theo cú pháp (sử dụng vòng for để khởi tạo):  Email:
	 * "Email 1"  Username: "User name 1"  FullName: "Full name 1"  CreateDate:
	 * now
	 * 
	 */
	private static void question1() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Question 1");
		Account[] accountArr = new Account[5];
		// khởi tạo
		for(int i = 0; i < 5; i++) {
			accountArr[i] = new Account();
			accountArr[i].email = "Email " + (i + 1);
			accountArr[i].userName = "User name " + (i + 1);
			accountArr[i].fullName = "Full name " + (i + 1);
			accountArr[i].createDate = new Date();
		}
		
		// in ra 
		for(Account acc : accountArr) {
			System.out.println("Email: " + acc.email + ", Username: " + acc.userName + ", FullName: " + acc.fullName + ", CreateDate: " + dateFormat.format(acc.createDate));
		}
	}

}
