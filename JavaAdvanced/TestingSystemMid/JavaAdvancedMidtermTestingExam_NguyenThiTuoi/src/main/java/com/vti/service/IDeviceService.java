package com.vti.service;

import java.util.List;

import com.vti.entity.Device;

public interface IDeviceService {

	public List<Device> getAllDevices();

	public Device getDeviceByID(int id);

	public void createDevice(Device device);

}
