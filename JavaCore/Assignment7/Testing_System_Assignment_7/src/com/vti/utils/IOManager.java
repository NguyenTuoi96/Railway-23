package com.vti.utils;

import java.io.File;
import java.io.FileOutputStream;

public class IOManager {
	public static void writeFile(String pathFile, String content, boolean isContinuing) throws Exception {
		File file = new File(pathFile);
		if (!file.exists()) {
			throw new Exception("Error! File Not Exist.");
		}
		FileOutputStream fileOutputStream = new FileOutputStream(pathFile, isContinuing);
		fileOutputStream.write(content.getBytes());
		fileOutputStream.close();
		System.out.println("ghi file ok");
	}
}
