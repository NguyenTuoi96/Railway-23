package com.vti.entity;

public class KhoiThi {
	private String tenKhoi;

	public String getTenKhoi() {
		return tenKhoi;
	}

	public String getMonThi() {
		String monThi = "";
		switch (this.tenKhoi) {
		case "A":
			monThi = "Toán, Lý, Hoá";
			break;
		case "B":
			monThi = "Toán, Hóa, Sinh";
			break;
		case "C":
			monThi = "Văn, Sử, Địa";
			break;
		default: 
			break;
		}
		return monThi;
	}

	public KhoiThi(String tenKhoi) {
		this.tenKhoi = tenKhoi;
	}

	public KhoiThi() {
	}

	@Override
	public String toString() {
		return "KhoiThi [tenKhoi=" + tenKhoi + ", getMonThi()=" + getMonThi() + "]";
	}

}
