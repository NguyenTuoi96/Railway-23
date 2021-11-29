package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.VietnamesePhone;

public class Exercise6Abstraction {
	Scanner sc;

	public Exercise6Abstraction() {
		sc = new Scanner(System.in);
	}

	public void question1() {
		VietnamesePhone vnamPhone = new VietnamesePhone();

		while (true) {
			System.out.println("Lựa chọn chức năng");
			System.out.println("1. InsertContact");
			System.out.println("2. RemoveContact");
			System.out.println("3. UpdateContact");
			System.out.println("4. SearchContact");
			System.out.println("5. ShowContact");
			System.out.println("6. Thoát khỏi chương trình");
			
			int chucnang = sc.nextInt();
			switch (chucnang) {
			case 1: {
				System.out.println("Nhập tên: ");
				String name = sc.next();
				System.out.println("Nhập số phone: ");
				String phone = sc.next();
				vnamPhone.insertContact(name, phone);
				break;
			}
			case 2: {
				System.out.println("Nhập tên: ");
				String name = sc.next();
				vnamPhone.removeContact(name);
				break;
			}
			case 3: {
				System.out.println("Nhập tên: ");
				String name = sc.next();
				System.out.println("Nhập số phone mới: ");
				String newPhone = sc.next();
				vnamPhone.updateContact(name, newPhone);
				break;
			}
			case 4: {
				System.out.println("Nhập tên: ");
				String name = sc.next();
				vnamPhone.searchContact(name);
				break;
			}
			case 5: {
				vnamPhone.showContact();
				break;
			}
			case 6: {
				sc.close();
				return;
			}
			default:
				System.out.println("Hãy nhập đúng số menu");
				break;
			}
		}
	}
}
