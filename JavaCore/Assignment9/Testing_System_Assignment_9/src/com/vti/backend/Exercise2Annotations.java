package com.vti.backend;

import java.util.Date;

import com.vti.entity.Student;

public class Exercise2Annotations {
	@SuppressWarnings("deprecation")
	public void question1() {
		Date date = new Date("18/05/2020");
		System.out.println(date);
	}

	public void question2() {
		Student student = new Student("Nguyễn Văn A");
		System.out.println(student.getName());
		
		// lấy id
		int id = student.getId();
		String idNew = student.getIdNew();
		System.out.println(id);
		System.out.println(idNew);
	}
}
