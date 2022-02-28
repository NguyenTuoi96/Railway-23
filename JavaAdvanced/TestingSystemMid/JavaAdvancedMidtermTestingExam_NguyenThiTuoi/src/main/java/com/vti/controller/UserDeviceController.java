package com.vti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.UserDevice;
import com.vti.service.IUserDeviceService;

@RestController
@RequestMapping(value = "api/v1/userdevices")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UserDeviceController {

	@Autowired
	private IUserDeviceService service;

	// Đăng kí mượn thiết bị cho nhân viên
//    "id": {
//        "userId": 1,
//        "deviceId": 5
//    }   
	@PostMapping()
	public void createDevice(@RequestBody UserDevice userDevice) {
		service.createUserDevice(userDevice);
	}
}
