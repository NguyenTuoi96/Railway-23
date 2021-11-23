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

		Group[] groupArr = new Group[] { group1, group2, group3 };

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

//		// Question 9
//		question9(groupArr);
//		System.out.println();

//		// Question 10
//		question10("word", "drow");
//		System.out.println();

//		// Question 11
//		question11("kiểm tra số lần xuất hiện kí tự a");
//		System.out.println();

//		// Question 12
//		question12("kiểm tra");
//		System.out.println();

//		// Question 13
//		question13("kiểm tra");
//		System.out.println();

//		// Question 14
//		question14("VTI Academy e", "e", "*");
//		System.out.println();

//		// Question 15
//		question15("    I am developer     ");
//		System.out.println();

//		// Question 16
//		question16("Cho một chuỗi str và số nguyên n ", 4);
//		System.out.println();

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
		for (Group group : groupArr) {
			if (group.groupName.matches("(.*)Java(.*)")) {
				System.out.println("group có chứa chữ \"Java\": " + group.groupName);
			}
		}
	}

	/**
	 * Question 9: In ra tất cả các group "Java"
	 */
	private static void question9(Group[] groupArr) {
		System.out.println("Question 9");
		for (Group group : groupArr) {
			if (group.groupName.matches("Java")) {
				System.out.println("group \"Java\": " + group.groupName);
			}
		}
	}

	/**
	 * Question 10 (Optional): Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không.
	 * Nếu có xuất ra “OK” ngược lại “KO”. Ví dụ “word” và “drow” là 2 chuỗi đảo
	 * ngược nhau.
	 */
	private static void question10(String str1, String str2) {
		System.out.println("Question 10");
		StringBuilder stringBuild = new StringBuilder(str1);
		String strCompare = stringBuild.reverse().toString();

		if (str2.equals(strCompare)) {
			System.out.println("OK");
		} else {
			System.out.println("KO");
		}
	}

	/**
	 * Question 11 (Optional): Count special Character Tìm số lần xuất hiện ký tự
	 * "a" trong chuỗi
	 * 
	 * @param strInput Chuỗi nhập vào
	 */
	private static void question11(String strInput) {
		System.out.println("Question 11");
		String[] strArr = strInput.split("");
		int cntChar = 0;
		for (String str : strArr) {
			if (str.equals("a")) {
				cntChar++;
			}
		}
		System.out.println("số lần xuất hiện của kí tự \"a\" trong chuỗi là: " + cntChar);
	}

	/**
	 * Question 12 (Optional): Reverse String Đảo ngược chuỗi sử dụng vòng lặp
	 */
	private static void question12(String strInput) {
		System.out.println("Question 12");
		String[] strArr = strInput.split("");
		String strResult = "";
		for (int i = strArr.length - 1; i >= 0; i--) {
			strResult += strArr[i];
		}
		System.out.printf("Chuỗi gốc và chuỗi đảo ngược là: '%s' và '%s'%n", strInput, strResult);
	}

	/**
	 * Question 13 (Optional): String not contains digit Kiểm tra một chuỗi có chứa
	 * chữ số hay không, nếu có in ra false ngược lại true.
	 */
	private static void question13(String strInput) {
		if(strInput == null) {
			System.out.println(false);
			return;
		}
		System.out.println("Question 13");
		String[] strArr = strInput.split("");
		boolean result = true;
		for (String str : strArr) {
			if (str.matches(".*\\d.*")) {
				result = false;
				break;
			}
		}
		System.out.println(result);
	}

	/**
	 * Question 14 (Optional): Replace character Cho một chuỗi str, chuyển các ký tự
	 * được chỉ định sang một ký tự khác cho trước. Ví dụ: "VTI Academy" chuyển ký
	 * tự 'e' sang '*' kết quả " VTI Acad*my"
	 */
	private static void question14(String strInput, String strDesignate, String strReplace) {
		System.out.println("Question 14");
		String result = strInput.replace(strDesignate, strReplace);
		System.out.println(result);
	}

	/**
	 * Question 15 (Optional): Revert string by word Đảo ngược các ký tự của chuỗi
	 * cách nhau bởi dấu cách mà không dùng thư viện. Ví dụ: " I am developer " =>
	 * "developer am I". Các ký tự bên trong chỉ cách nhau đúng một dấu khoảng cách.
	 * Gợi ý: Các bạn cần loại bỏ dấu cách ở đầu và cuối câu, thao tác cắt chuỗi
	 * theo dấu cách
	 */
	private static void question15(String strInput) {
		System.out.println("Question 15");
		String[] strArr = strInput.trim().split(" ");
		String strResult = "";
		for (int i = strArr.length - 1; i >= 0; i--) {
			strResult += strArr[i] + " ";
		}
		System.out.printf("Chuỗi gốc và chuỗi đảo ngược là: '%s' và '%s'%n", strInput, strResult.trim());
	}

	/**
	 * Question 16 (Optional):Cho một chuỗi str và số nguyên n >= 0. Chia chuỗi str
	 * ra làm các phần bằng nhau với n ký tự. Nếu chuỗi không chia được thì xuất ra
	 * màn hình “KO”.
	 */
	private static void question16(String strInput, int n) {
		System.out.println("Question 16");
		String[] strArr = strInput.split("");
		if (strArr.length % n != 0) {
			System.out.printf("KO");
		} else {
			String strResult = "Chuỗi sau khi tách là: '";
			for (int i = 0; i < strArr.length; i++) {
				strResult += strArr[i];
				if ((i + 1) % n == 0 && i > 0) {
					strResult += "', '";
				}
			}
			System.out.println("Chuỗi sau khi tách: " + strResult.substring(0, strResult.length() - 3));
		}
	}

}
