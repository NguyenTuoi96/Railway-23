package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.UserDevice;
import com.vti.repository.IUserDeviceRepository;

@Service
public class UserDeviceService implements IUserDeviceService {

	@Autowired
	private IUserDeviceRepository repository;

	public void createUserDevice(UserDevice userDevice) {
		repository.createUserDevice(userDevice);;
	}
}
