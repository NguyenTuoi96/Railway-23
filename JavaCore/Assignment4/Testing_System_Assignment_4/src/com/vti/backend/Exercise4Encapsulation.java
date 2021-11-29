package com.vti.backend;

import com.vti.entity.AccountEx4;
import com.vti.entity.Circle;
import com.vti.entity.Date;
import com.vti.entity.Student;

public class Exercise4Encapsulation {

	public void question1() {
		// Demo khởi tạo mỗi student thì người dùng sẽ nhập vào tên, hometown và có điểm
		// học lực = 0
		Student student = new Student("Hoa", "Hà Nội");
		System.out.println("Question1 a: " + student);
		// Demo set điểm vào
		student.setScore(5f);
		System.out.println("Question1 b: " + student);
		// Demo cộng thêm điểm
		student.plusScore(5f);
		System.out.println("Question1 c: " + student);
	}

	public void question2() {
		question2Circle();
		question2Account();
		question2Date();
	}

	public void question2Circle() {
		Circle cicle = new Circle(1.0, "red");
		System.out.println("Question2 area: " + cicle.getArea());
		System.out.println();
	}

	public void question2Account() {
		// tạo 2 account
		AccountEx4 account1 = new AccountEx4("0321", "Hoa", 1000000);
		AccountEx4 account2 = new AccountEx4("0322", "Phong", 2000000);
		// show ttin 2 account
		System.out.println("account1 ban đầu" + account1);
		System.out.println("account2 ban đầu" + account2);

		// nạp tiền cho 2 account
		account1.credit(100000);
		account2.credit(50000);
		// show ttin 2 account
		System.out.println("account1 sau khi nạp 100000 : " + account1);
		System.out.println("account2 sau khi nạp 50000 : " + account2);
		System.out.println();

		// rút tiền 2 account
		account1.debit(50000);
		account2.debit(200000);
		// show ttin 2 account
		System.out.println("account1 sau khi rút 50000 : " + account1);
		System.out.println("account2 sau khi rút 200000 : " + account2);
		System.out.println();

		// chuyển từ account 2 55000 sang account 1
		account2.tranferTo(account1, 55000);
		// show ttin 2 account
		System.out.println("account1 sau khi được chuyển 55000 : " + account1);
		System.out.println("account2 sau khi chuyển 55000 : " + account2);
		System.out.println();
	}

	public void question2Date() {
		int year = 2014;
		Date date = new Date(1, 1, year);
		if (date.isLeapYear()) {
			System.out.println("Năm" + year + "là năm nhuận");
		} else {
			System.out.println("Năm" + year + "không là năm nhuận");
		}
	}
}
