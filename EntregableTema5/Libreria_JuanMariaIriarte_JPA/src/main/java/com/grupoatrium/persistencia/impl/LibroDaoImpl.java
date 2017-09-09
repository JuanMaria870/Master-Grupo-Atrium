package com.grupoatrium.persistencia.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.grupoatrium.modelo.Libro;

public class LibroDaoImpl implements LibroDao{

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Transactional
	public List<Libro> read(Libro libro) {
		EntityManager entity = entityManagerFactory.createEntityManager();

		StringBuffer sql = new StringBuffer("select l FROM Libro l WHERE 0=0");

		if (libro.getId_libro() != null) {
			sql.append(" and l.id_libro=").append(libro.getId_libro());
		}

		if (libro.getIsbn() != null) {
			sql.append(" and l.isbn='").append(libro.getIsbn()).append("'");
		}

		if (libro.getTitulo() != null) {
			sql.append(" and l.titulo='").append(libro.getTitulo()).append("'");
		}

		if (libro.getPublicacion() != null) {
			sql.append(" and l.publicacion=").append(libro.getPublicacion());
		}

		if (libro.getPrecio() != null) {
			sql.append(" and l.precio=").append(libro.getPrecio());
		}

		if (libro.getDescripcion() != null) {
			sql.append(" and l.descripcion='").append(libro.getDescripcion()).append("'");
		}

		List<Libro> result = entity.createQuery(sql.toString()).getResultList();

		return result;
	}

	public List<Libro> readAll() {

		EntityManager entity = entityManagerFactory.createEntityManager();

		String sql = "select l FROM Libro l";
		List<Libro> result = entity.createQuery(sql).getResultList();

		return result;
	}

	public boolean create(Libro libro) {
		EntityManager entity = entityManagerFactory.createEntityManager();
		EntityTransaction et = entity.getTransaction();
		et.begin();
		entity.persist(libro);
		et.commit();

		return true;
	}

	public boolean update(Libro libro) {
		EntityManager entity = entityManagerFactory.createEntityManager();
		EntityTransaction et = entity.getTransaction();
		et.begin();
		entity.merge(libro);
		et.commit();

		return true;
	}

	public boolean delete(Libro libro) {
		Libro lib = read(libro).get(0);
		EntityManager entity = entityManagerFactory.createEntityManager();
		EntityTransaction et = entity.getTransaction();
		et.begin();
		if (!entity.contains(lib)) {
			lib = entity.merge(lib);
		}
		entity.remove(lib);
		et.commit();
		return true;
	}

}
