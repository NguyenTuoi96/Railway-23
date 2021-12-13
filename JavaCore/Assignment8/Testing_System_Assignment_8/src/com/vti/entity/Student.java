package com.vti.entity;

public class Student {
	private int id;
	private String name;
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
		
	public Student(String name) {
		countStudent++;
		this.id = countStudent;
		this.name = name;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
}
