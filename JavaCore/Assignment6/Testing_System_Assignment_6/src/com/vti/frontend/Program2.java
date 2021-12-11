package com.vti.frontend;

import java.util.Scanner;

import com.vti.backend.Exercise2Exception;
import com.vti.entity.ScannerUtils;

public class Program2 {

	public static void main(String[] args) {
		Exercise2Exception ex2 = new Exercise2Exception();
		Scanner sc = new Scanner(System.in);
//		ex2.question1();
//		ex2.question3();
//		ex2.question4();
//		ex2.question5(sc);
		ScannerUtils scUtils = new ScannerUtils(sc);
//		ex2.question8(scUtils);
//		ex2.question9(scUtils);
		ex2.question10(scUtils);
		sc.close();
		
	}


}
