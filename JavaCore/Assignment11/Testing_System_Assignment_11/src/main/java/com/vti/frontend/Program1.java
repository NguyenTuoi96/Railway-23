package com.vti.frontend;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.ConstantPack;
import com.vti.Utils.JdbcUtils;
import com.vti.Utils.MapUtils;
import com.vti.Utils.ScannerUtils;
import com.vti.backend.PresentationLayer.AccountController;
import com.vti.entity.Account;

/**
 * This class is
 * 
 * @Description:
 * @author: NTTuoi
 * @create_date: Dec 26, 2021
 * @version: 1.0
 * @modifer: NTTuoi
 * @modifer_date: Dec 26, 2021
 */
public class Program1 {

	/**
	 * This method is demo function account
	 * 
	 * @Description:
	 * @author: NTTuoi
	 * @create_date: Dec 26, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 26, 2021
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AccountController accountController = new AccountController();
		new ScannerUtils(new Scanner(System.in));

		while (true) {
			System.out.println("Lựa chọn chức năng");
			System.out.println("1. Hiển thị tất cả account");
			System.out.println("2. Tìm account theo id");
			System.out.println("3. Tạo account");
			System.out.println("4. Sửa thông tin account");
			System.out.println("5. Xóa account theo id");
			System.out.println("6. Thoát chương trình");
			int selectNum = ScannerUtils.inputInt("Bạn nhập sai, hãy nhập 1 giá trị số");
			switch (selectNum) {
			case 1:
				// Hiển thị tất cả account
				List<Account> accountList = new ArrayList<Account>();
				accountList = accountController.getListAccounts();
				for (Account account : accountList) {
					System.out.println(account);
				}
				break;
			case 2:
				// Tìm account theo id
				System.out.println(ConstantPack.INFO_INPUT_ID);
				int accountId = ScannerUtils.inputInt(ConstantPack.ERROR_INPUT_NUMBER);
				Account account = accountController.getAccountsById(accountId);
				if (account != null) {
					System.out.println(account);
				}
				break;
			case 3:
				// Tạo account
				MapUtils<Integer, String> accountInfoItemForInsert = new MapUtils<Integer, String>();
				accountInfoItemForInsert = getAccountInfoInput(ConstantPack.CONSTANT_INSERT);
				accountController.createAccount(accountInfoItemForInsert.get(2).toString(),
						accountInfoItemForInsert.get(3).toString(), accountInfoItemForInsert.get(4).toString(),
						accountInfoItemForInsert.get(5).toString(),
						Integer.valueOf(accountInfoItemForInsert.get(6).toString()).byteValue(),
						Integer.valueOf(accountInfoItemForInsert.get(7).toString()).byteValue());
				break;
			case 4:
				// Sửa thông tin account
				MapUtils<Integer, String> accountInfoForUpdate = new MapUtils<Integer, String>();
				accountInfoForUpdate = getAccountInfoInput(ConstantPack.CONSTANT_UPDATE);
				accountController.updateAccount(Integer.valueOf(accountInfoForUpdate.get(1).toString()).intValue(),
						accountInfoForUpdate.get(2).toString(), accountInfoForUpdate.get(3).toString(),
						accountInfoForUpdate.get(4).toString(), accountInfoForUpdate.get(5).toString(),
						Integer.valueOf(accountInfoForUpdate.get(6).toString()).byteValue(),
						Integer.valueOf(accountInfoForUpdate.get(7).toString()).byteValue());
				break;
			case 5:
				// Xóa account theo id
				MapUtils<Integer, String> accountInfoForDelete = new MapUtils<Integer, String>();
				accountInfoForDelete = getAccountInfoInput(ConstantPack.CONSTANT_DELETE);
				accountController.deleteAccount(Integer.valueOf(accountInfoForDelete.get(1).toString()).intValue());
				break;
			case 6:
				// Thoát chương trình
				System.out.println("Bye");
				try {
					JdbcUtils.disconnect();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
				return;
			default:
				System.out.println("Lựa chọn đúng số trên menu");
				break;
			}
		}
	}

	/**
	 * This method is get account item infomation
	 * 
	 * @Description: 
	 * @author: NTTuoi
	 * @create_date: Dec 28, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 28, 2021
	 * @param processNum
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static MapUtils<Integer, String> getAccountInfoInput(int processNum) {
		MapUtils<Integer, String> accountInfoItemMap = new MapUtils<Integer, String>();

		if (ConstantPack.CONSTANT_UPDATE == processNum || ConstantPack.CONSTANT_DELETE == processNum) {
			// id
			System.out.println(ConstantPack.INFO_INPUT_ID);
			int accountId = ScannerUtils.inputInt(ConstantPack.ERROR_INPUT_NUMBER);
			accountInfoItemMap.put(1, String.valueOf(accountId));
		}

		if (ConstantPack.CONSTANT_UPDATE == processNum || ConstantPack.CONSTANT_INSERT == processNum) {
			// email
			System.out.println(ConstantPack.INFO_INPUT_EMAIL);
			String email = ScannerUtils.inputString();
			accountInfoItemMap.put(2, email);

			// username
			System.out.println(ConstantPack.INFO_INPUT_USERNAME);
			String username = ScannerUtils.inputString();
			accountInfoItemMap.put(3, username);

			// fullname
			System.out.println(ConstantPack.INFO_INPUT_FULLNAME);
			String fullName = ScannerUtils.inputString();
			accountInfoItemMap.put(4, fullName);

			// gender
			System.out.println(ConstantPack.INFO_INPUT_STRING_GENDER);
			String gender = ScannerUtils.inputStringGender(ConstantPack.ERROR_INPUT_STRING_GENDER);
			accountInfoItemMap.put(5, gender);

			// department id
			System.out.println(ConstantPack.INFO_INPUT_DEPARTMENT_ID);
			int departmentId = ScannerUtils.inputInt(ConstantPack.ERROR_INPUT_NUMBER);
			accountInfoItemMap.put(6, String.valueOf(departmentId));

			// position id
			System.out.println(ConstantPack.INFO_INPUT_POSITION_ID);
			int positionId = ScannerUtils.inputInt(ConstantPack.ERROR_INPUT_NUMBER);
			accountInfoItemMap.put(7, String.valueOf(positionId));
		}
		return accountInfoItemMap;
	}

}
