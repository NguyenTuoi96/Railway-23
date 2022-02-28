package com.vti.repository;

import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.vti.entity.User;
import com.vti.utils.HibernateUtils;

@Repository
public class UserRepository implements IUserRepository {

	private HibernateUtils hibernateUtils;

	public UserRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public User getUserByEmailPassword(String email, String password) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			
			String hql = "FROM User u WHERE email = :email AND password = :password ";

			// create hql query
			Query<User> query = session.createQuery(hql);
			
			query.setParameter("email", email);
			query.setParameter("password", password);
						
			return query.uniqueResult();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createUser(User User) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(User);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsersByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<User> query = session.createQuery("FROM User WHERE fullName = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			List<User> Users = query.list();

			return Users;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
