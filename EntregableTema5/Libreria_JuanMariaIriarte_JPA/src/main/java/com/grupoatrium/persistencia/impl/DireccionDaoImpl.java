package com.grupoatrium.persistencia.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.eclipse.persistence.sessions.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grupoatrium.modelo.Direccion;

@Repository
public class DireccionDaoImpl implements DireccionDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public boolean create(Direccion direccion) {

		EntityManager entity = entityManagerFactory.createEntityManager();
		EntityTransaction et = entity.getTransaction();
		et.begin();
		entity.persist(direccion);
		et.commit();

		return true;
	}

	public List<Direccion> read(Direccion direccion) {

		EntityManager entity = entityManagerFactory.createEntityManager();
		Map<String, Object> params = new HashMap<String, Object>();

		StringBuffer sql = new StringBuffer("select d FROM Direccion d WHERE 0=0");

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

		Query query= entity.createQuery(sql.toString());

		for (Map.Entry<String, Object> entry : params.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			query.setParameter(key, value);
		}

		List<Direccion> result = query.getResultList();

		return result;
	}

	public List<Direccion> readAll() {

		EntityManager entity = entityManagerFactory.createEntityManager();

		String sql = "select d FROM Direccion d";
		List<Direccion> result = entity.createQuery(sql).getResultList();

		return result;

	}

	public boolean update(Direccion direccion) {

		EntityManager entity = entityManagerFactory.createEntityManager();
		EntityTransaction et = entity.getTransaction();
		et.begin();
		entity.merge(direccion);
		et.commit();

		return true;
	}

	public boolean delete(Direccion direccion) {

		Direccion dir = read(direccion).get(0);
		EntityManager entity = entityManagerFactory.createEntityManager();
		EntityTransaction et = entity.getTransaction();
		et.begin();
		entity.remove(dir);
		et.commit();

		return true;

	}
}
