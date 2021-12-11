package com.vti.entity;

public class Student {
	int id;
	String name;
	static String college = "Đại học bách khoa";
	public static float moneyGroup;
	public static int countStudent = 0;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static String getCollege() {
		return college;
	}
	public static void setCollege(String college) {
		Student.college = college;
	}
	
	public static void thayDoiCollege() {
		college = "Đại học công nghệ";
	}
	
	public Student(int id, String name) {
		if(countStudent >= 7) {
			throw new OutOfMemoryError("Chỉ tạo được tối đa 7 học sinh");
		}
		countStudent++;
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", college=" + college + "]";
	}
}
