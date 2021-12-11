package com.vti.entity;

public class PrimaryStudent extends Student {

	public static int countPrimaryStudent = 0;
	
	public PrimaryStudent(int id, String name) {
		super(id, name);
		countPrimaryStudent++;
	}

}
