package com.vti.Utils;

import java.util.Scanner;

public class ScannerUtils {
	private static Scanner sc;

	public ScannerUtils(Scanner sc) {
		super();
		ScannerUtils.sc = sc;
	}

	public static int inputInt(String errorMessage) {
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

	public static int inputYesOrNo(String errorMessage) {
		int output = 0;
		boolean isOk = false;
		while (!isOk) {
			try {
				isOk = true;
				String iput = sc.nextLine();
				output = Integer.valueOf(iput).intValue();
				if(output != 1 && output != 2) {
					isOk = false;
					System.out.println(errorMessage);
				}
			} catch (NumberFormatException e) {
				isOk = false;
				System.out.println(errorMessage);
			}
		}
		return output;
	}

	public static float inputFloat(String errorMessage) {
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

	public static double inputDouble(String errorMessage) {
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

	public static String inputString() {
		return sc.nextLine();
	}

	public static String inputStringGender(String errorMessage) {
		String output = null;
		boolean isOk = false;
		while (!isOk) {
			isOk = true;
			String iput = sc.nextLine();
			if ("0".equals(iput) || "1".equals(iput) || "2".equals(iput)) {
				switch (iput) {
				case "0":
					output = "M";
					break;
				case "1":
					output = "F";
					break;
				case "2":
					output = "0";
					break;
				default:
					break;
				}
			} else {
				isOk = false;
				System.out.println(errorMessage);
			}
		}
		return output;
	}
}
