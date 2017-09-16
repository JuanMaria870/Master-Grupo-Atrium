package com.grupoatrium.persistencia.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grupoatrium.modelo.Direccion;

@Repository
public class DireccionDaoImpl implements DireccionDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean create(Direccion direccion) {

		Session session = sessionFactory.getCurrentSession();
		session.save(direccion);
		session.flush();

		return true;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Direccion> read(Direccion direccion) {

		Session session = sessionFactory.getCurrentSession();
		Map<String, Object> params = new HashMap<String, Object>();

		StringBuffer sql = new StringBuffer("FROM Direccion d WHERE 0=0");

		if (direccion.getId_direccion() != null) {
			params.put("id_direccion", direccion.getId_direccion());
			sql.append(" and d.id_direccion=:id_direccion");
		}

		if (direccion.getCalle() != null) {
			params.put("calle", direccion.getCalle());
			sql.append(" and d.calle=:calle");
		}

		if (direccion.getPoblacion() != null) {
			params.put("poblacion", direccion.getPoblacion());
			sql.append(" and d.poblacion=:poblacion");
		}

		if (direccion.getProvincia() != null) {
			params.put("provincia", direccion.getProvincia());
			sql.append(" and d.provincia=:provincia");
		}

		if (direccion.getCp() != null) {
			params.put("cp", direccion.getCp());
			sql.append(" and d.cp=:cp");
		}

		if (direccion.getNumero() != null) {
			params.put("numero", direccion.getNumero());
			sql.append(" and d.numero=:numero");
		}

		TypedQuery<Direccion> query = session.createQuery(sql.toString());

		for (Map.Entry<String, Object> entry : params.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			query.setParameter(key, value);
		}

		List<Direccion> result = query.getResultList();

		return result;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Direccion> readAll() {

		Session session = sessionFactory.getCurrentSession();

		String sql = "FROM Direccion d";
		List<Direccion> result = session.createQuery(sql).list();

		return result;

	}

	@Transactional
	public boolean update(Direccion direccion) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(direccion);
		session.flush();

		return true;
	}

	@Transactional
	public boolean delete(Direccion direccion) {

		Direccion dir = read(direccion).get(0);
		Session session = sessionFactory.getCurrentSession();
		session.delete(dir);
		session.flush();

		return true;

	}
}
