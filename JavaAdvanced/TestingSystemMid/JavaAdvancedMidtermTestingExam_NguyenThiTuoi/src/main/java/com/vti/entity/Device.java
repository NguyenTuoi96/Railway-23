package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "device")
public class Device implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "device_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deviceId;

	@Column(name = "device_name", length = 50, nullable = false, unique = true)
	private String deviceName;
	
	@Column(name = "quantity")
	private int quantity;
	
	@OneToMany(mappedBy = "device")
	@JsonIgnoreProperties("device")
	private List<UserDevice> userDeviceList;

	public Device() {
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<UserDevice> getUserDeviceList() {
		return userDeviceList;
	}

	public void setUserDeviceList(List<UserDevice> userDeviceList) {
		this.userDeviceList = userDeviceList;
	}

	@Override
	public String toString() {
		return "Device [deviceId=" + deviceId + ", deviceName=" + deviceName + ", quantity=" + quantity
				+ ", userDeviceList=" + userDeviceList + "]";
	}	
	
}
