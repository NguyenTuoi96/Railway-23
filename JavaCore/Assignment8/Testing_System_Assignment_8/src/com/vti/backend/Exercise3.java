package com.vti.backend;

import com.vti.entity.Employee;
import com.vti.entity.MyMap;
import com.vti.entity.Phone;
import com.vti.entity.Staff;
import com.vti.entity.StudentEx3;

public class Exercise3 {
	
//	Question 1: T generic (class)
//	Tạo class student có property id, name (trong đó id của student có thể là int, long, float)
//	a) Tạo đối tượng student có id là int
//	b) Tạo đối tượng student có id là float
//	c) Tạo đối tượng student có id là double
	public static void question1() {
		// a) Tạo đối tượng student có id là int
		StudentEx3<Integer> stdInt = new StudentEx3<Integer>(1, "Nguyễn Văn Integer");

		// b) Tạo đối tượng student có id là float
		StudentEx3<Float> stdFloat = new StudentEx3<Float>(2.0f, "Nguyễn Văn Float");

		// c) Tạo đối tượng student có id là double
		StudentEx3<Double> stdDouble = new StudentEx3<Double>(3.0, "Nguyễn Văn Double");

		System.out.println(stdInt);
		System.out.println(stdFloat);
		System.out.println(stdDouble);
	}

//	Question 2: T generic (method)
//	Tạo method để in ra thông tin nhập vào (parameter)
//	(parameter có thể là họ và tên, hoặc student, hoặc int)
//	Gợi ý: tạo method print(T a) và cài đặt system out (a) ra
//	Demo chương trình với print(student), print(4), print(4.0)

	public static void question2() {
		StudentEx3<Integer> student = new StudentEx3<Integer>(1, "Nguyễn Văn Integer");
		print(student);
		print(4);
		print(4.0);
	}

	private static <T> void print(T param) {
		System.out.println(param);
	}

//	Question 4: E generic
//	Tạo 1 array int, 1 array float, 1 array long, 1 array double
//	Tạo 1 method có parameter là array và in ra các số trong array đó	
	public static void question4() {
		Integer[] arrI = { 1, 2, 3 };
		Float[] arrF = { 4f, 5f, 6f };
		Double[] arrD = { 7.1, 7.2, 7.3 };
		printArr(arrI);
		System.out.println();
		printArr(arrF);
		System.out.println();
		printArr(arrD);
	}

	private static <T> void printArr(T[] arr) {
		for (T x : arr) {
			System.out.println(x);
		}
	}
	
//	Question 5: E generic
//	Tạo 1 class Employee có property id, name, salaries với salaries là lương các tháng của Employee đó và là 1 array có data type có thể là int, long, float.
//	Viết method trong Employee để in ra thông tin của Employee bao gồm id, name, salaris.
//	Viết method trong Employee để in ra thông tin tháng lương cuối cùng của Employee
//	a) Hãy tạo chương trình demo với Employee có salaries là datatype int
//	b) Hãy tạo chương trình demo với Employee có salaries là datatype float
//	c) Hãy tạo chương trình demo với Employee có salaries là datatype double
	public static void question5() {
		Integer[] salariesI = new Integer[] {1000000, 2000000};
		Employee<Integer> empI = new Employee<Integer>(1, "Nguyễn Văn Integer", salariesI);
		System.out.println(empI);
		System.out.println("Tháng lương cuối của " + empI.getName() + " là: " + empI.getThangLuongCuoi(empI.getSalaries()));

		Float[] salariesF = new Float[] {1000000.0f, 2000000.0f};
		Employee<Float> empF = new Employee<Float>(2, "Nguyễn Văn Float", salariesF);
		System.out.println(empF);
		System.out.println("Tháng lương cuối của " + empF.getName() + " là: " + empF.getThangLuongCuoi(empF.getSalaries()));		

		Double[] salariesD = new Double[] {1000000.0, 2000000.0};
		Employee<Double> empD = new Employee<Double>(2, "Nguyễn Văn Double", salariesD);
		System.out.println(empD);
		System.out.println("Tháng lương cuối của " + empD.getName() + " là: " + empD.getThangLuongCuoi(empD.getSalaries()));	
	}
	
//	Question 6: K & V generic
//	Tạo 1 class có tên là MyMap, lưu dữ liệu theo dạng key, value
//	Tạo các method
//	a) GetValue()
//	b) getKey ()
//	Viết chương trình demo: tạo 1 object Student có key là Mã sinh viên và value là tên của sinh viên đó
	public static void question6() {
		MyMap<Integer, String> student = new MyMap<Integer, String>(1, "Nguyễn Văn A");
		System.out.println(student);
	}
	
//	Question 7: K & V generic
//	Tạo 1 class có tên là Phone, lưu dữ liệu theo dạng key, value (extends MyMap)
//	Với key là email hoặc là số thứ tự hoặc là tên người sử dụng
//	Với value là số điện thoại
//	Tạo các method
//	a) GetPhoneNumber()
//	b) getKey ()
//	Viết chương trình demo với
//	a) key là email
//	b) key là số thứ tự
//	c) key là tên của người sử dụng
	public static void question7() {
		// a. key là email
		Phone<String, String> email = new Phone<String, String>("nguyenvana@gmail.com", "01245354789");
		System.out.println(email.getKey() + " " + email.getPhoneNumber());	
		// b. key là số thứ tự
		Phone<Integer, String> num = new Phone<Integer, String>(1, "01245354789");
		System.out.println(num.getKey() + " " + num.getPhoneNumber());	
		// c. key là tên của người sử dụng
		Phone<String, String> name = new Phone<String, String>("Nguyễn Văn A", "01245354789");
		System.out.println(name.getKey() + " " + name.getPhoneNumber());	
	}
	
//	Question 8: K & V generic
//	Tạo 1 class có tên là Staff, lưu dữ liệu theo dạng key, value (extends MyMap)
//	Với key là id của Staff (ID có thể là int, long)
//	Với value là tên của Staff
//	Tạo các method
//	a) GetId ()
//	b) getName ()
//	Viết chương trình demo
	public static void question8() {
		// id là int
		Staff<Integer, String> staffI = new Staff<Integer, String>(1, "Nguyễn Văn A");
		System.out.println(staffI.getId() + " " + staffI.getName());	
		// id là long
		Staff<Long, String> staffL = new Staff<Long, String>(2L, "Nguyễn Văn B");
		System.out.println(staffL.getId() + " " + staffL.getName());
	}
}
