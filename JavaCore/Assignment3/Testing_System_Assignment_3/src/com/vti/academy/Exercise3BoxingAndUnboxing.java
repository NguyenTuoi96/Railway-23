package com.vti.academy;

public class Exercise3BoxingAndUnboxing {

	public static void main(String[] args) {
		
		// Question 1
		question1();
		System.out.println();

		// Question 2
		question2();
		System.out.println();		

		// Question 3
		question3();
		System.out.println();
	}

	/**
	 * Question 1: Khởi tạo lương có datatype là Integer có giá trị bằng 5000. Sau
	 * đó convert lương ra float và hiển thị lương lên màn hình (với số float có 2
	 * số sau dấu thập phân)
	 * 
	 */
	private static void question1() {
		System.out.println("Question 1");
//		Integer salary = new Integer(5000);
		Integer salary = Integer.valueOf(5000);
		float fSalary = salary;

		System.out.println(String.format("%.2f", fSalary));
	}

	/**
	 * Question 2: Khai báo 1 String có value = "1234567" Hãy convert String đó ra
	 * số int
	 * 
	 */
	private static void question2() {
		System.out.println("Question 2");
		String str = "1234567";
		int cvrInt = Integer.valueOf(str).intValue();

		System.out.println("Số sau khi convert: " + cvrInt);
	}

	/**
	 * Question 3: Khởi tạo 1 số Integer có value là chữ "1234567" Sau đó convert số
	 * trên thành datatype int
	 * 
	 */
	private static void question3() {
		System.out.println("Question 3");
		Integer salary = Integer.valueOf("1234567");
		int iSalary = salary.intValue();
		System.out.println("Số sau khi convert: " + iSalary);
	}
}
