package com.vti.academy;

import java.util.Date;
import java.util.Scanner;

public class Exercise4String {

	public static void main(String[] args) {

		// tạo đối tượng Group
		Group group1 = new Group();
		group1.groupId = 1;
		group1.groupName = "Group Java";
		group1.createDate = new Date();

		Group group2 = new Group();
		group2.groupId = 2;
		group2.groupName = "Group 2";
		group2.createDate = new Date();

		Group group3 = new Group();
		group3.groupId = 3;
		group3.groupName = "Java";
		group3.createDate = new Date();
		
		Group[] groupArr = new Group[] {group1, group2, group3};

//		// Question 1
//		question1();
//		System.out.println();
//
//		// Question 2
//		question2();
//		System.out.println();

//		// Question 3
//		question3();
//		System.out.println();

//		// Question 4
//		question4();
//		System.out.println();

//		// Question 5
//		question5();
//		System.out.println();

//		// Question 6
//		question6();
//		System.out.println();

		// Question 7
//		question7();
//		System.out.println();

//		// Question 8
//		question8(groupArr);
//		System.out.println();

		// Question 9
		question9(groupArr);
		System.out.println();

	}

	/**
	 * Question 1: Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các
	 * từ có thể cách nhau bằng nhiều khoảng trắng );
	 */
	private static void question1() {
		System.out.println("Question 1");
		String str = "    Nhập     một xâu kí tự, đếm số lượng     các từ trong xâu kí tự đó     ";

		str = str.trim();
		int cntVar = 0;
		for (int i = 0; i < str.length() - 1; i++) {
			String chkStr = String.valueOf(str.charAt(i + 1));
			String chkStrBefore = String.valueOf(str.charAt(i));
			if (chkStr.equals(" ") && !chkStrBefore.equals(" ")) {
				cntVar++;
			}
		}
		cntVar = str.length() > 0 ? cntVar + 1 : 0;
		System.out.println(cntVar);
	}

	/**
	 * Question 2: Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;
	 */
	private static void question2() {
		System.out.println("Question 2");
		String str1 = "Java";
		String str2 = "Core";
		String str = str1.concat(str2);

		System.out.println(str);
	}

	/**
	 * Question 3: Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên
	 * chư viết hoa chữ cái đầu thì viết hoa lên
	 */
	private static void question3() {
		System.out.println("Question 3");
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào tên bạn: ");
		String name = sc.next();

		String nameCharAt0 = String.valueOf(name.charAt(0));
		String result = null;
		if (nameCharAt0.equals(nameCharAt0.toLowerCase())) {
			result = nameCharAt0.toUpperCase() + name.substring(1, name.length());
		} else {
			result = name;
		}
		sc.close();
		System.out.println("Tên của bạn: " + result);
	}

	/**
	 * Question 4: Viết chương trình để người dùng nhập vào tên in từng ký tự trong
	 * tên của người dùng ra VD: Người dùng nhập vào "Nam", hệ thống sẽ in ra "Ký tự
	 * thứ 1 là: N" "Ký tự thứ 1 là: A" "Ký tự thứ 1 là: M"
	 */
	private static void question4() {
		System.out.println("Question 4");
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào tên bạn: ");
		String name = sc.next();
		String[] nameCharArr = name.split("");
		for (int i = 0; i < nameCharArr.length; i++) {
			System.out.println("Kí tự thứ" + i + " là: " + nameCharArr[i].toUpperCase());
		}
		sc.close();

	}

	/**
	 * Question 5: Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người
	 * dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ
	 */
	private static void question5() {
		System.out.println("Question 5");
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào họ của bạn: ");
		String ho = sc.next();
		System.out.println("Mời bạn nhập vào tên của bạn: ");
		String ten = sc.next();
		String hoten = ho.concat(" ").concat(ten);
		System.out.println("họ và tên của bạn là: " + hoten);
		sc.close();

	}

	/**
	 * Question 6: Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
	 * sau đó hệ thống sẽ tách ra họ, tên , tên đệm VD: Người dùng nhập vào "Nguyễn
	 * Văn Nam" Hệ thống sẽ in ra "Họ là: Nguyễn" "Tên đệm là: Văn" "Tên là: Nam"
	 */
	private static void question6() {
		System.out.println("Question 6");
		Scanner nextsc = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào họ của bạn: ");
		String ho = nextsc.next();

		Scanner nextLinesc = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào tên đầy đủ của bạn(tên đệm và tên): ");
		String ten = nextLinesc.nextLine();

		String hoten = ho.concat(" ").concat(ten);
		String[] hotenArr = hoten.split(" ");

		String resultHo = "";
		String resultTenDem = "";
		String resultTen = "";

		for (int i = 0; i < hotenArr.length; i++) {
			if (i == 0) {
				resultHo = hotenArr[i];
			} else if (i == (hotenArr.length - 1)) {
				resultTen = hotenArr[i];
			} else {
				resultTenDem += hotenArr[i] + " ";
			}
		}

		System.out.println("Họ là: " + resultHo);
		System.out.println("Tên đệm là: " + resultTenDem);
		System.out.println("Tên là: " + resultTen);

		nextsc.close();
		nextLinesc.close();
	}

	/**
	 * Question 7: Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
	 * chuẩn hóa họ và tên của họ như sau: a) Xóa dấu cách ở đầu và cuối và giữa của
	 * chuỗi người dùng nhập vào VD: Nếu người dùng nhập vào " nguyễn văn nam " thì
	 * sẽ chuẩn hóa thành "nguyễn văn nam" b) Viết hoa chữ cái mỗi từ của người dùng
	 * VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ chuẩn hóa thành "Nguyễn
	 * Văn Nam"
	 */
	private static void question7() {
		System.out.println("Question 7");
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào họ và tên của bạn: ");
		String hovaten = sc.nextLine();

		hovaten = hovaten.trim();
		String[] hotenArr = hovaten.split(" ");

		String result = "";
		for (String hoten : hotenArr) {
			result += String.valueOf(hoten.charAt(0)).toUpperCase().concat(hoten.substring(1, hoten.length()))
					.concat(" ");
		}

		System.out.printf("Họ và tên là: '%s' %n", result.trim());
		sc.close();
	}

	/**
	 * Question 8: In ra tất cả các group có chứa chữ "Java"
	 */
	private static void question8(Group[] groupArr) {
		System.out.println("Question 8");
		for(Group group : groupArr) {
			if(group.groupName.matches("(.*)Java(.*)")) {
				System.out.println("group có chứa chữ \"Java\": " + group.groupName);
			}
		}
	}

	/**
	 * Question 9: In ra tất cả các group "Java"
	 */
	private static void question9(Group[] groupArr) {
		System.out.println("Question 9");
		for(Group group : groupArr) {
			if(group.groupName.matches("Java")) {
				System.out.println("group \"Java\": " + group.groupName);
			}
		}
	}

}
