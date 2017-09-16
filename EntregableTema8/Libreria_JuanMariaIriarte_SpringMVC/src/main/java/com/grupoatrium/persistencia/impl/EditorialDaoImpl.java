package com.grupoatrium.persistencia.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.grupoatrium.modelo.Editorial;

public class EditorialDaoImpl implements EditorialDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional()
	public List<Editorial> read(Editorial editorial) {
		Map<String, Object> params = new HashMap<String, Object>();

		Session session = sessionFactory.getCurrentSession();
		StringBuffer sql = new StringBuffer("FROM Editorial e WHERE 0=0");

		if (editorial.getId_editorial() != null) {
			params.put("id_editorial", editorial.getId_editorial());
			sql.append(" and id_editorial=:id_editorial");
		}

		if (editorial.getNombre() != null) {
			params.put("nombre", editorial.getNombre());
			sql.append(" and nombre=:nombre");
		}

		if (editorial.getNif_cif() != null) {
			params.put("nif_cif", editorial.getNif_cif());
			sql.append(" and nif_cif=:nif_cif");
		}

		TypedQuery<Editorial> query = session.createQuery(sql.toString());

		for (Map.Entry<String, Object> entry : params.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			query.setParameter(key, value);
		}

		List<Editorial> result = query.getResultList();

		return result;
	}

	@SuppressWarnings("unchecked")
	@Transactional()
	public List<Editorial> readAll() {
		Session session = sessionFactory.getCurrentSession();

		String sql = "FROM Editorial e";
		List<Editorial> result = session.createQuery(sql).list();

		return result;
	}

	@Transactional
	public boolean create(Editorial editorial) {
		Session session = sessionFactory.getCurrentSession();
		session.save(editorial);
		session.flush();

		return true;
	}

	@Transactional
	public boolean update(Editorial editorial) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(editorial);
		session.flush();

		return true;
	}

	@Transactional
	public boolean delete(Editorial editorial) {
		Editorial edit = read(editorial).get(0);
		Session session = sessionFactory.getCurrentSession();
		session.delete(edit);
		session.flush();

		return true;
	}


}
