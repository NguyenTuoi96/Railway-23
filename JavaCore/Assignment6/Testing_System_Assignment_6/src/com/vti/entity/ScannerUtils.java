package com.vti.entity;

import java.util.Scanner;

public class ScannerUtils {
	private Scanner sc;
	
	public ScannerUtils(Scanner sc) {
		super();
		this.sc = sc;
	}
	
	public int inputInt(String errorMessage) {
		int output = 0;
		boolean isOk = false;
		while (!isOk) {
			try {
				isOk = true;
				String iput = sc.nextLine();
				output = Integer.valueOf(iput).intValue();
			} catch (NumberFormatException e) {
				isOk = false;
				System.out.println(errorMessage);				
			}
		}
		return output;
	}
	
	public float inputFloat(String errorMessage) {
		float output = 0;
		boolean isOk = false;
		while (!isOk) {
			try {
				isOk = true;
				String iput = sc.nextLine();
				output = Float.valueOf(iput).floatValue();
			} catch (NumberFormatException e) {
				isOk = false;
				System.out.println(errorMessage);				
			}
		}
		return output;
	}
	
	public double inputDouble(String errorMessage) {
		double output = 0;
		boolean isOk = false;
		while (!isOk) {
			try {
				isOk = true;
				String iput = sc.nextLine();
				output = Double.valueOf(iput).doubleValue();
			} catch (NumberFormatException e) {
				isOk = false;
				System.out.println(errorMessage);				
			}
		}
		return output;
	}
	
	public String inputString() {
		return sc.nextLine();
	}
}
