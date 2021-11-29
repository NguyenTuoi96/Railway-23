package com.vti.entity;

public class KySu extends CanBo {
	private String nganhDaoTao;
	
	public KySu(String hoTen, byte tuoi, String gioiTinh, String diaChi, String nganhDaoTao) {
		super(hoTen, tuoi, gioiTinh, diaChi);
		this. nganhDaoTao = nganhDaoTao;
	}

	@Override
	public String toString() {
		return "Kỹ sư     [" + super.toString() + ", Ngành đào tạo = " + nganhDaoTao + "]";
	}

	/**
	 * @return the nganhDaoTao
	 */
	public String getNganhDaoTao() {
		return nganhDaoTao;
	}

	/**
	 * @param nganhDaoTao the nganhDaoTao to set
	 */
	public void setNganhDaoTao(String nganhDaoTao) {
		this.nganhDaoTao = nganhDaoTao;
	}
}
