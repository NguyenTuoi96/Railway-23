package com.vti.entity.enums;

public enum GioiTinh {
	GIOI_TINH_NAM("Nam") 
	, GIOI_TINH_NU("Nu")
	, GIOI_TINH_KHAC("Khac");

	private String gioiTinh;

	GioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}
}
