package com.vti.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

	// Check File is exists
	public static boolean isFileExists(String pathFile) {
		File file = new File(pathFile);
		return file.exists();
	}

	// Create new file
	public static void createNewFile(String pathFile) throws Exception {
		File file = new File(pathFile);
		if (!isFileExists(pathFile)) {
			throw new Exception("Error! File Exist.");
		}
		if (file.createNewFile()) {
			System.out.println("file đã tạo thành công");
		} else {
			System.out.println("tạo file thất bại, hãy xem lại");
		}
	}

	// Delete file
	public static void deleteFile(String pathFile) throws Exception {
		File file = new File(pathFile);
		if (!isFileExists(pathFile)) {
			throw new Exception("Error! File Exist.");
		}
		if (file.delete()) {
			System.out.println("file đã xóa thành công");
		} else {
			System.out.println("xóa file thất bại, hãy xem lại");
		}
	}

	// Check path is File or Folder
	public static boolean isFolder(String path) {
		File file = new File(path);
		boolean isCheck = false;
		if (file.isDirectory()) {
			System.out.println("Là 1 Folder");
			isCheck = true;
		} else if (file.isFile()) {
			System.out.println("Là 1 file");
			isCheck = true;
		} else {
			System.out.println("Đây không phải 1 đường dẫn hay folder hay file");
		}
		return isCheck;
	}

	// Get all File name of Folder
	public static List<String> getAllFileName(String path) throws Exception {
		List<String> list = new ArrayList<String>();
		File filePath = new File(path);
		if (!filePath.isDirectory()) {
			throw new Exception("Error! Path is not folder.");
		}
		File[] listOfFiles = filePath.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				list.add(listOfFiles[i].getName());
			}
		}
		return list;

	}

	// Copy File
	public static void copyFile(String sourceFile, String distinationPath) throws Exception {
		File source = new File(sourceFile);
		String fileName = source.getName();
		String distination = distinationPath + "\\" + fileName;
		File distinationF = new File(distination);
		if (!isFileExists(sourceFile)) {
			throw new Exception("Error! Source File Not Exist.");
		}
		if (isFileExists(distination)) {
			throw new Exception("Error! newPath has File same name.");
		}
		Files.copy(source.toPath(), distinationF.toPath());
	}

	// Moving File
	public static void moveFile(String sourceFile, String distinationPath) throws Exception {
		if (!isFileExists(sourceFile)) {
			throw new Exception("Error! Source File Not Exist.");
		}
		File sourceF = new File(sourceFile);
		String fileName = sourceF.getName();
		String distinationP = distinationPath + "\\" + fileName;
		File distinationF = new File(distinationP);
		Files.move(sourceF.toPath(), distinationF.toPath());
	}

	// Moving File
	public static void renameFile(String pathFile, String newName) throws Exception {
		File oldFile = new File(pathFile);
		if (!isFileExists(pathFile)) {
			throw new Exception("Error! File Not Exist.");
		}
		if (isFileExists(oldFile.getPath() + "\\" + newName)) {
			throw new Exception("Error! Name is Exist.");
		}
		File newFile = new File(oldFile.getPath() + "\\" + newName);
		oldFile.renameTo(newFile);
	}

	// Moving File
	public static void createNewFolder(String newPathFolder) throws Exception {
		File theDir = new File(newPathFolder);
		if (!isFileExists(newPathFolder)) {
			throw new Exception("Error! Folder Exist.");
		}
		if (theDir.mkdirs()) {
			System.out.println("Tạo folder thành công");
		} else {
			System.out.println("Tạo folder thất bại");
		}
	}

	public static void downloadFile(URL url, String outputFileName) throws IOException {
		ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
		FileOutputStream fos = new FileOutputStream(outputFileName);

		try {
			fos.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
		} catch (Exception e) {
			System.out.println(e);
		}finally {			
			readableByteChannel.close();
			fos.close();
		}
	}
}
