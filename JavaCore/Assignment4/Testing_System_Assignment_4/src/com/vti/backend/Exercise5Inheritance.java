package com.vti.backend;

import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

import com.vti.entity.CanBo;
import com.vti.entity.CongNhan;
import com.vti.entity.KySu;
import com.vti.entity.NhanVien;
import com.vti.entity.enums.GioiTinh;

public class Exercise5Inheritance {
	private CanBo[] canBoArr;
	private Scanner sc;

	public Exercise5Inheritance() {
		// thêm trước 3 cán bộ
		CanBo congNhan1 = new CongNhan("Nguyễn Văn A", (byte) 22, "Nam", "Hà Nam", (byte) 1);
		CanBo kySu1 = new KySu("Nguyễn Văn B", (byte) 22, "Nam", "Hà Nam", "Công Nghệ Thông Tin");
		CanBo nhanVien1 = new NhanVien("Nguyễn Văn C", (byte) 22, "Nam", "Hà Nam", "Quản lý");
		CanBo canbo1 = new CanBo("Nguyễn Văn D", (byte) 25, "Nam", "Hà Nam");
		canBoArr = new CanBo[] {congNhan1, kySu1, nhanVien1, canbo1};
		sc = new Scanner(System.in);
	}

	public void question2() {
		while (true) {
			System.out.println("Lựa chọn chức năng.");
			System.out.println("1. Thêm mới cán bộ.");
			System.out.println("2. Tìm kiếm theo họ tên.");
			System.out.println("3. Hiện thị thông tin về danh sách các cán bộ.");
			System.out.println("4. Nhập vào tên của cán bộ và delete cán bộ đó.");
			System.out.println("5. Thoát khỏi chương trình.");
			int chucNang = sc.nextInt();
			switch (chucNang) {
			case 1:
				themMoiCanBo();
				break;
			case 2:
				timKiemTheoHoTen();
				break;
			case 3:
				hienThiThongTin();
				break;
			case 4:
				xoaCanBo();
				break;
			case 5:// thoát chương trình
				sc.close();
				return;
			default:
				System.out.println("Mời bạn nhập lại đúng số chức năng");
				break;
			}
		}
	}

	private void themMoiCanBo() {
		System.out.println("Lựa chọn cấp bạn muốn thêm");
		System.out.println("1. Thêm kỹ sư");
		System.out.println("2. Thêm công nhân");
		System.out.println("3. Thêm nhân viên");
		int cap = sc.nextInt();
		switch (cap) {
		case 1:
			String[] kySuInfo = getCanboInfo("kỹ sư");
			String tenKySu = kySuInfo[0];
			Byte tuoiKySu = Byte.valueOf(kySuInfo[1]);
			String gioiTinhKySu = kySuInfo[2];
			String diachiKySu = kySuInfo[3];

			// Lấy ngành đào tạo
			System.out.println("Nhập ngành đào tạo của kỹ sư");
			String nganhDaoTao = sc.nextLine();

			// Thêm cán bộ
			CanBo kysuAdd = new KySu(tenKySu, tuoiKySu, gioiTinhKySu, diachiKySu, nganhDaoTao);
			canBoArr = Arrays.copyOf(canBoArr, canBoArr.length + 1); // tăng độ dài cho mảng (tăng 1 phần tử)
			canBoArr[canBoArr.length - 1] = kysuAdd;

			System.out.println("\n Đã thêm kỹ sư sau: ");
			System.out.println(canBoArr[canBoArr.length - 1]);
			break;
		case 2:
			String[] congNhanInfo = getCanboInfo("công nhân");
			String tenCongNhan = congNhanInfo[0];
			Byte tuoiCongNhan = Byte.valueOf(congNhanInfo[1]);
			String gioiTinhCongNhan = congNhanInfo[2];
			String diachiCongNhan = congNhanInfo[3];

			// Lấy bậc công nhân
			System.out.println("Nhập bậc của công nhân (1 đến 10)");
			byte bacCongNhan = sc.nextByte();

			// Thêm cán bộ
			CanBo congNhanAdd = new CongNhan(tenCongNhan, tuoiCongNhan, gioiTinhCongNhan, diachiCongNhan, bacCongNhan);
			canBoArr = Arrays.copyOf(canBoArr, canBoArr.length + 1); // tăng độ dài cho mảng (tăng 1 phần tử)
			canBoArr[canBoArr.length - 1] = congNhanAdd;

			System.out.println("\n Đã thêm công nhân sau: ");
			System.out.println(canBoArr[canBoArr.length - 1]);
			break;
		case 3:
			String[] nhanVienInfo = getCanboInfo("nhân viên");
			String tenNhanVien = nhanVienInfo[0];
			Byte tuoiNhanVien = Byte.valueOf(nhanVienInfo[1]);
			String gioiTinhNhanVien = nhanVienInfo[2];
			String diachiNhanVien = nhanVienInfo[3];

			// Lấy công việc của nhân viên
			System.out.println("Nhập công việc của nhân viên");
			sc.nextLine();
			String congViecNhanVien = sc.nextLine();

			// Thêm cán bộ
			CanBo nhanVienAdd = new NhanVien(tenNhanVien, tuoiNhanVien, gioiTinhNhanVien, diachiNhanVien,
					congViecNhanVien);
			canBoArr = Arrays.copyOf(canBoArr, canBoArr.length + 1); // tăng độ dài cho mảng (tăng 1 phần tử)
			canBoArr[canBoArr.length - 1] = nhanVienAdd;

			System.out.println("\n Đã thêm nhân viên sau: ");
			System.out.println(canBoArr[canBoArr.length - 1]);
			break;
		default:
			break;
		}
	}

	private void timKiemTheoHoTen() {
		sc.nextLine();
		CanBo[] ketquaTim = new CanBo[] {};
		boolean checkFlg = false;
		System.out.println("Nhập tên cán bộ cần tìm kiếm: ");
		String tenCanBo = sc.nextLine();
		for(CanBo canbo :canBoArr) {
			if(tenCanBo.equals(canbo.getHoTen())) {
				ketquaTim = Arrays.copyOf(ketquaTim, ketquaTim.length + 1);
				ketquaTim[ketquaTim.length - 1] = canbo;
				checkFlg = true;
			}
		}
		if(checkFlg) {
			System.out.println("\nKết quả tìm kiếm: ");
			for(CanBo ketqua : ketquaTim) {
				System.out.println(ketqua);
			}
		}else {
			System.out.println("\nKết quả tìm kiếm: không có cán bộ nào có tên như vậy.");
		}
	}

	private void hienThiThongTin() {
		if(canBoArr.length > 0) {
			System.out.println("Danh sách thông tin cán bộ: ");
			for(CanBo canbo :canBoArr) {
				System.out.println(canbo);
			}
		}else {
			System.out.println("Không có cán bộ nào");
		}
	}

	private void xoaCanBo() {
		sc.nextLine();
		boolean checkFlg = false;
		System.out.println("Nhập tên cán bộ cần tìm kiếm: ");
		String tenCanBo = sc.nextLine();
		int[] idxArr = new int[] {};
		for(int i = 0; i < canBoArr.length; i++) {
			if(tenCanBo.equals(canBoArr[i].getHoTen())) {
				idxArr = ArrayUtils.add(idxArr, i);
				checkFlg = true;
			}
		}
		if(checkFlg) {
			// xóa cán bộ
			canBoArr = ArrayUtils.removeAll(canBoArr, idxArr);
			System.out.println("\nDanh sách cán bộ sau khi xóa: ");
			for(CanBo canbo : canBoArr) {
				System.out.println(canbo);
			}
		}else {
			System.out.println("\nKết quả tìm kiếm: không có cán bộ nào có tên như vậy.");
		}
	}

	private String[] getCanboInfo(String bac) {
		String[] infoArr = new String[4];
		sc.nextLine();
		// Lấy tên
		System.out.println("Nhập tên " + bac);
		String ten = sc.nextLine();

		// Lấy tuổi
		System.out.println("Nhập tuổi " + bac);
		Byte tuoi = sc.nextByte();

		// Lấy giới tính
		System.out.println("Nhập vào giới tính của " + bac + ". 1: Nam, 2: Nữ, 3: Khác");
		int gioiTinhNum = sc.nextInt();
		String gioitinh = "";
		switch (gioiTinhNum) {
		case 1:
			gioitinh = GioiTinh.GIOI_TINH_NAM.getGioiTinh();
			break;
		case 2:
			gioitinh = GioiTinh.GIOI_TINH_NU.getGioiTinh();
			break;
		case 3:
			gioitinh = GioiTinh.GIOI_TINH_KHAC.getGioiTinh();
			break;
		}
		sc.nextLine();

		// Lấy địa chỉ
		System.out.println("Nhập địa chỉ của " + bac);

		String diachi = sc.nextLine();
		infoArr[0] = ten;
		infoArr[1] = tuoi.toString();
		infoArr[2] = gioitinh;
		infoArr[3] = diachi;

		return infoArr;
	}
}
