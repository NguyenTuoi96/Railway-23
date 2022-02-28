package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Device;
import com.vti.repository.IDeviceRepository;

@Service
public class DeviceService implements IDeviceService {

	@Autowired
	private IDeviceRepository repository;

	public List<Device> getAllDevices() {
		return repository.getAllDevices();
	}

	public Device getDeviceByID(int id) {
		return repository.getDeviceByID(id);
	}
	
	public void createDevice(Device device) {
		repository.createDevice(device);
	}
}
