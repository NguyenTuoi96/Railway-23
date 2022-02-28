package com.vti.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.vti.entity.UserDevice;
import com.vti.utils.HibernateUtils;

@Repository
public class UserDeviceRepository implements IUserDeviceRepository {

	private HibernateUtils hibernateUtils;

	public UserDeviceRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	public void createUserDevice(UserDevice userDevice) {
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(userDevice);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}		
	}

}
