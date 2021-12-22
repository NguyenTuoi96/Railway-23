package com.vti.entity;

public class Student {
	private int id;
	private String name;
	public static int countStudent = 0;
	
	public Student(String name) {
		super();
		countStudent++;
		this.id = countStudent;
		this.name = name;
	}

	/**
     * @deprecated replaced by getIdNew()}.
     */
	@Deprecated
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

	public String getIdNew() {
		return "MSV: " + id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
}
