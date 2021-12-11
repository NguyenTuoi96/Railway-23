package com.vti.entity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.vti.utils.IOManager;

public class LogUtils {
	private final static String FILE_PATH = "C:\\Users\\tuoin\\OneDrive\\デスクトップ\\studyFileJava\\Exception.ser";
	public static void writeLog (String message, Throwable reason, StackTraceElement[] stackTrace, String time) {		
		try {
			MyException myException = new MyException(message, reason, stackTrace, time);
			IOManager.writeFile(FILE_PATH, myException.toString(), true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void writeLog (MyException exception) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(exception);
			fileOutputStream.close();
			objectOutputStream.close();
		} catch (FileNotFoundException e1) {
			System.out.println("Đã xảy ra lỗi không tìm thấy file để ghi");
		} catch (IOException e) {
			System.out.println("Đã xảy ra lỗi khi ghi đối tượng vào file");
		}
	}
	
	public static void docException() {
		try {
			FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Object obj;

			obj = objectInputStream.readObject();
			MyException myException = (MyException) obj;
			System.out.println(myException);
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
