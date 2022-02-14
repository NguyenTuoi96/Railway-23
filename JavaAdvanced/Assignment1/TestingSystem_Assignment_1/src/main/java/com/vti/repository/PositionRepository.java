package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;
import com.vti.utils.HibernateUtils;

public class PositionRepository {

	private HibernateUtils hibernateUtils;

	public PositionRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Position> getAllDepartments() {

		Session session = null;
		List<Position> list = new ArrayList<Position>();

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			list = (List<Position>) session.createQuery("FROM position").list();

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

	public Position getPositionByID(short id) {

		Session session = null;
		Position position = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get position by id
			position = session.get(Position.class, id);

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
		return position;
	}

	@SuppressWarnings("unchecked")
	public Position getPositionByName(String name) {

		Session session = null;
		Position position = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create hql query
			Query<Position> query = session.createQuery("FROM Department WHERE position_name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			position = query.uniqueResult();

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
		return position;
	}

	public void createPosition(Position position) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(position);
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

	public void updatePosition(short id, PositionName newName) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get position
			Position position = (Position) session.load(Position.class, id);

			// update
			position.setPositionName(newName);

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

	public void updatePosition(Position position) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(position);
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

	public void deletePosition(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get position
			Position position = (Position) session.load(Position.class, id);

			// delete
			session.delete(position);
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

	public boolean isPositionExistsByID(short id) {

		// get position
		Position position = getPositionByID(id);

		// return result
		if (position == null) {
			return false;
		}

		return true;
	}

	public boolean isPositionExistsByName(String name) {
		Position position = getPositionByName(name);

		if (position == null) {
			return false;
		}
		return true;
	}

}
