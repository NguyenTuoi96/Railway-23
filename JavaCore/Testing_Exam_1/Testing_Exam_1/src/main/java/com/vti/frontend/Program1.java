package com.vti.frontend;

import java.util.Scanner;

import com.vti.ConstantPack;
import com.vti.Utils.ScannerUtils;
import com.vti.backend.PresentationLayer.UserController;
import com.vti.entity.User;

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
	 * This method is demo function user
	 * 
	 * @Description:
	 * @author: NTTuoi
	 * @create_date: Dec 28, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 28, 2021
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		UserController userController = new UserController();
		new ScannerUtils(new Scanner(System.in));

		while (true) {
			System.out.println("Lựa chọn chức năng");
			System.out.println("1. In ra thông tin id và fullName, Email của tất cả User");
			System.out.println("2. Tìm user theo id");
			System.out.println("3. Xóa user theo id");
			System.out.println("4. Login");
			System.out.println("5. Thoát chương trình");
			int selectNum = ScannerUtils.inputInt("Bạn nhập sai, hãy nhập 1 giá trị số");
			switch (selectNum) {
			case 1:
				// In ra thông tin id và fullName, Email của tất cả User
				userController.getListUsers();
				break;
			case 2:
				// Tìm user theo id
				System.out.println(ConstantPack.INFO_INPUT_ID);
				int userId = ScannerUtils.inputInt(ConstantPack.ERROR_INPUT_NUMBER);
				User user = userController.getUsersById(userId);
				if (user != null) {
					System.out.println(user);
				}
				break;
			case 3:
				// Xóa user theo id
				System.out.println(ConstantPack.INFO_INPUT_ID);
				int userIdDel = ScannerUtils.inputInt(ConstantPack.ERROR_INPUT_NUMBER);
				userController.deleteUser(userIdDel);
				break;
			case 4:
				// Login
				System.out.println(ConstantPack.INFO_INPUT_EMAIL);
				String emailLogin = ScannerUtils.inputString();
				System.out.println(ConstantPack.INFO_INPUT_PASSWORD);
				String passLogin = ScannerUtils.inputString();
				User userLogin = userController.loggin(emailLogin, passLogin);
				if (userLogin != null && userLogin.getUserType() == ConstantPack.CONSTANT_USER_TYPE_ADMIN) {
					System.out.println(ConstantPack.CONFIRM_LOGIN_SUCCESS_ADMIN);
					boolean isContinue = false;
					int cnt = 0;
					while (isContinue == false) {
						String confirmMsg = cnt == 0 ? ConstantPack.CONFIRM_YES_OR_NO : ConstantPack.CONFIRM_CONTINUE;
						System.out.println(confirmMsg);
						int yOrN = ScannerUtils.inputYesOrNo(ConstantPack.ERROR_INPUT_NUMBER_FOR_YN);
						if (yOrN == 1) {
							System.out.println(ConstantPack.INFO_INPUT_FULLNAME);
							String newFullname = ScannerUtils.inputString();
							System.out.println(ConstantPack.INFO_INPUT_EMAIL);
							String newEmail = ScannerUtils.inputString();
							userController.createUser(newFullname, newEmail);
						} else {
							isContinue = true;
						}
						cnt++;
					}
				}
				break;
			case 5:
				// Thoát chương trình
				userController.disConnect();
				return;
			default:
				System.out.println("Lựa chọn đúng số trên menu");
				break;
			}
		}
	}

}
