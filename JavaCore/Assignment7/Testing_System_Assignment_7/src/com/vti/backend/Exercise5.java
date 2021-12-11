package com.vti.backend;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.ArrayUtils;

import com.vti.entity.LogUtils;
import com.vti.entity.MyException;
import com.vti.entity.ScannerUtils;
import com.vti.entity.StudentEx5;

public class Exercise5 {
//	Question 1: Tạo class Student có property id, name.
//	a) Sau đó khởi 3 instance từ console (sử dụng ScannerUtils)
//	b) Write 3 student này ra file tên là StudentInformation.txt
//	c) Sau đó đọc thông tin file StudentInformation.txt và in ra màn hình
	public static void question1() {
		StudentEx5[] stdArr = new StudentEx5[] {};
		int i = 0;
		while (i < 3) {
			i++;
			System.out.println("Mời bạn nhập id");
			int id = ScannerUtils.inputInt("Bạn nhập sai định dạng, hãy nhập lại giá trị số");
			System.out.println("Mời bạn nhập name");
			String name = ScannerUtils.inputString();
			StudentEx5 std = new StudentEx5(id, name);
			stdArr = ArrayUtils.add(stdArr, std);
		}
		String file = "C:\\Users\\tuoin\\OneDrive\\デスクトップ\\studyFileJava\\StudentInformation.txt";
		File studentInformationFile = new File(file);
		if (!studentInformationFile.exists()) {
			try {
				studentInformationFile.createNewFile();
			} catch (IOException e) {
				System.out.println(
						"File \"StudentInformation.txt\" không tồn tại và tạo quá trình tạo file không thành công, hãy kiểm tra lại");
			}
		}
		StudentEx5.ghiDoiTuong(stdArr, file);

		StudentEx5.docDoiTuong(stdArr, file);

	}

	public static void question2() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss.SSS");
		String date = simpleDateFormat.format(new Date());
		System.out.println("Ngày hôm nay: " + date);
		File file = new File("C:\\Users\\tuoin\\OneDrive\\デスクトップ\\studyFileJav\\test.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			MyException exception = new MyException(e.getMessage(), e.getCause(), e.getStackTrace(), date);
			LogUtils.writeLog(exception);
			LogUtils.docException();
		}
	}

}
