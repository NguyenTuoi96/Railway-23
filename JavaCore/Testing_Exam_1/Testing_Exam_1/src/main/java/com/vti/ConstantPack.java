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
	public static final String ERROR_PASSWORD_NO_MATCH = "Password không hợp lệ, hãy nhập password có 6 đến 12 ký tự, có ít nhất 1 ký tự viết hoa";
	public static final String ERROR_FULLNAME_NO_MATCH = "Fullname không hợp lệ, hãy nhập fullname nhỏ hơn 50 ký tự và chỉ chứa chữ, không chứa bất kỳ kí tự đặc biệt nào";
	public static final String ERROR_EMAIL_OR_PASSWORD_NO_EXISTS = "Email hoặc password bị sai, hãy kiểm tra lại";
	public static final String ERROR_ID_NOT_FOUND = "Id không tồn tại";
	public static final String ERROR_USER_NOT_FOUND = "Không tìm thấy user có id = ";
	public static final String ERROR_NO_DATA = "Không có dữ liệu";
	public static final String ERROR_HAS_ERROR = "Đã xảy ra lỗi, hãy kiểm tra lại";
	public static final String ERROR_INPUT_NUMBER = "Bạn nhập sai, hãy nhập lại một giá trị số";
	public static final String ERROR_INPUT_NUMBER_FOR_YN = "Bạn nhập sai, hãy nhập 1 nếu có, nhập 2 nếu không muốn thực hiện";
	
	// information message
	public static final String INFO_INSERT_SUCCESS = "Thực hiện thêm dữ liệu thành công! Đã thêm %s dòng\n";
	public static final String INFO_UPDATE_SUCCESS = "Thực hiện cập nhật dữ liệu thành công! Đã cập nhật %s dòng\n";
	public static final String INFO_DELETE_SUCCESS = "Thực hiện xóa dữ liệu thành công! Đã xóa %s dòng\n";
	public static final String INFO_LOGIN_SUCCESS = "Login thành công!";
	public static final String INFO_INPUT_ID = "Hãy nhập vào id";
	public static final String INFO_INPUT_EMAIL = "Hãy nhập vào email";
	public static final String INFO_INPUT_FULLNAME = "Hãy nhập vào fullname";
	public static final String INFO_INPUT_PASSWORD = "Hãy nhập vào password";
	
	// constant
	public static final byte CONSTANT_USER_TYPE_UNKNOW = 0;
	public static final byte CONSTANT_USER_TYPE_ADMIN = 1;
	public static final byte CONSTANT_USER_TYPE_EMPLOYEE = 2;
	
	// confirm
	public static final String CONFIRM_LOGIN_SUCCESS_ADMIN = "Bạn là admin, có muốn thực hiện chức năng thêm employee không?";
	public static final String CONFIRM_YES_OR_NO = "nhập 1 nếu có, nhập 2 nếu không!";
	public static final String CONFIRM_CONTINUE = "Bạn có muốn tiếp tục thêm không? Nhập 1 nếu có, nhập 2 nếu không!";
	

}
