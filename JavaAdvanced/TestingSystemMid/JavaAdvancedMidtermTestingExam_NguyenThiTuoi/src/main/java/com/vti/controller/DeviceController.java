package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Device;
import com.vti.service.IDeviceService;

@RestController
@RequestMapping(value = "api/v1/devices")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class DeviceController {

	@Autowired
	private IDeviceService service;

	// Lấy danh sách thông tin thiết bị
	@GetMapping()
	public List<Device> getAllDevices() {
		return service.getAllDevices();
	}

	// Thêm mới thiết bị
//	{
//        "deviceName": "iphone 12",
//        "quantity": 5
//	}
	@PostMapping()
	public void createDevice(@RequestBody Device device) {
		service.createDevice(device);
	}
}
