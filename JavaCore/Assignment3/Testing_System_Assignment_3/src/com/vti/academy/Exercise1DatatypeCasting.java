package com.vti.academy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import com.vti.academy.enums.PositionName;

public class Exercise1DatatypeCasting {
	static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	public static void main(String[] args) throws ParseException {
		
		// Tạo dữ liệu
		// tạo đối tượng Department
		Department department1 = new Department();
		department1.departmentId = 1;
		department1.departmentName = "Phòng giám đốc";

		// tạo đối tượng Position
		Position position1 = new Position();
		position1.positionId = 1;
		position1.positionName = PositionName.POSITION_DEV.getPositionName();

		// tạo đối tượng Group
		Group group1 = new Group();
		group1.groupId = 1;
		group1.groupName = "Group 1";
		group1.createDate = new Date();

		// tạo đối tượng Account
		Account account1 = new Account();
		account1.accountId = 1;
		account1.email = "nguyenanh@gmail.com";
		account1.userName = "NguyenAnh";
		account1.fullName = "Nguyễn Văn Anh";
		account1.department = department1;
		account1.position = position1;
		account1.createDate = dateFormat.parse("01-01-1996");
		account1.groups = new Group[] { group1};

		Account account2 = new Account();
		account2.accountId = 2;
		account2.email = "nguyenhoa@gmail.com";
		account2.userName = "HoaNguyen";
		account2.fullName = "Nguyễn Thị Hoa";
		account2.department = department1;
		account2.position = position1;
		account2.createDate = new Date();
		account2.groups = new Group[] { group1 };

		Account[] accArr = new Account[] { account1, account2 };

		// Question 1
		question1(accArr);
		System.out.println();

		// Question 2
		int question2Num = question2();
		System.out.println();

		// Question 3
		question3(question2Num);
		System.out.println();

		// Question 4
		question4();
		System.out.println();

	}

	/**
	 * Question 1: Khai báo 2 số lương có kiểu dữ liệu là float. Khởi tạo Lương của
	 * Account 1 là 5240.5 $ Khởi tạo Lương của Account 2 là 10970.055$ Khai báo 1
	 * số int để làm tròn Lương của Account 1 và in số int đó ra Khai báo 1 số int
	 * để làm tròn Lương của Account 2 và in số int đó ra
	 * 
	 * @param accountArr
	 */
	private static void question1(Account[] accountArr) {
		System.out.println("Question 1");
		accountArr[0].salary = 5240.5f;
		accountArr[1].salary = 10970.055f;

		int salari1 = (int) accountArr[0].salary;
		int salari2 = (int) accountArr[1].salary;

		System.out.println("Lương của Account 1: " + salari1);
		System.out.println("Lương của Account 2: " + salari2);
	}

	/**
	 * Question 2: Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ
	 * thêm có số 0 ở đầu cho đủ 5 chữ số)
	 * 
	 */
	private static int question2() {
		System.out.println("Question 2");
		Random rd = new Random();
		int x = rd.nextInt(99999);

		System.out.println("Số ngẫu nhiên có 5 chữ số: " + String.format("%05d", x));
		return x;
	}

	/**
	 * Question 3: Lấy 2 số cuối của số ở Question 2 và in ra. Gợi ý: Cách 1:
	 * convert số có 5 chữ số ra String, sau đó lấy 2 số cuối Cách 2: chia lấy dư số
	 * đó cho 100
	 * 
	 * @param number
	 */
	private static void question3(int number) {
		System.out.println("Question 3");
		String result = String.valueOf(number);

		System.out.println("Số ngẫu nhiên có 5 chữ số: " + result.substring(3, 5));
	}

	/**
	 * Question 4: Viết 1 method nhập vào 2 số nguyên a và b và trả về thương của chúng
	 * 
	 */
	private static void question4() {
		System.out.println("Question 4");
		Scanner sc = new Scanner(System.in);
		int a = 0;
		int b = 0;
		String msg = "bạn nhập sai định dạng, mời bạn làm lại từ đầu";

		System.out.println("mời bạn nhập vào 1 số bất kì: ");
		if (!sc.hasNextInt()) {
			System.out.print(msg);
		} else {
			a = sc.nextInt();
		}

		System.out.println("mời bạn nhập vào 1 số bất kì khác 0: ");
		if (!sc.hasNextInt()) {
			System.out.print(msg);
		} else {
			b = sc.nextInt();
			if (b == 0) {
				System.out.println(msg);
			}
		}

		if (b != 0) {
			float c = (float) a / b;
			System.out.println("thương của a và b là: " + c);
		}
		sc.close();
	}

}
