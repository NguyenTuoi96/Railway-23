package com.vti.academy;

import java.util.Date;

import com.vti.academy.enums.PositionName;

public class Exercise5ObjectsMethod {

	public static void main(String[] args) {
		// Tạo dữ liệu
		// tạo đối tượng Department
		Department department1 = new Department();
		department1.departmentId = 1;
		department1.departmentName = "Waiting room";

		Department department2 = new Department();
		department2.departmentId = 2;
		department2.departmentName = "Accounting";

		Department department3 = new Department();
		department3.departmentId = 3;
		department3.departmentName = "Marketing";

		Department department4 = new Department();
		department4.departmentId = 4;
		department4.departmentName = "Boss of director";

		Department department5 = new Department();
		department5.departmentId = 5;
		department5.departmentName = "Sale";

		Department[] departmentArr = new Department[] { department1, department2, department3, department4,
				department5 };

//		// Question 1
//		question1(department1);

//		// Question 2
//		question2(departmentArr);

//		// Question 3
//		question3(department1);

//		// Question 4
//		question4(department1);

//		// Question 5
//		question5(department1, department2);

//		// Question 6
//		question6(departmentArr);

		// Question 7
		question7(departmentArr);
	}

	/**
	 * Question 1: In ra thông tin của phòng ban thứ 1 (sử dụng toString())
	 */
	public static void question1(Department department) {
		System.out.println(department.toString());
	}

	/**
	 * Question 2: In ra thông tin của tất cả phòng ban (sử dụng toString())
	 */
	public static void question2(Department[] departmentArr) {
		for (Department department : departmentArr) {
			System.out.println(department.toString());
		}
	}

	/**
	 * Question 3: In ra địa chỉ của phòng ban thứ 1
	 */
	public static void question3(Department department) {
		System.out.println(department.hashCode());
	}

	/**
	 * Question 4: Kiểm tra xem phòng ban thứ 1 có tên là "Phòng A" không?
	 */
	public static void question4(Department department) {
		if (department.departmentName.equals("Phòng A")) {
			System.out.println("Phòng ban thứ 1 có tên là \"Phòng A\"");
		} else {
			System.out.println("Phòng ban thứ 1 không có tên là \"Phòng A\"");
		}
	}

	/**
	 * Question 5: So sánh 2 phòng ban thứ 1 và phòng ban thứ 2 xem có bằng nhau
	 * không (bằng nhau khi tên của 2 phòng ban đó bằng nhau)
	 */
	public static void question5(Department department1, Department department2) {
		if (department1.departmentName.equals(department2.departmentName)) {
			System.out.println("2 phòng ban bằng nhau");
		} else {
			System.out.println("2 phòng ban không bằng nhau");
		}
	}

	/**
	 * Question 6: Khởi tạo 1 array phòng ban gồm 5 phòng ban, sau đó in ra danh
	 * sách phòng ban theo thứ tự tăng dần theo tên (sắp xếp theo vần ABCD) VD:
	 * Accounting Boss of director Marketing Sale Waiting room
	 */
	public static void question6(Department[] departmentArr) {
		String str = "";
		for (int i = 0; i < departmentArr.length; i++) {
			for (int j = i + 1; j < departmentArr.length; j++) {
				if (departmentArr[i].departmentName != null && departmentArr[j].departmentName != null) {
					if (departmentArr[i].departmentName.compareToIgnoreCase(departmentArr[j].departmentName) > 0) {
						str = departmentArr[i].departmentName;
						departmentArr[i].departmentName = departmentArr[j].departmentName;
						departmentArr[j].departmentName = str;
					}
				} else if (departmentArr[i].departmentName == null && departmentArr[j].departmentName != null) {
					if ("0".compareToIgnoreCase(departmentArr[j].departmentName) > 0) {
						str = departmentArr[i].departmentName;
						departmentArr[i].departmentName = departmentArr[j].departmentName;
						departmentArr[j].departmentName = str;
					}
				} else if (departmentArr[j].departmentName == null && departmentArr[i].departmentName != null) {
					if (departmentArr[i].departmentName.compareToIgnoreCase("0") > 0) {
						str = departmentArr[i].departmentName;
						departmentArr[i].departmentName = departmentArr[j].departmentName;
						departmentArr[j].departmentName = str;
					}
				}
			}
		}
		for (int i = 0; i <= departmentArr.length - 1; i++) {
			System.out.print(departmentArr[i].departmentName + "\n");
		}
	}

	/**
	 * Question 7: Khởi tạo 1 array học sinh gồm 5 Phòng ban, sau đó in ra danh sách
	 * phòng ban được sắp xếp theo tên VD: Accounting Boss of director Marketing
	 * waiting room Sale
	 */
	public static void question7(Department[] departmentArr) {
		String str = "";
		for (int i = 0; i < departmentArr.length; i++) {
			for (int j = i + 1; j < departmentArr.length; j++) {
				if (departmentArr[i].departmentName != null && departmentArr[j].departmentName != null) {
					String[] strArrI = departmentArr[i].departmentName.split(" ");
					String[] strArrJ = departmentArr[j].departmentName.split(" ");
					if (strArrI[strArrI.length - 1].compareToIgnoreCase(strArrJ[strArrJ.length - 1]) > 0) {
						str = departmentArr[i].departmentName;
						departmentArr[i].departmentName = departmentArr[j].departmentName;
						departmentArr[j].departmentName = str;
					}
				} else if (departmentArr[i].departmentName == null && departmentArr[j].departmentName != null) {
					String[] strArrJ = departmentArr[j].departmentName.split(" ");
					if ("0".compareToIgnoreCase(strArrJ[strArrJ.length - 1]) > 0) {
						str = departmentArr[i].departmentName;
						departmentArr[i].departmentName = departmentArr[j].departmentName;
						departmentArr[j].departmentName = str;
					}
				} else if (departmentArr[j].departmentName == null && departmentArr[i].departmentName != null) {
					String[] strArrI = departmentArr[i].departmentName.split(" ");
					if (strArrI[strArrI.length - 1].compareToIgnoreCase("0") > 0) {
						str = departmentArr[i].departmentName;
						departmentArr[i].departmentName = departmentArr[j].departmentName;
						departmentArr[j].departmentName = str;
					}
				}
			}
		}
		for (int i = 0; i <= departmentArr.length - 1; i++) {
			System.out.print(departmentArr[i].departmentName + "\n");
		}
	}
}
