package com.vti.frontend;

import java.util.Scanner;

import com.vti.backend.Exercise5;
import com.vti.entity.ScannerUtils;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		new ScannerUtils(sc);
		Exercise5.question1();
//		Exercise5.question2();
		sc.close();
		
	}

}
