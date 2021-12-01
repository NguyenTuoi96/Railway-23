package com.vti.entity;

public class ThiSinh {
	private String soBaoDanh;
	private String hoTen;
	private String diaChi;
	private String mucUuTien;
	private KhoiThi khoiThi;
	public String getSoBaoDanh() {
		return soBaoDanh;
	}
	public void setSoBaoDanh(String soBaoDanh) {
		this.soBaoDanh = soBaoDanh;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getMucUuTien() {
		return mucUuTien;
	}
	public void setMucUuTien(String mucUuTien) {
		this.mucUuTien = mucUuTien;
	}
	public KhoiThi getKhoiThi() {
		return khoiThi;
	}
	public void setKhoiThi(KhoiThi khoiThi) {
		this.khoiThi = khoiThi;
	}
	@Override
	public String toString() {
		return "ThiSinh [soBaoDanh=" + soBaoDanh + ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", mucUuTien="
				+ mucUuTien + ", khoiThi=" + khoiThi + "]";
	}
	public ThiSinh(String soBaoDanh, String hoTen, String diaChi, String mucUuTien, KhoiThi khoiThi) {
		super();
		this.soBaoDanh = soBaoDanh;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.mucUuTien = mucUuTien;
		this.khoiThi = khoiThi;
	}
	
}
