package com.vti.academy;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.vti.academy.enums.PositionName;

public class Exercise3DateFormat {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
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

		// tạo đối tượng Account
		Account account1 = new Account();
		account1.accountId = 1;
		account1.email = "nguyenanh@gmail.com";
		account1.userName = "NguyenAnh";
		account1.fullName = "Nguyễn Văn Anh";
		account1.department = department1;
		account1.position = position1;
		account1.createDate = new Date();

		Account account2 = new Account();
		account2.accountId = 2;
		account2.email = "nguyenhoa@gmail.com";
		account2.userName = "HoaNguyen";
		account2.fullName = "Nguyễn Thị Hoa";
		account2.department = department2;
		account2.position = position2;
		account2.createDate = new Date();

		Account account3 = new Account();
		account3.accountId = 3;
		account3.email = "nguyenphuong@gmail.com";
		account3.userName = "PhuongNguyen";
		account3.fullName = "Nguyễn Thảo Phương";
		account3.department = department3;
		account3.position = position3;
		account3.createDate = new Date();

		// tạo đối tượng CategoryQuestion
		CategoryQuestion categoryQuestion1 = new CategoryQuestion();
		categoryQuestion1.categoryId = 1;
		categoryQuestion1.categoryName = "Java";

		CategoryQuestion categoryQuestion2 = new CategoryQuestion();
		categoryQuestion2.categoryId = 2;
		categoryQuestion2.categoryName = ".Net";

		CategoryQuestion categoryQuestion3 = new CategoryQuestion();
		categoryQuestion3.categoryId = 3;
		categoryQuestion3.categoryName = "SQL";

		// tạo đối tượng Exam
		Exam exam1 = new Exam();
		exam1.examId = 1;
		exam1.code = "Mã 1";
		exam1.title = "tiêu đề 1";
		exam1.category = categoryQuestion1;
		exam1.duration = 15;
		exam1.creator = account1;
		exam1.createDate = dateFormat.parse("01-11-2020");

		Exam exam2 = new Exam();
		exam2.examId = 2;
		exam2.code = "Mã 2";
		exam2.title = "tiêu đề 2";
		exam2.category = categoryQuestion2;
		exam2.duration = 45;
		exam2.creator = account2;
		exam2.createDate = dateFormat.parse("11-12-2019");

		Exam exam3 = new Exam();
		exam3.examId = 3;
		exam3.code = "Mã 3";
		exam3.title = "tiêu đề 3";
		exam3.category = categoryQuestion3;
		exam3.duration = 180;
		exam3.creator = account2;
		exam3.createDate = dateFormat.parse("01-01-2020");

		Exam[] examArr = new Exam[] { exam1, exam2, exam3 };

		// question1
		question1(examArr);

		// question2
		Date[] dateArrQuestion2 = question2(examArr);

		// question3
		question3(dateArrQuestion2);

		// question4
		question4(dateArrQuestion2);

		// question5
		question5(dateArrQuestion2);

	}

	/**
	 * Question 1: In ra thông tin Exam thứ 1 và property create date sẽ được format
	 * theo định dạng vietnamese
	 */
	public static void question1(Exam[] examArr) {
		System.out.println("Question 1:");
		Locale locate = new Locale("vi", "VN");
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locate);
		String date = dateFormat.format(examArr[0].createDate);
		System.out.println("thông tin Exam thứ 1");
		System.out.println("Exam Id: " + examArr[0].examId + ", Code: " + examArr[0].code + ", Title: "
				+ examArr[0].title + ", Category: " + examArr[0].category.categoryName + ", Duration: "
				+ examArr[0].duration + ", Creator: " + examArr[0].creator.fullName + ", Create date: " + date);
	}

	/**
	 * Question 2: In ra thông tin: Exam đã tạo ngày nào theo định dạng Năm – tháng
	 * – ngày – giờ – phút – giây
	 */
	public static Date[] question2(Exam[] examArr) {
		System.out.println("Question 2:");
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
		SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
		SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
		SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
		SimpleDateFormat minuteFormat = new SimpleDateFormat("mm");
		SimpleDateFormat secondFormat = new SimpleDateFormat("ss");
		Date[] dateArr = new Date[examArr.length];
		for (int i = 0; i < examArr.length; i++) {
			System.out.printf("Exam %s đã tạo vào ngày %s – %s – %s – %s – %s – %s%n", examArr[i].code,
					yearFormat.format(examArr[i].createDate), monthFormat.format(examArr[i].createDate),
					dayFormat.format(examArr[i].createDate), hourFormat.format(examArr[i].createDate),
					minuteFormat.format(examArr[i].createDate), secondFormat.format(examArr[i].createDate));
			dateArr[i] = examArr[i].createDate;
		}
		return dateArr;
	}

	/**
	 * Question 3: Chỉ in ra năm của create date property trong Question 2
	 */
	public static void question3(Date[] dateArr) {
		System.out.println("Question 3:");
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
		for (Date date : dateArr) {
			System.out.printf("năm của create date property trong Question 2: %s%n", yearFormat.format(date));
		}
	}

	/**
	 * Question 4: Chỉ in ra tháng và năm của create date property trong Question 2
	 */
	public static void question4(Date[] dateArr) {
		System.out.println("Question 4:");
		SimpleDateFormat yearMonthFormat = new SimpleDateFormat("yyyy/MM");
		for (Date date : dateArr) {
			System.out.printf("tháng năm của create date property trong Question 2: %s%n", yearMonthFormat.format(date));
		}
	}

	/**
	 * Question 5: Chỉ in ra "MM-DD" của create date trong Question 2
	 */
	public static void question5(Date[] dateArr) {
		System.out.println("Question 5:");
		SimpleDateFormat monthDayFormat = new SimpleDateFormat("MM/dd");
		for (Date date : dateArr) {
			System.out.printf("'MM-DD' của create date trong Question 2: %s%n", monthDayFormat.format(date));
		}
	}

}
