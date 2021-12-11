package com.vti.entity;

public class HinhTron extends HinhHoc {
	private float r;

	public float getR() {
		return r;
	}

	public void setR(float r) {
		this.r = r;
	}

	public HinhTron(float r) throws HinhHocException {
		this.r = r;
	}

	@Override
	public float tinhChuVi() {
		return (float) (this.r * 2 * Math.PI);
	}

	@Override
	public float tinhDienTich() {
		return (float) (Math.pow(this.r, 2) * Math.PI);
	}	

	@Override
	public String toString() {
		return "HinhTron [r=" + r + "]";
	}

}
