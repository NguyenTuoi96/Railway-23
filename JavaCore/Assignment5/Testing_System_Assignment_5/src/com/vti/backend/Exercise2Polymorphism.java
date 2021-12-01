package com.vti.backend;

import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

import com.vti.entity.HinhChuNhat;
import com.vti.entity.HinhVuong;
import com.vti.entity.Student;

//Hãy viết chương trình thực hiện các lệnh sau:
//a) Tạo 10 học sinh, chia thành 3 nhóm
//b) Kêu gọi cả lớp điểm danh.
//c) Gọi nhóm 1 đi học bài
//d) Gọi nhóm 2 đi dọn vệ sinh
public class Exercise2Polymorphism {
	private Student[] students;
	private Scanner sc;

	public Exercise2Polymorphism() {
		sc = new Scanner(System.in);
		students = new Student[] {};
	}

	public void question1() {
		while (true) {
			System.out.println("Lựa chọn chức năng");
			System.out.println("1. Tạo 10 học sinh, chia thành 3 nhóm");
			System.out.println("2. Kêu gọi cả lớp điểm danh.");
			System.out.println("3. Gọi nhóm 1 đi học bài");
			System.out.println("4. Gọi nhóm 2 đi dọn vệ sinh");
			System.out.println("5. In danh sách học sinh");
			System.out.println("6. Thoát chương trình");
			int selectNum = sc.nextInt();
			switch (selectNum) {
			case 1:
				taoDanhSachHocSinh();
				break;
			case 2:
				caLopDiemDanh();
				break;
			case 3:
				goiNhom1HocBai();
				break;
			case 4:
				goiNhom2DonVeSinh();
				break;
			case 5:
				inDanhSachHocSinh();
				break;
			case 6:
				System.out.println("Bye!");
				sc.close();
				return;
			default:
				System.out.println("Lựa chọn đúng số trên menu");
				break;
			}
		}
	}

	public void taoDanhSachHocSinh() {
//		for(int i = 0; i < 10; i++) {
//			sc.nextLine();
//			System.out.println("Hãy nhập vào tên học sinh");
//			String nameStudent = sc.nextLine();
//			int groupStudent = 0;
//			while(true) {
//				System.out.println("Hãy nhập vào nhóm của học sinh (1 hoặc 2 hoặc 3)");
//				groupStudent = sc.nextInt();
//				if(groupStudent == 1 || groupStudent == 2 || groupStudent == 3) {
//					break;
//				}else {
//					System.out.println("Bạn nhập sai nhóm, hãy nhập lại");
//				}
//			}
//			Student student = new Student(students.length, nameStudent, groupStudent);
//			students = ArrayUtils.add(students, student);
//		}
		
		
		String[] nameArr = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
		for (String name : nameArr) {
			Student student = new Student(students.length, "Nguyễn Văn " + name, (int) (Math.random() * (4 - 1) + 1));
			students = ArrayUtils.add(students, student);
		}
	}

	public void caLopDiemDanh() {
		for (Student student : students) {
			student.diemDanh();
		}
	}

	public void goiNhom1HocBai() {
		boolean isCheck = false;
		for (Student student : students) {
			if (student.getGroup() == 1) {
				student.hocBai();
				isCheck = true;
			}
		}
		if(!isCheck) {
			System.out.println("Không có bạn nào trong nhóm 1");
		}
	}

	public void goiNhom2DonVeSinh() {
		boolean isCheck = false;
		for (Student student : students) {
			if (student.getGroup() == 2) {
				student.donVeSinh();
				isCheck = true;
			}
		}
		if(!isCheck) {
			System.out.println("Không có bạn nào trong nhóm 2");
		}
	}

	public void inDanhSachHocSinh() {
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	public void question2() {
		while (true) {
			System.out.println("Lựa chọn chức năng");
			System.out.println("1. Tính chu vi và diện tích hình vuông");
			System.out.println("2. Tính chu vi và diện tích hình chữ nhật");
			System.out.println("3. Thoát chương trình");
			int selectNum = sc.nextInt();
			switch (selectNum) {
			case 1:
				// tính chu vi và diện tích hình vuông
				System.out.println("Nhập độ dài cạnh hình vuông (cm)");
				int doDaiCanh = sc.nextInt();
				HinhVuong hinhVuong = new HinhVuong(doDaiCanh);			
				System.out.println("Chu vi hình vuông: " + hinhVuong.tinhChuVi() + "cm");
				System.out.println("Diện tích hình vuông: " + hinhVuong.tinhDienTich() + "cm2");
				break;
			case 2:
				// tính chu vi và diện tích hình vuông
				System.out.println("Nhập độ dài chiều dài hình chữ nhật (cm)");
				int chieuDai = sc.nextInt();
				System.out.println("Nhập độ dài chiều rộng hình chữ nhật (cm)");
				int chieuRong = sc.nextInt();
				HinhChuNhat hinhChuNhat = new HinhChuNhat(chieuDai, chieuRong);			
				System.out.println("Chu vi hình chữ nhật: " + hinhChuNhat.tinhChuVi() + "cm");
				System.out.println("Diện tích hình chữ nhật: " + hinhChuNhat.tinhDienTich() + "cm2");
				break;
			case 3:
				System.out.println("Bye!");
				sc.close();
				return;
			default:
				System.out.println("Lựa chọn đúng số trên menu");
				break;
			}
		}
	}
}
