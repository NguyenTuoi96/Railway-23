package com.vti.entity;

public class HinhChuNhat extends HinhHoc {
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

	public HinhChuNhat(float chieuDai, float chieuRong) throws HinhHocException {
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}

	@Override
	public float tinhChuVi() {
		return (this.chieuDai + this.chieuRong) * 2;
	}

	@Override
	public float tinhDienTich() {
		return this.chieuDai * this.chieuRong;
	}

	@Override
	public String toString() {
		return "HinhChuNhat [chieuDai=" + chieuDai + ", chieuRong=" + chieuRong + "]";
	}

	
}
