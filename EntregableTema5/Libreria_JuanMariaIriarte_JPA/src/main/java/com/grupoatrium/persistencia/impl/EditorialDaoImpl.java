package com.grupoatrium.persistencia.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.grupoatrium.modelo.Editorial;

public class EditorialDaoImpl implements EditorialDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public List<Editorial> read(Editorial editorial) {
		EntityManager entity = entityManagerFactory.createEntityManager();
		StringBuffer sql = new StringBuffer("select e FROM Editorial e WHERE 0=0");

		if (editorial.getId_editorial() != null) {
			sql.append(" and e.id_editorial=").append( editorial.getId_editorial());
		}

		if (editorial.getNombre() != null) {
			sql.append(" and e.nombre='").append(editorial.getNombre()).append("'");
		}

		if (editorial.getNif_cif() != null) {
			sql.append(" and e.nif_cif='").append(editorial.getNif_cif()).append("'");
		}

		List<Editorial> result = entity.createQuery(sql.toString()).getResultList();

		return result;
	}

	public List<Editorial> readAll() {
		EntityManager entity = entityManagerFactory.createEntityManager();

		String sql = "select e FROM Editorial e";
		List<Editorial> result = entity.createQuery(sql).getResultList();

		return result;
	}

	@Transactional
	public boolean create(Editorial editorial) {
		EntityManager entity = entityManagerFactory.createEntityManager();
		EntityTransaction et = entity.getTransaction();
		et.begin();
		entity.persist(editorial);
		et.commit();

		return true;
	}

	public boolean update(Editorial editorial) {
		EntityManager entity = entityManagerFactory.createEntityManager();
		EntityTransaction et = entity.getTransaction();
		et.begin();
		entity.merge(editorial);
		et.commit();

		return true;
	}

	@Transactional
	public boolean delete(Editorial editorial) {
		Editorial edit = read(editorial).get(0);
		EntityManager entity = entityManagerFactory.createEntityManager();
		EntityTransaction et = entity.getTransaction();
		et.begin();
		if (!entity.contains(edit)) {
			edit = entity.merge(edit);
		}
		entity.remove(edit);
		et.commit();
		return true;
	}


}
