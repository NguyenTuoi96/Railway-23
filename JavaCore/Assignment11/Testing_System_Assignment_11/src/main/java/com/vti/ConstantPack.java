package com.vti;

/**
 * This class is 
 * 
 * @Description: 
 * @author: NTTuoi
 * @create_date: Dec 27, 2021
 * @version: 1.0
 * @modifer: NTTuoi
 * @modifer_date: Dec 27, 2021
 */
public class ConstantPack {
	// error message
	public static final String ERROR_EMAIL_NO_MATCH = "Email không hợp lệ, hãy nhập email nhỏ hơn 50 kí tự và đúng định dạng (ví dụ: xxx@gmail.com)";
	public static final String ERROR_EMAIL_EXISTS = "Email đã tồn tại, hãy nhập lại email khác";
	public static final String ERROR_USERNAME_NO_MATCH = "Username không hợp lệ, hãy nhập username ít nhất 8 đến 20 ký tự, không chứa ký tự viết hoa";
	public static final String ERROR_USERNAME_EXISTS = "UserName đã tồn tại, hãy nhập lại username khác";
	public static final String ERROR_FULLNAME_NO_MATCH = "Fullname không hợp lệ, hãy nhập fullname nhỏ hơn 50 ký tự";
	public static final String ERROR_ID_NOT_FOUND = "Id không tồn tại";
	public static final String ERROR_ACCOUNT_NOT_FOUND = "Không tìm thấy tài khoản có id = ";
	public static final String ERROR_NO_DATA = "Không có dữ liệu";
	public static final String ERROR_HAS_ERROR = "Đã xảy ra lỗi, hãy kiểm tra lại";
	public static final String ERROR_DEPARTMENT_NOT_EXISTS = "Phòng ban bạn nhập vào không tồn tại trong hệ thống, hãy kiểm tra lại";
	public static final String ERROR_POSITION_NOT_EXISTS = "Vị trí bạn nhập vào không tồn tại trong hệ thống, hãy kiểm tra lại";
	public static final String ERROR_INPUT_NUMBER = "Bạn nhập sai, hãy nhập lại một giá trị số";
	public static final String ERROR_INPUT_STRING_GENDER = "Bạn nhập sai, hãy nhập đúng số (0: nam; 1: nữ; 2: chưa xác định)";
	
	// information message
	public static final String INFO_INSERT_SUCCESS = "Thực hiện thêm dữ liệu thành công! Đã thêm %s dòng\n";
	public static final String INFO_UPDATE_SUCCESS = "Thực hiện cập nhật dữ liệu thành công! Đã cập nhật %s dòng\n";
	public static final String INFO_DELETE_SUCCESS = "Thực hiện xóa dữ liệu thành công! Đã xóa %s dòng\n";
	public static final String INFO_INPUT_ID = "Hãy nhập vào id";
	public static final String INFO_INPUT_EMAIL = "Hãy nhập vào email";
	public static final String INFO_INPUT_USERNAME = "Hãy nhập vào username";
	public static final String INFO_INPUT_FULLNAME = "Hãy nhập vào fullname";
	public static final String INFO_INPUT_STRING_GENDER = "Nhập vào giới tính (0: nam; 1: nữ; 2: chưa xác định)";
	public static final String INFO_INPUT_DEPARTMENT_ID = "Nhập vào mã phòng ban";
	public static final String INFO_INPUT_POSITION_ID = "Nhập vào mã vị trí";
	
	// constant
	public static final int CONSTANT_INSERT = 1;
	public static final int CONSTANT_UPDATE = 2;
	public static final int CONSTANT_DELETE = 3;
	

}
