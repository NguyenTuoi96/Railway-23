package com.vti.entity;

import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

public class TuyenSinh implements ITuyenSinh {
	private ThiSinh[] thiSinhArr;
	private Scanner sc;

	public TuyenSinh() {
		this.thiSinhArr = new ThiSinh[] {};
		this.sc = new Scanner(System.in);
	}

	@Override
	public void themThiSinh() {
		System.out.println("Nhập số báo danh của thí sinh");
		String soBaoDanh = sc.nextLine();
		System.out.println("Nhập họ và tên của thí sinh");
		String hoTen = sc.nextLine();
		System.out.println("Nhập địa chỉ của thí sinh");
		String diaChi = sc.nextLine();
		System.out.println("Nhập mức ưu tiên của thí sinh");
		String mucUuTien = sc.nextLine();
		String khoiThiInput = "";
		KhoiThi khoiThi = new KhoiThi();
		boolean isOk = false;
		while (!isOk) {
			System.out.println("Nhập khối thi của thí sinh (A hoặc B hoặc C)");
			khoiThiInput = sc.nextLine();
			if(khoiThiInput.equals("A") || khoiThiInput.equals("B") || khoiThiInput.equals("C")) {
				khoiThi = new KhoiThi(khoiThiInput);
				break;
			}else {
				System.out.println("Nhập sai tên khối, hãy nhập lại");
			}
		}
		ThiSinh thisinh = new ThiSinh(soBaoDanh, hoTen, diaChi, mucUuTien, khoiThi);
		this.thiSinhArr = ArrayUtils.add(this.thiSinhArr, thisinh);
		System.out.println("Đã thêm thí sinh sau vào danh sách: ");
		System.out.println(thisinh);
	}

	@Override
	public void hienThiThongTin() {
		for(ThiSinh thiSinh : thiSinhArr) {
			System.out.println(thiSinh);
		}
	}

	@Override
	public void timKiem() {
		String soBaoDanh = "";
		System.out.println("Nhập số báo danh của thí sinh để tìm kiếm");
		soBaoDanh = sc.nextLine();
		boolean isCheck = false;
		for(ThiSinh thiSinh : thiSinhArr) {
			if(soBaoDanh.equals(thiSinh.getSoBaoDanh())) {
				isCheck = true;
				System.out.println(thiSinh);
			}
		}
		if(!isCheck) {
			System.out.println("Không có thí sinh nào có số báo danh như vậy");
		}
	}

	@Override
	public void thoatChuongTrinh() {
		sc.close();
	}

}
