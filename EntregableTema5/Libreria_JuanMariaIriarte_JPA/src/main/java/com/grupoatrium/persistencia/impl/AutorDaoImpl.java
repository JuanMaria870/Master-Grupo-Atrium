package com.grupoatrium.persistencia.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.grupoatrium.modelo.Autor;

public class AutorDaoImpl implements AutorDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public List<Autor> read(Autor autor) {
		Map<String, Object> params = new HashMap<String, Object>();

		EntityManager entity = entityManagerFactory.createEntityManager();
		StringBuffer sql = new StringBuffer("Select a FROM Autor a WHERE 0=0");

		if (autor.getId_autor() != null) {
			sql.append(" and a.id_autor= ").append(autor.getId_autor());
		}

		if (autor.getNombre() != null) {
			params.put("nombre", autor.getNombre());
			sql.append(" and a.nombre=:nombre");
		}

		if (autor.getNacionalidad() != null) {
			params.put("nacionalidad", autor.getNacionalidad());
			sql.append(" and a.nacionalidad=:nacionalidad");
		}

        Query query = entity.createQuery(sql.toString());

		for (Map.Entry<String, Object> entry : params.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			query.setParameter(key, value);
		}

		List<Autor> result = query.getResultList();

		return result;
	}

	public List<Autor> readAll() {
		EntityManager entity = entityManagerFactory.createEntityManager();

		String sql = "select a FROM Autor a";
		List<Autor> result = entity.createQuery(sql).getResultList();

		return result;
	}

	public boolean create(Autor autor) {
		EntityManager entity = entityManagerFactory.createEntityManager();
		EntityTransaction et = entity.getTransaction();
		et.begin();
		entity.persist(autor);
		et.commit();

		return true;
	}

	public boolean update(Autor autor) {

		EntityManager entity = entityManagerFactory.createEntityManager();
		EntityTransaction et = entity.getTransaction();
		et.begin();
		entity.merge(autor);
		et.commit();

		return true;
	}

	public boolean delete(Autor autor) {
		
		Autor aut = read(autor).get(0);
		EntityManager entity = entityManagerFactory.createEntityManager();
		EntityTransaction et = entity.getTransaction();
		et.begin();
		if (!entity.contains(aut)) {
			aut = entity.merge(aut);
		}
		entity.remove(aut);
		et.commit();

		return true;
	}

}
