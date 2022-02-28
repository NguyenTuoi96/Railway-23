package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.UserDTO;
import com.vti.entity.User;
import com.vti.service.IUserService;

@RestController
@RequestMapping(value = "api/v1/users")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UserController {

	@Autowired
	private IUserService service;

	// Đăng kí tài khoản cho nhân viên
//	{
//	    "fullName": "nguyen van anh",
//	    "email": "nguyenvanah@gmail.com",
//	    "phone": "08039062491",
//	    "password": "nguyenAnh"
//	}
	@PostMapping()
	public void createUser(@RequestBody User User) {
		service.createUser(User);
	}

	// Đăng nhập
	@GetMapping(value = "/login/")
	public UserDTO getUserByEmailPassword(String email, String password) {
		return service.getUserByEmailPassword(email, password);
	}

	// lấy danh sách thiết bị của nguyen van an
	// http://localhost:8080/api/v1/devices/devicesbyusername
	@GetMapping(value = "/devices")
	public List<String> getAllDevicesForUserName(String userFullName, String monthYear) {
		return service.getListDevicesForUserName(userFullName, monthYear);
	}
}
