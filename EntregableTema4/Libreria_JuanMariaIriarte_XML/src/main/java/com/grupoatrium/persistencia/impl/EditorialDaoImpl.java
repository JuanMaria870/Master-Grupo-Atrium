package com.grupoatrium.persistencia.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.grupoatrium.modelo.Editorial;
import com.grupoatrium.modelo.Libro;

public class EditorialDaoImpl implements EditorialDao, ApplicationContextAware {

	LibroDao libroDao;

	private ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public Integer readMaxID() {
		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT MAX(id_editorial) FROM editorial";
		Integer result = namedParameterJdbcTemplate.queryForObject(sql, params, Integer.class);

		return result;
	}

	@Override
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public List<Editorial> read(Editorial editorial) {
		Map<String, Object> params = new HashMap<String, Object>();

		StringBuffer sql = new StringBuffer("SELECT * FROM editorial WHERE 0=0");

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

		List<Editorial> result = namedParameterJdbcTemplate.query(sql.toString(), params, new EditorialMapper());

		libroDao = context.getBean("libroDao", LibroDao.class);
		for (Editorial edit : result) {
			edit.setLibros(libroDao.readLibrosByEditorial(edit));
		}

		return result;
	}

	@Override
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public List<Editorial> readEditorialByLibro(Libro libro) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id_editorial", libro.getFk_editorial());

		StringBuffer sql = new StringBuffer("SELECT * FROM editorial where id_editorial=:id_editorial");

		List<Editorial> result = namedParameterJdbcTemplate.query(sql.toString(), params, new EditorialMapper());

		return result;
	}

	@Override
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public List<Editorial> readAll() {
		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT * FROM editorial";

		List<Editorial> result = namedParameterJdbcTemplate.query(sql, params, new EditorialMapper());

		libroDao = context.getBean("libroDao", LibroDao.class);
		for (Editorial edit : result) {
			edit.setLibros(libroDao.readLibrosByEditorial(edit));
		}

		return result;
	}

	@Override
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public boolean create(Editorial editorial) {
		Map<String, Object> params = new HashMap<String, Object>();

		// Leemos el ID mas alto y le sumamos 1
		int id_editorial = readMaxID() + 1;
		params.put("id_editorial", id_editorial);
		params.put("nombre", editorial.getNombre());
		params.put("nif_cif", editorial.getNif_cif());

		String sql = "INSERT INTO editorial (id_editorial, nombre, nif_cif) VALUES (:id_editorial, :nombre, :nif_cif)";

		int result = namedParameterJdbcTemplate.update(sql, params);

		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public boolean update(Editorial editorial) {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_editorial", editorial.getId_editorial());
		params.put("nombre", editorial.getNombre());
		params.put("nif_cif", editorial.getNif_cif());

		String sql = "UPDATE editorial SET nombre=:nombre, nif_cif=:nif_cif WHERE id_editorial=:id_editorial";

		int result = namedParameterJdbcTemplate.update(sql, params);

		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public boolean delete(Editorial editorial) {
		// Primero eliminamos la referencia de los libros linkados
		Libro libro = new Libro();
		libro.setFk_editorial(editorial.getId_editorial());
		
		libroDao = context.getBean("libroDao", LibroDao.class);
		List<Libro> librosEditorial = libroDao.read(libro);
		for (Libro lib : librosEditorial) {
			lib.setFk_editorial(null);
			lib.setEditorial(null);
			libroDao.update(lib);
		}

		Map<String, Object> params = new HashMap<String, Object>();

		StringBuffer sql = new StringBuffer("DELETE FROM editorial WHERE 0=0");

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

		int result = namedParameterJdbcTemplate.update(sql.toString(), params);

		if (result > 0) {
			return true;
		}
		return false;
	}

	private static final class EditorialMapper implements RowMapper<Editorial> {

		public Editorial mapRow(ResultSet rs, int rowNum) throws SQLException {
			Editorial editorial = new Editorial();

			editorial.setId_editorial(rs.getInt("id_editorial"));
			editorial.setNombre(rs.getString("nombre"));
			editorial.setNif_cif(rs.getString("nif_cif"));

			return editorial;
		}
	}

}
