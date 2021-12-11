package com.vti.backend;

import java.text.NumberFormat;
import java.util.Locale;

import org.apache.commons.lang3.ArrayUtils;

import com.vti.entity.HinhChuNhat;
import com.vti.entity.HinhHoc;
import com.vti.entity.HinhHocException;
import com.vti.entity.HinhTron;
import com.vti.entity.MyMath;
import com.vti.entity.PrimaryStudent;
import com.vti.entity.SecondaryStudent;
import com.vti.entity.Student;

public class Exercise1 {
	private Student[] studentArr;

	public Exercise1() {
	}

//	Question 1: static variable
//	Khai báo 1 class student có các thuộc tính id, name, college
//	Với college là static variable.
//	Hãy khởi tạo các student sau:
//	Student có id = 1, name ="Nguyễn Văn A"
//	Student có id = 2, name = " Nguyễn Văn B "
//	Student có id = 3, name = " Nguyễn Văn C "
//	Và tất cả các student này đều học ở "Đại học bách khoa".
//	Dùng vòng for để in ra thông tin các student
//	Sau đó hãy chuyển các student này sang "Đại học công nghệ"
//	Dùng vòng for để in ra thông tin các student
	public void Question1() {
		Student st1 = new Student(1, "Nguyễn Văn A");
		Student st2 = new Student(1, "Nguyễn Văn B");
		Student st3 = new Student(1, "Nguyễn Văn C");
		studentArr = new Student[] { st1, st2, st3 };

		for (Student item : studentArr) {
			System.out.println(item);
		}

		// Đổi tên trường
		Student.thayDoiCollege();
		System.out.println();
		for (Student item : studentArr) {
			System.out.println(item);
		}

	}

//	Question 2: tiếp tục question 1
//	Bổ sung thuộc tính moneyGroup cho Student (moneyGroup là tiền quỹ lớp - dùng chung cho tất cả các student).
//	Hãy viết chương trình main() để mô tả các bước sau:
//	B1: Các Student sẽ nộp quỹ, mỗi Student 100k
//	B2: Student thứ 1 lấy 50k đi mua bim bim, kẹo về liên hoan
//	B3: Student thứ 2 lấy 20k đi mua bánh mì
//	B4: Student thứ 3 lấy 150k đi mua đồ dùng học tập cho nhóm
//	B5: cả nhóm mỗi người lại đóng quỹ mỗi người 50k
//	In ra số tiền còn của nhóm tại mỗi bước

	public void Question2() {
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
		// nộp quỹ mỗi người 100k
		for (Student item : studentArr) {
			Student.moneyGroup += 100000;
		}

		System.out.println("số tiền còn của nhóm sau khi đóng quỹ: " + numberFormat.format(Student.moneyGroup));
		// lấy 50k đi mua bim bim, kẹo về liên hoan
		Student.moneyGroup -= 50000;
		System.out.println("số tiền còn của nhóm sau khi mua bim bim, kẹo về liên hoan: "
				+ numberFormat.format(Student.moneyGroup));

		// lấy 20k đi mua bánh mì
		Student.moneyGroup -= 20000;
		System.out.println("số tiền còn của nhóm sau khi mua bánh mì: " + numberFormat.format(Student.moneyGroup));

		// lấy 150k đi mua đồ dùng học tập cho nhóm
		Student.moneyGroup -= 150000;
		System.out.println("số tiền còn của nhóm sau khi mua đồ dùng học tập cho nhóm: "
				+ numberFormat.format(Student.moneyGroup));

		// cả nhóm mỗi người lại đóng quỹ mỗi người 50k
		for (Student item : studentArr) {
			Student.moneyGroup += 50000;
		}
		System.out.println("số tiền còn của nhóm sau khi cả nhóm mỗi người lại đóng quỹ mỗi người 50k: "
				+ numberFormat.format(Student.moneyGroup));
	}

//	Question 3: static method
//	a) Viết class MyMath để thay thế cho class Math của java.
//	b) Viết thêm method min(), sum vào class MyMath
	public void Question3() {
		int rsMax = Math.max(5, 7);
		int rsMin = MyMath.min(5, 7);
		int rsSum = MyMath.sum(5, 7);
		System.out.println("rsMax = " + rsMax);
		System.out.println("rsMin = " + rsMin);
		System.out.println("rsSum = " + rsSum);
	}

//	Question 4: tiếp tục Question 1
//	Trong class Student
//	a) Viết method cho phép thay đổi college
//	b) Viết method cho phép lấy giá trị của college
	public void Question4() {
		// Lấy giá trị college
		System.out.println(Student.getCollege());
		// Thay đổi college
		Student.setCollege("Cao đẳng an ninh");
		// Lấy giá trị college
		System.out.println(Student.getCollege());
	}

//	Question 5:
//	Hãy viết chương trình đếm số Student được sinh ra (tham khảo code trên google)
	public void Question5() {
		for (int i = 0; i < 10; i++) {
			Student student = new Student(i, "Nguyễn Văn " + i);
			studentArr = ArrayUtils.add(studentArr, student);
		}
		System.out.println("số Student được sinh ra = " + Student.countStudent);
	}

//	Question 6: tiếp tục Question 5
//	Tạo class PrimaryStudent, SecondaryStudent, hãy viết chương trình đếm số lượng PrimaryStudent được sinh ra, SecondaryStudent được sinh ra.
//	Viết chương trình demo.
//	Khởi tạo 6 Student, trong đó có 2 PrimaryStudent và 4 SecondaryStudent, sau đó in ra số lượng Student, PrimaryStudent, SecondaryStudent được sinh ra.
	public void Question6() {
		for (int i = 0; i < 6; i++) {
			if (i < 2) {
				new PrimaryStudent(i, "Nguyễn Văn " + i);
			} else {
				new SecondaryStudent(i, "Nguyễn Văn " + i);
			}
		}
		System.out.println("số Student được sinh ra = " + Student.countStudent);
		System.out.println("số PrimaryStudent được sinh ra = " + PrimaryStudent.countPrimaryStudent);
		System.out.println("số SecondaryStudent được sinh ra = " + SecondaryStudent.countSecondaryStudent);
	}

//	Question 7: tiếp tục Question 6
//	Chỉ cho phép user tạo được tối đa 7 học sinh
	public void Question7() {
		try {
			for (int i = 0; i <= 6; i++) {
				Student student = new Student(i, "Nguyễn Văn " + i);
				System.out.println(student);
			}
		} catch (OutOfMemoryError e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("số Student được sinh ra = " + Student.countStudent);
		}
	}

//	Question 8:
//		Tạo class Configs có các static property
//		SO_LUONG_HINH_TOI_DA = 5;
//		Tạo class HinhHoc, và class HinhTron, HinhChuNhat sẽ kế thừa từ class HinhHoc, implement method tính chu vi, diện tính
//		Viết chương trình chỉ cho phép khởi tạo được tối đa 5 hình, 
//		nếu người dùng khởi tạo tới hình thứ 6 thì sẽ throw ra 1 custom Exception có tên là HinhHocException có message là: "Số lượng hình tối đa là: " + Configs. SO_LUONG_HINH_TOI_DA
	public void Question8() {
		try {
			for (int i = 0; i < 2; i++) {
				HinhHoc hinhtron = new HinhTron(3);
				HinhHoc hinhChuNhat = new HinhChuNhat(3, 2.5f);
				System.out.println(hinhtron.tinhDienTich());
				System.out.println(hinhChuNhat.tinhDienTich());
			}
			HinhHoc hinh = new HinhTron(3);
			HinhHoc hinh2 = new HinhTron(3);
		} catch (HinhHocException e) {
			System.out.println(e.getMessage());
		}
	}
}
