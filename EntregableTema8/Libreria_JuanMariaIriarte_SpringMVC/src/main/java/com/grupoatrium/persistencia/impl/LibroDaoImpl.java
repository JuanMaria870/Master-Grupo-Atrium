package com.grupoatrium.persistencia.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.grupoatrium.modelo.Libro;

public class LibroDaoImpl implements LibroDao{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@SuppressWarnings("unchecked")
	@Transactional
	public List<Libro> read(Libro libro) {
		Map<String, Object> params = new HashMap<String, Object>();

		Session session = sessionFactory.getCurrentSession();
		StringBuffer sql = new StringBuffer("FROM Libro l WHERE 0=0");

		if (libro.getId_libro() != null) {
			params.put("id_libro", libro.getId_libro());
			sql.append(" and id_libro=:id_libro");
		}

		if (libro.getIsbn() != null) {
			params.put("isbn", libro.getIsbn());
			sql.append(" and isbn=:isbn");
		}

		if (libro.getTitulo() != null) {
			params.put("titulo", "%"+libro.getTitulo()+"%");
			sql.append(" and titulo like :titulo");
		}

		if (libro.getPublicacion() != null) {
			params.put("publicacion", libro.getPublicacion());
			sql.append(" and publicacion=:publicacion");
		}

		if (libro.getPrecio() != null) {
			params.put("precio", libro.getPrecio());
			sql.append(" and precio=:precio");
		}

		if (libro.getDescripcion() != null) {
			params.put("descripcion", libro.getDescripcion());
			sql.append(" and descripcion=:descripcion");
		}

		TypedQuery<Libro> query = session.createQuery(sql.toString());

		for (Map.Entry<String, Object> entry : params.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			query.setParameter(key, value);
		}

		List<Libro> result = query.getResultList();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Libro> readAll() {
		Session session = sessionFactory.getCurrentSession();

		String sql = "FROM Libro l";
		List<Libro> result = session.createQuery(sql).list();

		return result;
	}

	@Transactional
	public boolean create(Libro libro) {
		Session session = sessionFactory.getCurrentSession();
		session.save(libro);
		session.flush();

		return true;
	}

	@Transactional
	public boolean update(Libro libro) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(libro);
		session.flush();

		return true;
	}

	@Transactional
	public boolean delete(Libro libro) {
		Libro lib = read(libro).get(0);
		Session session = sessionFactory.getCurrentSession();
		session.delete(lib);
		session.flush();

		return true;
	}

}
