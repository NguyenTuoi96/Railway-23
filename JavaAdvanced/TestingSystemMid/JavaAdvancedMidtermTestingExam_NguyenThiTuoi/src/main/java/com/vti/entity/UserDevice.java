package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user_device")
public class UserDevice implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserDeviceKey id;

	@ManyToOne
	@MapsId("user_id")
	@JoinColumn(name = "user_id")
	@JsonIgnoreProperties("userDeviceList")
	private User user;

	@ManyToOne
	@MapsId("device_id")
	@JoinColumn(name = "device_id")
	@JsonIgnoreProperties("userDeviceList")
	private Device device;

	@Column(name = "borrow_date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date borrowDate;

	@Column(name = "repaid_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date repaidDate;

	public UserDevice() {
	}

	public UserDeviceKey getId() {
		return id;
	}

	public void setId(UserDeviceKey id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getRepaidDate() {
		return repaidDate;
	}

	public void setRepaidDate(Date repaidDate) {
		this.repaidDate = repaidDate;
	}

	@Embeddable
	public static class UserDeviceKey implements Serializable {

		private static final long serialVersionUID = 1L;

		@Column(name = "user_id", nullable = false)
		private int userId;

		@Column(name = "device_id", nullable = false)
		private int deviceId;

		public UserDeviceKey() {
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public int getDeviceId() {
			return deviceId;
		}

		public void setDeviceId(int deviceId) {
			this.deviceId = deviceId;
		}

		@Override
		public String toString() {
			return "UserDeviceKey [userId=" + userId + ", deviceId=" + deviceId + "]";
		}

	}
}
