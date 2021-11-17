package com.vti.academy;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class Exercise4RandomNumber {
	static Random random = new Random();
	public static void main(String[] args) {		
		//question1
		question1();
		
		//question2
		question2();

		//question3
		question3();

		//question4
		question4();

		//question5
		question5();

		//question6
		question6();

		//question7
		question7();
		
	}
	
	/**
	 * Question 1: In ngẫu nhiên ra 1 số nguyên
	 * 
	 */
	public static void question1() {
		System.out.println("Question 1:");
		int x = random.nextInt();
		System.out.println("ngẫu nhiên 1 số nguyên: " + x);
	}
	
	/**
	 * Question 2: In ngẫu nhiên ra 1 số thực
	 * 
	 */
	public static void question2() {
		System.out.println("Question 2:");
		float x = random.nextFloat();
		System.out.println("ngẫu nhiên 1 số thực: " + x);
	}
	
	/**
	 * Question 3: Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên ra tên của 1 bạn
	 * 
	 */
	public static void question3() {
		System.out.println("Question 3:");
		String[] listName = new String[] {"Nguyễn Văn A", "Nguyễn Văn B", "Nguyễn Văn C", "Nguyễn Văn D", "Nguyễn Văn E", "Nguyễn Văn F", "Nguyễn Văn G", "Nguyễn Văn H", "Nguyễn Văn I"};
		int i = random.nextInt(listName.length);
		System.out.println("ngẫu nhiên 1 bạn: " + listName[i]);
	}
	
	/**
	 * Question 4: Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-12-1995
	 * 
	 */
	public static void question4() {
		System.out.println("Question 4:");
		int minDay = (int) LocalDate.of(1995, 7, 24).toEpochDay();
		int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay();
		long randomInt = minDay + random.nextInt(maxDay - minDay);
		LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
		System.out.println("Ngày ngẫu nhiên là: " + randomDay);
	}
	
	/**
	 * Question 5: Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây
	 * 
	 */
	public static void question5() {
		System.out.println("Question 5:");
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
		SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
		SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
		
		int maxYear = Integer.parseInt(yearFormat.format(new Date()));
		int maxMonth = Integer.parseInt(monthFormat.format(new Date()));
		int maxDay = Integer.parseInt(dayFormat.format(new Date()));
		
		int minYear = Integer.parseInt(yearFormat.format(new Date())) - 1;
		int minMonth = Integer.parseInt(monthFormat.format(new Date()));
		int minDay = Integer.parseInt(dayFormat.format(new Date()));
		
		int minVal = (int) LocalDate.of(minYear, minMonth, minDay).toEpochDay();
		int maxval = (int) LocalDate.of(maxYear, maxMonth, maxDay).toEpochDay();
		long randomInt = minVal + random.nextInt(maxval - minVal);
		LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
		System.out.println("ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây là: " + randomDay);
	}
	
	/**
	 * Question 6: Lấy ngẫu nhiên 1 ngày trong quá khứ
	 * 
	 */
	public static void question6() {
		System.out.println("Question 6:");
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
		SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
		SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
		
		int maxYear = Integer.parseInt(yearFormat.format(new Date()));
		int maxMonth = Integer.parseInt(monthFormat.format(new Date()));
		int maxDay = Integer.parseInt(dayFormat.format(new Date()));
		
		int maxval = (int) LocalDate.of(maxYear, maxMonth, maxDay).toEpochDay();
		long randomInt = random.nextInt(maxval);
		LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
		System.out.println("ngẫu nhiên 1 ngày trong quá khứ là: " + randomDay);
	}
	
	/**
	 * Question 7: Lấy ngẫu nhiên 1 số có 3 chữ số
	 * 
	 */
	public static void question7() {
		System.out.println("Question 7:");
		int x = random.nextInt(999 - 100 + 1) + 100;
		System.out.println("ngẫu nhiên 1 số có 3 chữ số: " + x);
	}
}
