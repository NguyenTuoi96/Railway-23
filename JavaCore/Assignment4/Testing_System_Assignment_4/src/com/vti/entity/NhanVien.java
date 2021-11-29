package com.vti.entity;

public class NhanVien extends CanBo {

	private String congViec;
	
	public NhanVien(String hoTen, byte tuoi, String gioiTinh, String diaChi, String congViec) {
		super(hoTen, tuoi, gioiTinh, diaChi);
		this.congViec = congViec;
	}

	@Override
	public String toString() {
		return "Nhân Viên ["+ super.toString() + ", Công việc = " + congViec + "]";
	}

	/**
	 * @return the congViec
	 */
	public String getCongViec() {
		return congViec;
	}

	/**
	 * @param congViec the congViec to set
	 */
	public void setCongViec(String congViec) {
		this.congViec = congViec;
	}
}
