package com.vti.repository;

import java.util.List;

import com.vti.entity.Device;

public interface IDeviceRepository {

	public List<Device> getAllDevices();

	public Device getDeviceByID(int id);

	public void createDevice(Device device);

}
