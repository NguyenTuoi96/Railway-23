package com.vti.academy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.vti.academy.enums.PositionName;

public class Exercise1FlowControl {
	static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	public static void main(String[] args) throws ParseException {
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
		account4.userName = "PhuongNguyen";
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

//		IF
//		Question 1:
		System.out.println("Question 1");
		question1(account2);
		System.out.println();

//		Question 2:
		System.out.println("Question 2");
		question2(account2);
		System.out.println();

//		Question 3:
		System.out.println("Question 3");
		question3(account2);
		System.out.println();

//		Question 4:
		System.out.println("Question 4");
		question4(account1);
		System.out.println();

//		SWITCH CASE
//		Question 5:
		System.out.println("Question 5");
		question5(group1);
		System.out.println();

//		Question 6:
		System.out.println("Question 6");
		question6(account2);
		System.out.println();

//		Question 7:
		System.out.println("Question 7");
		question7(account1);
		System.out.println();

//		FOREACH
//		Question 8
		Account[] accArr = new Account[] { account1, account2, account3, account4 };
		System.out.println("Question 8");
		question8(accArr);
		System.out.println();

//		Question 9
		Department[] departmentArr = new Department[] { department1, department2, department3 };
		System.out.println("Question 9");
		question9(departmentArr);
		System.out.println();

//		FOR
//		Question 10
		System.out.println("Question 10");
		question10(accArr);

//		Question 11
		System.out.println("Question 11");
		question11(departmentArr);

//		Question 12
		System.out.println("Question 12");
		question12(departmentArr);

//		Question 13
		System.out.println("Question 13");
		question13(accArr);

//		Question 14
		System.out.println("Question 14");
		question14(accArr);

//		Question 15
		System.out.println("Question 15");
		question15();
	}

	/**
	 * Question 1 
	 * Kiểm tra account thứ 2 
	 * Nếu không có phòng ban (tức là department == null) thì sẽ in ra text "Nhân viên này chưa có phòng ban" 
	 * Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là ..."
	 * 
	 * @param account account thứ 2
	 */
	public static void question1(Account account) {
		if (account.department == null) {
			System.out.println("Nhân viên chưa có phòng ban");
		} else {
			System.out.println("phòng ban của nhân viên này là: " + account.department.departmentName);
		}
	}

	/**
	 * Quesstion 2 
	 * Kiểm tra account thứ 2 
	 * Nếu không có group thì sẽ in ra text "Nhânviên này chưa có group" 
	 * Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên này là Java Fresher, C# Fresher" 
	 * Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người quan trọng, tham gia nhiều group" 
	 * Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là người hóng chuyện, tham gia tất cả các group"
	 * 
	 * @param account account thứ 2
	 */
	public static void question2(Account account) {
		int cntGroups = account.groups == null ? 0 : account.groups.length; // đếm số nhóm mà nhân viên tham gia
		if (cntGroups == 0) {
			System.out.println("Nhân viên này chưa có group");
		} else if (cntGroups == 1 || cntGroups == 2) {
			System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
		} else if (cntGroups == 3) {
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
		} else {
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
		}
	}

	/**
	 * Question 3 Sử dụng toán tử ternary để làm Question 1
	 * 
	 * @param account account thứ 2
	 */
	public static void question3(Account account) {
		System.out.println(account.department == null ? "Nhân viên chưa có phòng ban"
				: "phòng ban của nhân viên này là: " + account.department.departmentName);
	}

	/**
	 * Question 4 
	 * Sử dụng toán tử ternary để làm yêu cầu sau: 
	 * Kiểm tra Position của account thứ 1 Nếu Position = Dev thì in ra text "Đây là Developer" 
	 * Nếu không phải thì in ra text "Người này không phải là Developer"
	 * 
	 * @param account account thứ nhất
	 */
	public static void question4(Account account) {
		System.out.println(
				account.position.positionName == "Dev" ? "Đây là Developer" : "Người này không phải là Developer");
	}

	/**
	 * Question 5 
	 * Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau:
	 * Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên" 
	 * Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên" 
	 * Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên" 
	 * Còn lại in ra "Nhóm có nhiều thành viên"
	 * 
	 * @param group Group thứ nhất
	 */
	public static void question5(Group group) {
		if (group.accounts != null) {
			int cntAccInGr1 = group.accounts.length;
			switch (cntAccInGr1) {
			case 1:
				System.out.println("Nhóm có một thành viên");
				break;
			case 2:
				System.out.println("Nhóm có hai thành viên");
				break;
			case 3:
				System.out.println("Nhóm có ba thành viên");
				break;
			default:
				System.out.println("Nhóm có nhiều thành viên");
				break;
			}
		} else {
			System.out.println("Nhóm không có thành viên");
		}
	}

	/**
	 * Quesstion 6 Sử dụng switch case để làm lại Question 2
	 * 
	 * @param account account thứ 2
	 */
	public static void question6(Account account) {
		int cntGroups = account.groups == null ? 0 : account.groups.length; // đếm số nhóm mà nhân viên tham gia
		switch (cntGroups) {
		case 0:
			System.out.println("Nhân viên này chưa có group");
			break;
		case 1:
			System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
			break;
		case 2:
			System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
			break;
		case 3:
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
			break;
		default:
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
			break;
		}
	}

	/**
	 * Quesstion 7 Sử dụng switch case để làm lại Question 4
	 * 
	 * @param account account thứ nhất
	 */
	public static void question7(Account account) {
		String positionName = account.position.positionName;
		switch (positionName) {
		case "Dev":
			System.out.println("Đây là Developer");
			break;
		default:
			System.out.println("Người này không phải là Developer");
			break;
		}
	}

	/**
	 * Quesstion 8 In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ
	 * 
	 * @param accountArr các account
	 */
	public static void question8(Account[] accountArr) {
		System.out.println("Thông tin account: ");
		for (Account account : accountArr) {
			System.out.println("email: " + account.email + ", fullName: " + account.fullName + ", Tên phòng ban: "
					+ account.department.departmentName);
		}
	}

	/**
	 * Quesstion 9 In ra thông tin các phòng ban bao gồm: id và name
	 * 
	 * @param departmentArr các phòng ban
	 */
	public static void question9(Department[] departmentArr) {
		System.out.println("Thông tin phòng ban: ");
		for (Department department : departmentArr) {
			System.out.println("id: " + department.departmentId + ", department Name: " + department.departmentName);
		}
	}

	/**
	 * Quesstion 10 
	 * In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ theo định dạng như sau: 
	 * Thông tin account thứ 1 là: 
	 * Email: NguyenVanA@gmail.com 
	 * Full name: Nguyễn Văn A 
	 * Phòng ban: Sale 
	 * 
	 * Thông tin account thứ 2 là: 
	 * Email: NguyenVanB@gmail.com 
	 * Full name: Nguyễn Văn B 
	 * Phòng ban: Marketting
	 * 
	 * @param accArr các account
	 */
	public static void question10(Account[] accArr) {
		for (int i = 0; i < accArr.length; i++) {
			System.out.println("\tThông tin account thứ " + (i + 1) + " là:" + "\n\tEmail: " + accArr[i].email
					+ "\n\tFull name: " + accArr[i].fullName + "\n\tPhòng ban: " + accArr[i].department.departmentName + "\n");
		}
	}

	/**
	 * Quesstion 11 
	 * In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
	 * 		Thông tin department thứ 1 là:
	 * 			Id: 1
	 * 			Name: Sale
	 * 		Thông tin department thứ 2 là:
	 * 			Id: 2
	 * 			Name: Marketing
	 * 
	 * @param departmentArr các phòng ban
	 */
	public static void question11(Department[] departmentArr) {
		for (int i = 0; i < departmentArr.length; i++) {
			System.out.println("\tThông tin department thứ " + (i + 1) + " là:" + "\n\t\tId: " + departmentArr[i].departmentId
					+ "\n\t\tName: " + departmentArr[i].departmentName + "\n");
		}
	}

	/**
	 * Quesstion 12 
	 * Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
	 * 
	 * @param departmentArr các phòng ban
	 */
	public static void question12(Department[] departmentArr) {
		for (int i = 0; i < 2; i++) {
			System.out.println("\tThông tin department thứ " + (i + 1) + " là:" + "\n\tId: " + departmentArr[i].departmentId
					+ "\n\tName: " + departmentArr[i].departmentName + "\n");
		}
	}

	/**
	 * Quesstion 13 
	 * In ra thông tin tất cả các account ngoại trừ account thứ 2
	 * 
	 * @param accArr các account
	 */
	public static void question13(Account[] accArr) {
		System.out.println("Thông tin account ngoại trừ account thứ 2: ");
		// khởi tạo giá trị in
		String printValue = "";
		for (int i = 0; i < accArr.length; i++) {
			// account thứ 2 thì không in (i = 1 -> account thứ 2)
			if(i == 1) {
				continue;
			}
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
	 * Quesstion 14
	 * In ra thông tin tất cả các account có id < 4
	 * 
	 * @param accArr các account
	 */
	public static void question14(Account[] accArr) {
		System.out.println("Thông tin tất cả các account có id < 4 là : ");
		// khởi tạo giá trị in
		String printValue = "";
		for (int i = 0; i < accArr.length; i++) {
			// account thứ 2 thì không in (i = 1 -> account thứ 2)
			if(accArr[i].accountId >= 4) {
				continue;
			}
			// In các thông tin của account
			printValue ="accountId: " + accArr[i].accountId
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
	 * Quesstion 15
	 * In ra các số chẵn nhỏ hơn hoặc bằng 20
	 * 
	 */
	public static void question15() {
		for(int i = 0; i <= 20; i+=2) {
			System.out.println("Số chẵn (dương) nhỏ hơn hoặc bằng 20 là: " + i);
		}
		// cách khác
//		for(int i = 0; i <= 20; i++) {
//			if(i % 2 == 0) {
//				System.out.println("Số chẵn (dương) nhỏ hơn hoặc bằng 20 là: " + i);
//			}
//		}
	}
}
