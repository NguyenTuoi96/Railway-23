package com.vti.entity;

public class HinhHocException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public HinhHocException() {
		super("Số lượng hình tối đa là:" + Configs.SO_LUONG_HINH_TOI_DA);
	}
}
