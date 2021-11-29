package com.vti.entity;

public class CanBo {
	private String hoTen;
	private byte tuoi;
	private String gioiTinh;
	private String diaChi;
	
	public CanBo(String hoTen, byte tuoi, String gioiTinh, String diaChi) {
		this.hoTen = hoTen;
		this.tuoi = tuoi;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
	}
	
	@Override
	public String toString() {
		return "Cán bộ [Họ tên = " + hoTen + ", Tuổi = " + tuoi + ", Giới Tính = " + gioiTinh + ", Địa chỉ = " + diaChi + "]";
	}
	
	/**
	 * @return the hoTen
	 */
	public String getHoTen() {
		return hoTen;
	}
	/**
	 * @param hoTen the hoTen to set
	 */
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	/**
	 * @return the tuoi
	 */
	public byte getTuoi() {
		return tuoi;
	}
	/**
	 * @param tuoi the tuoi to set
	 */
	public void setTuoi(byte tuoi) {
		this.tuoi = tuoi;
	}
	/**
	 * @return the gioiTinh
	 */
	public String getGioiTinh() {
		return gioiTinh;
	}
	/**
	 * @param gioiTinh the gioiTinh to set
	 */
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	/**
	 * @return the diaChi
	 */
	public String getDiaChi() {
		return diaChi;
	}
	/**
	 * @param diaChi the diaChi to set
	 */
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
}
