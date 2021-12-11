package com.vti.entity;

public abstract class HinhHoc {
	
	public static int countHinh = 0;
	
	public HinhHoc() throws HinhHocException {
		countHinh++;
		if(countHinh > 5) {
			throw new HinhHocException();
		}
	}
	public abstract float tinhChuVi();
	public abstract float tinhDienTich();
}
