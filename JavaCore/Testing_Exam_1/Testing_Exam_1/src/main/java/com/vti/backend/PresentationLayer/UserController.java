package com.vti.backend.PresentationLayer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mysql.cj.util.StringUtils;
import com.vti.ConstantPack;
import com.vti.Utils.JdbcUtils;
import com.vti.backend.BusinessLayer.IUserService;
import com.vti.backend.BusinessLayer.Iplm.IplmUserService;
import com.vti.entity.User;

/**
 * This class is User Controller
 * 
 * @Description:
 * @author: NTTuoi
 * @create_date: Dec 29, 2021
 * @version: 1.0
 * @modifer: NTTuoi
 * @modifer_date: Dec 29, 2021
 */
public class UserController {
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);
	private IUserService userService;

	public UserController() {
		userService = new IplmUserService();
	}

	/**
	 * This method is getListUsers
	 * 
	 * @Description:
	 * @author: NTTuoi
	 * @create_date: Dec 29, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 29, 2021
	 * @return
	 */
	public List<User> getListUsers() {
		List<User> userList = new ArrayList<User>();
		try {
			userList = userService.getListInfoUsers();
			if (userList.size() <= 0) {
				System.out.println(ConstantPack.ERROR_NO_DATA);
			} else {
				System.out.printf(
						"+------------+--------------------------------+----------------------------------------------------+%n");
				System.out.printf("| %-10s | %-30s | %-50s |%n", "id", "FullName", "Email");
				System.out.printf(
						"+------------+--------------------------------+----------------------------------------------------+%n");
				for (User user : userList) {
					System.out.printf("| %-10s | %-30s | %-50s |%n", user.getId(), user.getFullName(), user.getEmail());
				}
				System.out.printf(
						"+------------+--------------------------------+----------------------------------------------------+%n");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			disConnect();
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			disConnect();
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			disConnect();
			e.printStackTrace();
		}
		return userList;
	}

	/**
	 * This method is getUsersById
	 * 
	 * @Description:
	 * @author: NTTuoi
	 * @create_date: Dec 29, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 29, 2021
	 * @param id
	 * @return
	 */
	public User getUsersById(int id) {
		User user = null;
		try {
			user = userService.getUsersById(id);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			disConnect();
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			disConnect();
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			disConnect();
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * This method is loggin
	 * 
	 * @Description: 
	 * @author: NTTuoi
	 * @create_date: Dec 29, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 29, 2021
	 * @param email
	 * @param password
	 * @return User login
	 */
	public User loggin(String email, String password) {
		try {
			// check validate
			if (!checkValidate(email, password)) {
				return null;
			}

			// check error server
			User loginUser = getInfoUserLoggin(email, password);
			if (loginUser != null) {
				System.out.println(ConstantPack.INFO_LOGIN_SUCCESS);
				return loginUser;
			} else {
				System.out.println(ConstantPack.ERROR_EMAIL_OR_PASSWORD_NO_EXISTS);
				return null;
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			disConnect();
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			disConnect();
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			disConnect();
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * This method is create user
	 * 
	 * @Description:
	 * @author: NTTuoi
	 * @create_date: Dec 28, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 28, 2021
	 * @param email
	 * @param fullName
	 */
	public void createUser(String fullName, String email) {
		try {
			// check validate
			if (!checkValidate(email, null, fullName)) {
				return;
			}

			// check error server
			if (!StringUtils.isNullOrEmpty(email)) {
				// email đã tồn tại
				boolean isCheckEmailExists = userService.isUserEmailExists(email);
				if (isCheckEmailExists) {
					System.out.println(ConstantPack.ERROR_EMAIL_EXISTS);
					return;
				}
			}

			// nếu không có lỗi thì thực hiện insert
			userService.createUser(fullName, email);

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			disConnect();
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			disConnect();
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			disConnect();
			e.printStackTrace();
		}
	}

	/**
	 * This method is delete user
	 * 
	 * @Description:
	 * @author: NTTuoi
	 * @create_date: Dec 28, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 28, 2021
	 * @param id
	 */
	public void deleteUser(int id) {
		try {
			// check id
			boolean isCheckIdExists = userService.isUserIdExists(id);
			if (!isCheckIdExists) {
				System.out.println(ConstantPack.ERROR_ID_NOT_FOUND);
				return;
			}

			// nếu không có lỗi thì thực hiện delete
			userService.deleteUser(id);

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			disConnect();
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			disConnect();
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			disConnect();
			e.printStackTrace();
		}
	}

	/**
	 * This method is check validate
	 * 
	 * @Description:
	 * @author: NTTuoi
	 * @create_date: Dec 28, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 28, 2021
	 * @param email
	 * @param password
	 * @return has error: false / no error: true
	 */
	private boolean checkValidate(String email, String password) {
		List<String> errorList = new ArrayList<String>();
		if (!StringUtils.isNullOrEmpty(email)) {
			// check validate email (xxx@gmail.com, maxlength = 50)
			Matcher matcherEmail = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
			if (email.length() > 50 || matcherEmail.find() == false) {
				errorList.add(ConstantPack.ERROR_EMAIL_NO_MATCH);
			}
		}

		if (!StringUtils.isNullOrEmpty(password)) {
			// check validate password(6 tới 12 ký tự, có ít nhất 1 ký tự viết hoa)
			boolean isUpperCasePass = false;
			for (String pass : password.split("")) {
				if (Pattern.matches("[A-Z]", pass)) {
					isUpperCasePass = true;
					break;
				}
			}
			if (password.length() < 6 || password.length() > 12 || isUpperCasePass == false) {
				errorList.add(ConstantPack.ERROR_PASSWORD_NO_MATCH);
			}
		}

		// show error
		if (errorList.size() > 0) {
			showMessageError(errorList);
			return false;
		}
		return true;
	}

	/**
	 * This method is check validate
	 * 
	 * @Description:
	 * @author: NTTuoi
	 * @create_date: Dec 28, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 28, 2021
	 * @param email
	 * @param password
	 * @param fullName
	 * @return has error: false / no error: true
	 */
	private boolean checkValidate(String email, String password, String fullName) {
		List<String> errorList = new ArrayList<String>();
		if (!StringUtils.isNullOrEmpty(email)) {
			// check validate email (xxx@gmail.com, maxlength = 50)
			Matcher matcherEmail = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
			if (email.length() > 50 || matcherEmail.find() == false) {
				errorList.add(ConstantPack.ERROR_EMAIL_NO_MATCH);
			}
		}

		if (!StringUtils.isNullOrEmpty(password)) {
			// check validate password(6 tới 12 ký tự, có ít nhất 1 ký tự viết hoa)
			boolean isUpperCasePass = false;
			for (String pass : password.split("")) {
				if (Pattern.matches("[A-Z]", pass)) {
					isUpperCasePass = true;
					break;
				}
			}
			if (password.length() < 6 || password.length() > 12 || isUpperCasePass == false) {
				errorList.add(ConstantPack.ERROR_PASSWORD_NO_MATCH);
			}
		}

		if (!StringUtils.isNullOrEmpty(fullName)) {
			// check validate fullname (maxlength = 50)
			if (fullName.length() > 50 || isValidName(fullName) == false) {
				errorList.add(ConstantPack.ERROR_FULLNAME_NO_MATCH);
			}
		}

		// show error
		if (errorList.size() > 0) {
			showMessageError(errorList);
			return false;
		}
		return true;
	}

	/**
	 * This method is getInfoUserLoggin
	 * 
	 * @Description:
	 * @author: NTTuoi
	 * @create_date: Dec 28, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 28, 2021
	 * @param email
	 * @param password
	 * @return User
	 * @throws throws SQLException, ClassNotFoundException, Exception
	 */
	private User getInfoUserLoggin(String email, String password)
			throws SQLException, ClassNotFoundException, Exception {
		User user = null;

		if (!StringUtils.isNullOrEmpty(email) && !StringUtils.isNullOrEmpty(password)) {
			user = userService.getUsersByEmailAndPassWord(email, password);
		}

		return user;
	}

	/**
	 * This method is check fullname
	 * 
	 * @Description: check full name chỉ chứa chữ, không chứa bất kỳ kí tự đặc biệt nào
	 * @author: NTTuoi
	 * @create_date: Dec 29, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 29, 2021
	 * @param name
	 * @return
	 */
	private boolean isValidName(String name) {
		String specialCharacters = "!#$%&'()*+,-./:;<=>?@[]^_`{|}~0123456789";
		String str2[] = name.split("");
		int count = 0;
		for (int i = 0; i < str2.length; i++) {
			if (specialCharacters.contains(str2[i])) {
				count++;
			}
		}

		if (name != null && count == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method is show message error
	 * 
	 * @Description: hàm in lỗi
	 * @author: NTTuoi
	 * @create_date: Dec 28, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 28, 2021
	 * @param errorList
	 */
	private void showMessageError(List<String> errorList) {
		System.out.println(ConstantPack.ERROR_HAS_ERROR);
		for (String error : errorList) {
			System.out.println(error);
		}
	}

	/**
	 * This method is close jdbc
	 * 
	 * @Description: hàm đóng connect
	 * @author: NTTuoi
	 * @create_date: Dec 28, 2021
	 * @version: 1.0
	 * @modifer: NTTuoi
	 * @modifer_date: Dec 28, 2021
	 * @param errorList
	 */
	public void disConnect() {
		try {
			System.out.println("Ngắt kết nối DB");
			JdbcUtils.disconnect();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
