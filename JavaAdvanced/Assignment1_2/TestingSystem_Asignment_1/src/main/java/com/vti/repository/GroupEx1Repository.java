package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.GroupEx1;
import com.vti.utils.HibernateUtils;

public class GroupEx1Repository {

	private HibernateUtils hibernateUtils;

	public GroupEx1Repository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	// a. createGroups()
	public void createGroups(GroupEx1 group) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(group);
			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// b. getAllGroups()
	@SuppressWarnings("unchecked")
	public List<GroupEx1> getAllGroups() {

		Session session = null;
		List<GroupEx1> list = new ArrayList<GroupEx1>();

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			list = (List<GroupEx1>) session.createQuery("FROM GroupEx1").list();

		} catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	// c. getGroupByID()
	public GroupEx1 getGroupByID(short id) {

		Session session = null;
		GroupEx1 group = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get group by id
			group = session.get(GroupEx1.class, id);

		} catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return group;
	}

	// d. getGroupByName()
	@SuppressWarnings("unchecked")
	public GroupEx1 getGroupByName(String name) {

		Session session = null;
		GroupEx1 group = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			Query<GroupEx1> query = session.createQuery("FROM GroupEx1 WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			group = query.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return group;
	}

	// e. updateGroup()
	public void updateGroup(short id, String newName) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get group
			GroupEx1 group = (GroupEx1) session.load(GroupEx1.class, id);

			// update
			group.setName(newName);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateGroup(GroupEx1 group) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(group);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// f. deleteGroup()
	public void deleteGroup(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get group
			GroupEx1 group = (GroupEx1) session.load(GroupEx1.class, id);

			// delete
			session.delete(group);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// g. isGroupExistsByID()
	public boolean isGroupExistsByID(short id) {

		// get group
		GroupEx1 group = getGroupByID(id);

		// return result
		if (group == null) {
			return false;
		}

		return true;
	}

	// h. isGroupExistsByName()
	public boolean isGroupExistsByName(String name) {
		GroupEx1 group = getGroupByName(name);

		if (group == null) {
			return false;
		}
		return true;
	}

}
