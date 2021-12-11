package com.vti.entity;

public class SecondaryStudent extends Student {

	public static int countSecondaryStudent = 0;

	public SecondaryStudent(int id, String name) {
		super(id, name);
		countSecondaryStudent++;
	}

}
