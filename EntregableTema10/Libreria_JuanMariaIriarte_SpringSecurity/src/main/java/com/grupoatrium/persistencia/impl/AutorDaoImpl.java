package com.grupoatrium.persistencia.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.grupoatrium.modelo.Autor;

public class AutorDaoImpl implements AutorDao {

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
	public List<Autor> read(Autor autor) {
		Map<String, Object> params = new HashMap<String, Object>();

		Session session = sessionFactory.getCurrentSession();
		StringBuffer sql = new StringBuffer("FROM Autor a WHERE 0=0");

		if (autor.getId_autor() != null) {
			params.put("id_autor", autor.getId_autor());
			sql.append(" and id_autor=:id_autor");
		}

		if (autor.getNombre() != null) {
			params.put("nombre", autor.getNombre());
			sql.append(" and nombre=:nombre");
		}

		if (autor.getNacionalidad() != null) {
			params.put("nacionalidad", autor.getNacionalidad());
			sql.append(" and nacionalidad=:nacionalidad");
		}

		TypedQuery<Autor> query = session.createQuery(sql.toString());

		for (Map.Entry<String, Object> entry : params.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			query.setParameter(key, value);
		}

		List<Autor> result = query.getResultList();

		return result;
	}

	@SuppressWarnings("unchecked")
	@Transactional()
	public List<Autor> readAll() {
		Session session = sessionFactory.getCurrentSession();

		String sql = "FROM Autor a";
		List<Autor> result = session.createQuery(sql).list();

		return result;
	}

	@Transactional()
	public boolean create(Autor autor) {
		Session session = sessionFactory.getCurrentSession();
		session.save(autor);
		session.flush();

		return true;
	}

	@Transactional()
	public boolean update(Autor autor) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(autor);
		session.flush();

		return true;
	}

	@Transactional()
	public boolean delete(Autor autor) {
		
		Autor aut = read(autor).get(0);
		Session session = sessionFactory.getCurrentSession();
		session.delete(aut);
		session.flush();

		return true;
	}

}
