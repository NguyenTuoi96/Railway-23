package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.vti.entity.Device;
import com.vti.utils.HibernateUtils;

@Repository
public class DeviceRepository implements IDeviceRepository {

	private HibernateUtils hibernateUtils;

	public DeviceRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Device> getAllDevices() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Device> query = session.createQuery("FROM Device ORDER BY deviceId");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Device getDeviceByID(int id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get device by id
			Device device = session.get(Device.class, id);

			return device;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createDevice(Device device) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(device);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
