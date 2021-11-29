package com.vti.entity;

public class CongNhan extends CanBo {
	private byte bac;
	
	public CongNhan(String hoTen, byte tuoi, String gioiTinh, String diaChi, byte bac) {
		super(hoTen, tuoi, gioiTinh, diaChi);
		this.bac = bac;
	}

	@Override
	public String toString() {
		return "Công nhân [" + super.toString() + ", Bậc = " + bac + "]";
	}

	/**
	 * @return the bac
	 */
	public byte getBac() {
		return bac;
	}

	/**
	 * @param bac the bac to set
	 */
	public void setBac(byte bac) {
		this.bac = bac;
	}
}
