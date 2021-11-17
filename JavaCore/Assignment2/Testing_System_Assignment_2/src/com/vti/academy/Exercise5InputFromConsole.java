package com.vti.academy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import com.vti.academy.enums.PositionName;

public class Exercise5InputFromConsole {
	static Random random = new Random();
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Scanner scanner = new Scanner(System.in);
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

		Account[] accArr = new Account[] { account1, account2, account3, account4 };
		Group[] grArr = new Group[] { group1, group2, group3 };

//		question1(scanner);

//		question2(scanner);

//		question3(scanner);

//		question4(scanner);

//		question5(scanner);

//		question6(scanner);

//		question7(scanner);

//		question8(scanner);

//		question9(accArr, grArr, scanner);

//		question10(accArr, grArr, scanner);

		question11(accArr, grArr, scanner);

		scanner.close();

	}

	/**
	 * Question 1: Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình
	 * 
	 */
	public static void question1(Scanner scanner) {
		System.out.println("Mời bạn nhập một số nguyên: ");
		int a = scanner.nextInt();
		System.out.println("Mời bạn nhập một số nguyên: ");
		int b = scanner.nextInt();
		System.out.println("Mời bạn nhập một số nguyên: ");
		int c = scanner.nextInt();
		System.out.println("Số vừa nhập là: " + a + ", " + b + ", " + c);
	}

	/**
	 * Question 2: Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình
	 * 
	 */
	public static void question2(Scanner scanner) {
		System.out.println("Mời bạn nhập một số thực: ");
		float a = scanner.nextFloat();
		System.out.println("Mời bạn nhập một số thực: ");
		float b = scanner.nextFloat();
		System.out.println("Số vừa nhập là: " + a + ", " + b);
	}

	/**
	 * Question 3: Viết lệnh cho phép người dùng nhập họ và tên
	 * 
	 */
	public static void question3(Scanner scanner) {
		System.out.println("Mời bạn nhập họ và tên: ");
		String hoten = scanner.nextLine();
		System.out.println("Họ và tên là: " + hoten);
	}

	/**
	 * Question 4: Viết lệnh cho phép người dùng nhập họ và tên
	 * 
	 * @throws ParseException
	 * 
	 */
	public static void question4(Scanner scanner) throws ParseException {
		System.out.println("Mời bạn nhập ngày sinh theo định dạng day-month-year: ");
		String dateInput = scanner.next();

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = dateFormat.parse(dateInput);
		System.out.println("ngày sinh là: " + date);
	}

	/**
	 * Question 5: Viết lệnh cho phép người dùng tạo account (viết thành method) Đối
	 * với property Position, Người dùng nhập vào 1 2 3 4 5 và vào chương trình sẽ
	 * chuyển thành Position.Dev, Position.Test, Position.ScrumMaster, Position.PM
	 * 
	 */
	public static void question5(Scanner scanner) {
		System.out.println("Tạo account");
		System.out.println("Mời bạn nhập email: ");
		String email = scanner.next();

		System.out.println("Mời bạn nhập username: ");
		String username = scanner.next();

		System.out.println("Mời bạn nhập fullname: ");
		String fullname = scanner.nextLine();

		System.out.println("Mời bạn nhập tên phòng ban: ");
		String departmentName = scanner.nextLine();

		System.out.println("Mời bạn nhập mã vị trí (số bất kì từ 1 đến 4): ");
		int positionId = scanner.nextInt();
		String positionName = "";
		switch (positionId) {
		case 1:
			positionName = PositionName.POSITION_DEV.getPositionName();
			break;
		case 2:
			positionName = PositionName.POSITION_TEST.getPositionName();
			break;
		case 3:
			positionName = PositionName.POSITION_SCRUM_MASTER.getPositionName();
			break;
		case 4:
			positionName = PositionName.POSITION_PM.getPositionName();
			break;
		default:
			positionName = "Phòng chờ";
			break;
		}
		System.out.println("Account của bạn đã được tạo ");
		System.out.println("email: " + email);
		System.out.println("username: " + username);
		System.out.println("fullname: " + fullname);
		System.out.println("departmentName: " + departmentName);
		System.out.println("positionName: " + positionName);
	}

	/**
	 * Question 6: Viết lệnh cho phép người dùng tạo department(viết thành method)
	 * 
	 */
	public static void question6(Scanner scanner) {
		System.out.println("Tạo department");
		System.out.println("Mời bạn nhập id: ");
		byte departmentId = scanner.nextByte();

		System.out.println("Mời bạn nhập tên phòng: ");
		String departmentName = scanner.nextLine();

		System.out.println("Phòng ban của bạn: ");
		System.out.println("departmentId: " + departmentId);
		System.out.println("departmentName: " + departmentName);
	}

	/**
	 * Question 7: Nhập số chẵn từ console
	 * 
	 */
	public static void question7(Scanner scanner) {
		System.out.println("Mời bạn nhập 1 số chẵn: ");
		int num = scanner.nextInt();

		if (num % 2 != 0) {
			System.out.println("số bạn vừa nhập không phải số chẵn");
		} else {
			System.out.println("số bạn vừa nhập là số chẵn");
		}
	}

	/**
	 * Question 8: Viết chương trình thực hiện theo flow sau: Bước 1: Chương trình
	 * in ra text "mời bạn nhập vào chức năng muốn sử dụng" Bước 2: Nếu người dùng
	 * nhập vào 1 thì sẽ thực hiện tạo account Nếu người dùng nhập vào 2 thì sẽ thực
	 * hiện chức năng tạo department Nếu người dùng nhập vào số khác thì in ra text
	 * "Mời bạn nhập lại" và quay trở lại bước 1
	 * 
	 */
	public static void question8(Scanner scanner) {
		boolean isOk = false;
		while (!isOk) {
			System.out.println("mời bạn nhập vào chức năng muốn sử dụng: ");
			int num = scanner.nextInt();

			if (num == 1) {
				question5(scanner);
				isOk = true;
			} else if (num == 2) {
				question6(scanner);
				isOk = true;
			} else {
				System.out.println("Mời bạn nhập lại: ");
				isOk = false;
			}
		}
	}

	/**
	 * Question 9: Viết method cho phép người dùng thêm group vào account theo flow
	 * sau: Bước 1: In ra tên các usernames của user cho người dùng xem Bước 2: Yêu
	 * cầu người dùng nhập vào username của account Bước 3: In ra tên các group cho
	 * người dùng xem Bước 4: Yêu cầu người dùng nhập vào tên của group Bước 5: Dựa
	 * vào username và tên của group người dùng vừa chọn, hãy thêm account vào group
	 * đó .
	 * 
	 */
	public static void question9(Account[] accArr, Group[] grArr, Scanner scanner) {
		for (Account acc : accArr) {
			System.out.println("Tên các username: " + acc.userName);
		}

		System.out.println("mời bạn nhập vào username của account: ");
		String userName = scanner.nextLine();

		for (Group gr : grArr) {
			System.out.println("Tên các group: " + gr.groupName);
		}
		System.out.println("mời bạn nhập vào tên của Group: ");
		String group = scanner.nextLine();

		Group groupAdd = null;
		for (Group gr : grArr) {
			if (group.equals(gr.groupName)) {
				groupAdd = gr;
			}
		}
		for (Account acc : accArr) {
			if (userName.equals(acc.userName)) {
				acc.groups = Arrays.copyOf(acc.groups, acc.groups.length + 1);
				acc.groups[acc.groups.length - 1] = groupAdd;
				System.out.println("account " + acc.userName + " đã thêm vào group " + groupAdd.groupName);
				System.out.println("kết quả: account " + acc.userName + "có mặt trong những group: ");
				for (Group gr : acc.groups) {
					System.out.println("\t" + gr.groupName);
				}

			}
		}
	}

	/**
	 * Question 10: Tiếp tục Question 8 và Question 9 Bổ sung thêm vào bước 2 của
	 * Question 8 như sau: Nếu người dùng nhập vào 3 thì sẽ thực hiện chức năng thêm
	 * group vào account Bổ sung thêm Bước 3 của Question 8 như sau: Sau khi người
	 * dùng thực hiện xong chức năng ở bước 2 thì in ra dòng text để hỏi người dùng
	 * "Bạn có muốn thực hiện chức năng khác không?". Nếu người dùng chọn "Có" thì
	 * quay lại bước 1, nếu người dùng chọn "Không" thì kết thúc chương trình (sử
	 * dụng lệnh return để kết thúc chương trình)
	 * 
	 */
	public static void question10(Account[] accArr, Group[] grArr, Scanner scanner) {

		boolean isOk = false;
		while (!isOk) {
			System.out.println("mời bạn nhập vào chức năng muốn sử dụng: ");
			int num = scanner.nextInt();
			if (num == 1) {
				question5(scanner);
				isOk = true;
			} else if (num == 2) {
				question6(scanner);
				isOk = true;
			} else if (num == 3) {
				question9(accArr, grArr, scanner);
				isOk = true;
			} else {
				System.out.println("Mời bạn nhập lại: ");
				isOk = false;
			}

			if (isOk) {
				System.out.println("Bạn có muốn thực hiện chức năng khác không? Có: nhập 1, Không: nhập 0");
				int yN = scanner.nextInt();
				if (yN == 1) {
					isOk = false;
				} else {
					System.out.println("Kết thúc!");
					return;
				}
			}
		}
	}

	/**
	 * Question 11: Tiếp tục Question 10 Bổ sung thêm vào bước 2 của Question 8 như
	 * sau: Nếu người dùng nhập vào 4 thì sẽ thực hiện chức năng thêm account vào 1
	 * nhóm ngẫu nhiên, chức năng sẽ được cài đặt như sau: Bước 1: In ra tên các
	 * usernames của user cho người dùng xem Bước 2: Yêu cầu người dùng nhập vào
	 * username của account Bước 3: Sau đó chương trình sẽ chọn ngẫu nhiên 1 group
	 * Bước 4: Thêm account vào group chương trình vừa chọn ngẫu nhiên
	 * 
	 */
	public static void question11(Account[] accArr, Group[] grArr, Scanner scanner) {

		boolean isOk = false;
		while (!isOk) {
			System.out.println("mời bạn nhập vào chức năng muốn sử dụng: ");
			int num = scanner.nextInt();
			if (num == 1) {
				question5(scanner);
				isOk = true;
			} else if (num == 2) {
				question6(scanner);
				isOk = true;
			} else if (num == 3) {
				question9(accArr, grArr, scanner);
				isOk = true;
			} else if (num == 4) {
				for (Account acc : accArr) {
					System.out.println("Tên các username: " + acc.userName);
				}

				System.out.println("mời bạn nhập vào username của account: ");
				String userName = scanner.next();	
				int i = random.nextInt(grArr.length);
				Group groupAdd = grArr[i];
				
				for (Account acc : accArr) {
					if (userName.equals(acc.userName)) {
						acc.groups = Arrays.copyOf(acc.groups, acc.groups.length + 1);
						acc.groups[acc.groups.length - 1] = groupAdd;
						System.out.println("account " + acc.userName + " đã thêm vào group " + groupAdd.groupName);
						System.out.println("kết quả: account " + acc.userName + "có mặt trong những group: ");
						for (Group gr : acc.groups) {
							System.out.println("\t" + gr.groupName);
						}

					}
				}

				isOk = true;
			}else {
				System.out.println("Mời bạn nhập lại: ");
				isOk = false;
			}

			if (isOk) {
				System.out.println("Bạn có muốn thực hiện chức năng khác không? Có: nhập 1, Không: nhập 0");
				int yN = scanner.nextInt();
				if (yN == 1) {
					isOk = false;
				} else {
					System.out.println("Kết thúc!");
					return;
				}
			}
		}
	}
}
