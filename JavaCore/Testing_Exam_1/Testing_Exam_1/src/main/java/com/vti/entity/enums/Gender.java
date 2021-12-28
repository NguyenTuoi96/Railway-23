package com.vti.entity.enums;

public enum Gender {
	NAM("M") 
	, NU("F")
	, KHONG_XAC_DINH("0");

	private String gender;

	Gender(String gender) {
		this.gender = gender;
	}

	public String getGenderName() {
		if("M".equals(gender)) {
			return "Nam";
		}else if("F".equals(gender)) {
			return "Nữ";
		}else {
			return "Chưa xác định";
		}
	}
}
