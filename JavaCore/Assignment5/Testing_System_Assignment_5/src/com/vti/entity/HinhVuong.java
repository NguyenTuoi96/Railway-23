package com.vti.entity;

public class HinhVuong extends HinhChuNhat {

	public HinhVuong(float doDaiCanh) {
		super(doDaiCanh, doDaiCanh);
	}

	// tính chu vi
	public float tinhChuVi() {
		System.out.println("Tính chu vi theo hình chữ nhật");
		return super.tinhChuVi();
	}	

	// tính diện tích
	public float tinhDienTich() {
		System.out.println("Tính diện tích theo hình chữ nhật");
		return super.tinhDienTich();
	}
}
