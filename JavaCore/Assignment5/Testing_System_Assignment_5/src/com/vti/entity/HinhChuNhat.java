package com.vti.entity;

public class HinhChuNhat {
	private float chieuDai;
	private float chieuRong;
	
	public float getChieuDai() {
		return chieuDai;
	}

	public void setChieuDai(float chieuDai) {
		this.chieuDai = chieuDai;
	}

	public float getChieuRong() {
		return chieuRong;
	}

	public void setChieuRong(float chieuRong) {
		this.chieuRong = chieuRong;
	}

	public HinhChuNhat(float chieuDai, float chieuRong) {
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}
	
	@Override
	public String toString() {
		return "HinhChuNhat [chieuDai=" + chieuDai + ", chieuRong=" + chieuRong + "]";
	}

	// tính chu vi
	public float tinhChuVi() {
		float chuVi = (this.chieuDai + this.chieuRong) * 2;
		return chuVi;
	}	

	// tính diện tích
	public float tinhDienTich() {
		float dienTich = this.chieuDai * this.chieuRong;
		return dienTich;
	}
}
