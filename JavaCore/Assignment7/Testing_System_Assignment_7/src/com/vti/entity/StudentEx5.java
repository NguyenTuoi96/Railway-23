package com.vti.entity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StudentEx5 implements Serializable {
	private int id;
	private String name;
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
	
	public StudentEx5(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public StudentEx5() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	public static void ghiDoiTuong(StudentEx5[] studentArr, String file) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			for(StudentEx5 student : studentArr) {
				objectOutputStream.writeObject(student);
			}
			fileOutputStream.close();
			objectOutputStream.close();
		} catch (FileNotFoundException e1) {
			System.out.println("Đã xảy ra lỗi không tìm thấy file để ghi");
		} catch (IOException e) {
			System.out.println("Đã xảy ra lỗi khi ghi đối tượng vào file");
		}
	}

	public static void docDoiTuong(StudentEx5[] studentArr, String file) {
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Object obj;

			for(StudentEx5 student : studentArr) {
				obj = objectInputStream.readObject();
				StudentEx5 stdOput = (StudentEx5) obj;
				System.out.println(stdOput);
			}
			fileInputStream.close();
			objectInputStream.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Đã xảy ra lỗi không tìm thấy lớp tham chiếu khi đọc file");
		} catch (FileNotFoundException e) {
			System.out.println("Đã xảy ra lỗi không tìm thấy file để đọc");
		} catch (IOException e) {
			System.out.println("Đã xảy ra lỗi khi đọc file");
		}
	}
	
}
