package com.vti.backend.PresentationLayer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vti.ConstantPack;
import com.vti.backend.BusinessLayer.IAccountService;
import com.vti.backend.BusinessLayer.IDepartmentService;
import com.vti.backend.BusinessLayer.IPositionService;
import com.vti.backend.BusinessLayer.Iplm.IplmAccountService;
import com.vti.backend.BusinessLayer.Iplm.IplmDepartmentService;
import com.vti.backend.BusinessLayer.Iplm.IplmPositionService;
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
public class AccountController {
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);
	IAccountService accountService;
	IDepartmentService departmentService;
	IPositionService positionService;

	public AccountController() {
		accountService = new IplmAccountService();
		departmentService = new IplmDepartmentService();
		positionService = new IplmPositionService();
	}

	public List<Account> getListAccounts() {
		List<Account> accList = new ArrayList<Account>();
		try {
			accList = accountService.getListAccounts();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
//		finally {
//			try {
//				JdbcUtils.disconnect();
//			} catch (SQLException e) {
//				System.out.println(e.getMessage());
//				e.printStackTrace();
//			}
//		}
		return accList;
	}

	public Account getAccountsById(int id) {
		Account account = null;
		try {
			account = accountService.getAccountsById(id);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return account;
	}

	/**
	 * This method is create account
	 * 
	 * @Description:
	 * @author: NTTuoi
	 * @create_date: Dec 27, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 27, 2021
	 * @param email
	 * @param userName
	 * @param fullName
	 * @param gender
	 * @param departmentId
	 * @param positionId
	 */
	public void createAccount(String email, String userName, String fullName, String gender, byte departmentId,
			byte positionId) {
		try {
			// check validate
			if (!checkValidate(email, userName, fullName)) {
				return;
			}

			// check error server
			if (!checkErrorServer(email, userName, departmentId, positionId)) {
				return;
			}

			// n???u kh??ng c?? l???i th?? th???c hi???n insert
			accountService.createAccount(email, userName, fullName, gender, departmentId, positionId);

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * This method is update account
	 * 
	 * @Description:
	 * @author: NTTuoi
	 * @create_date: Dec 27, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 27, 2021
	 * @param id
	 * @param email
	 * @param userName
	 * @param fullName
	 * @param gender
	 * @param departmentId
	 * @param positionId
	 */
	public void updateAccount(int id, String email, String userName, String fullName, String gender, byte departmentId,
			byte positionId) {
		try {
			// check id
			boolean isCheckIdExists = accountService.isAccountIdExists(id);
			if (!isCheckIdExists) {
				System.out.println(ConstantPack.ERROR_ID_NOT_FOUND);
				return;
			}

			// check validate
			if (!checkValidate(email, userName, fullName)) {
				return;
			}

			// check error server
			if (!checkErrorServer(email, userName, departmentId, positionId)) {
				return;
			}

			// n???u kh??ng c?? l???i th?? th???c hi???n update
			accountService.updateAccount(id, email, userName, fullName, gender, departmentId, positionId);

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * This method is delete account
	 * 
	 * @Description:
	 * @author: NTTuoi
	 * @create_date: Dec 27, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 27, 2021
	 * @param id
	 */
	public void deleteAccount(int id) {
		try {
			// check id
			boolean isCheckIdExists = accountService.isAccountIdExists(id);
			if (!isCheckIdExists) {
				System.out.println(ConstantPack.ERROR_ID_NOT_FOUND);
				return;
			}

			// n???u kh??ng c?? l???i th?? th???c hi???n delete
			accountService.deleteAccount(id);

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * This method is check validate
	 * 
	 * @Description:
	 * @author: NTTuoi
	 * @create_date: Dec 27, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 27, 2021
	 * @param email
	 * @param userName
	 * @param fullName
	 * @return has error: false / no error: true
	 */
	private boolean checkValidate(String email, String userName, String fullName) {
		List<String> errorList = new ArrayList<String>();
		// check validate email (xxx@gmail.com, maxlength = 50)
		Matcher matcherEmail = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
		if (email.length() > 50 || matcherEmail.find() == false) {
			errorList.add(ConstantPack.ERROR_EMAIL_NO_MATCH);
		}

		// check validate username(??t nh???t 8 k?? t???, kh??ng ch???a k?? t??? vi???t hoa, maxlength
		// = 20)
		boolean isUpperCaseUName = false;
		for (String uName : userName.split("")) {
			if (Pattern.matches("[A-Z]", uName)) {
				isUpperCaseUName = true;
				break;
			}
		}
		if (userName.length() < 8 || userName.length() > 20 || isUpperCaseUName == true) {
			errorList.add(ConstantPack.ERROR_USERNAME_NO_MATCH);
		}

		// check validate fullname (maxlength = 50)
		if (fullName.length() > 50) {
			errorList.add(ConstantPack.ERROR_FULLNAME_NO_MATCH);
		}

		// show error
		if (errorList.size() > 0) {
			showMessageError(errorList);
			return false;
		}
		return true;
	}

	/**
	 * This method is check error from server
	 * 
	 * @Description:
	 * @author: NTTuoi
	 * @create_date: Dec 27, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 27, 2021
	 * @param email
	 * @param userName
	 * @param fullName
	 * @return has error: false / no error: true
	 * @throws throws SQLException, ClassNotFoundException, Exception
	 */
	private boolean checkErrorServer(String email, String userName, byte departmentId, byte positionId)
			throws SQLException, ClassNotFoundException, Exception {
		List<String> errorList = new ArrayList<String>();
		// username ???? t???n t???i
		boolean isCheckNameExists = accountService.isAccountUserNameExists(userName);
		if (isCheckNameExists) {
			errorList.add(ConstantPack.ERROR_USERNAME_EXISTS);
		}

		// email ???? t???n t???i
		boolean isCheckEmailExists = accountService.isAccountEmailExists(email);
		if (isCheckEmailExists) {
			errorList.add(ConstantPack.ERROR_EMAIL_EXISTS);
		}

		// ki???m tra department id c?? t???n t???i kh??ng
		boolean isDepartmentIdExists = departmentService.isDepartmentIdExists(departmentId);
		if (isDepartmentIdExists == false) {
			errorList.add(ConstantPack.ERROR_DEPARTMENT_NOT_EXISTS);
		}

		// ki???m tra position id c?? t???n t???i kh??ng
		boolean isPositionIdExists = positionService.isPositionIdExists(positionId);
		if (isPositionIdExists == false) {
			errorList.add(ConstantPack.ERROR_POSITION_NOT_EXISTS);
		}

		// show error
		if (errorList.size() > 0) {
			showMessageError(errorList);
			return false;
		}
		return true;
	}

	/**
	 * This method is show message error
	 * 
	 * @Description: h??m in l???i
	 * @author: NTTuoi
	 * @create_date: Dec 27, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 27, 2021
	 * @param errorList
	 */
	private void showMessageError(List<String> errorList) {
		System.out.println(ConstantPack.ERROR_HAS_ERROR);
		for (String error : errorList) {
			System.out.println(error);
		}
	}
}
