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

import com.grupoatrium.modelo.Autor;
import com.grupoatrium.modelo.Direccion;
import com.grupoatrium.modelo.Libro;

public class AutorDaoImpl implements AutorDao, ApplicationContextAware {

	DireccionDao direccionDao;
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

		String sql = "SELECT MAX(id_autor) FROM autor";
		Integer result = namedParameterJdbcTemplate.queryForObject(sql, params, Integer.class);

		return result;
	}

	@Override
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public List<Autor> read(Autor autor) {
		Map<String, Object> params = new HashMap<String, Object>();

		StringBuffer sql = new StringBuffer("SELECT * FROM autor WHERE 0=0");

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

		if (autor.getFk_direccion() != null) {
			params.put("bibliografia", autor.getBibliografia());
			sql.append(" and bibliografia=:bibliografia");
		}

		List<Autor> result = namedParameterJdbcTemplate.query(sql.toString(), params, new AutorMapper());

		direccionDao = context.getBean("direccionDao", DireccionDao.class);
		for (Autor aut : result) {
			aut.setDireccion(
					direccionDao.read(new Direccion(aut.getFk_direccion(), null, null, null, null, null)).get(0));
		}

		libroDao = context.getBean("libroDao", LibroDao.class);
		for (Autor aut : result) {
			aut.setLibros(libroDao.readLibrosByAutor(aut));
		}

		return result;
	}

	@Override
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public List<Autor> readAll() {
		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT * FROM autor";

		List<Autor> result = namedParameterJdbcTemplate.query(sql, params, new AutorMapper());

		direccionDao = context.getBean("direccionDao", DireccionDao.class);
		for (Autor autor : result) {
			autor.setDireccion(
					direccionDao.read(new Direccion(autor.getFk_direccion(), null, null, null, null, null)).get(0));
		}

		libroDao = context.getBean("libroDao", LibroDao.class);
		for (Autor aut : result) {
			aut.setLibros(libroDao.readLibrosByAutor(aut));
		}

		return result;
	}

	@Override
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public boolean create(Autor autor) {
		Map<String, Object> params = new HashMap<String, Object>();

		// Leemos el ID mas alto y le sumamos 1
		int id_autor = readMaxID() + 1;
		params.put("id_autor", id_autor);
		params.put("nombre", autor.getNombre());
		params.put("nacionalidad", autor.getNacionalidad());
		params.put("bibliografia", autor.getBibliografia());
		params.put("fk_direccion", autor.getFk_direccion());

		String sql = "INSERT INTO autor (id_autor, nombre, nacionalidad, bibliografia, fk_direccion) VALUES (:id_autor, :nombre, :nacionalidad, :bibliografia, :fk_direccion)";

		int result = namedParameterJdbcTemplate.update(sql, params);

		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public boolean linkarLibroAutor(Autor autor, Libro libro) {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_autor", autor.getId_autor());
		params.put("id_libro", libro.getId_libro());

		String sql = "INSERT INTO autor_libro (fk_autor, fk_libro) VALUES (:id_autor, :id_libro)";

		int result = namedParameterJdbcTemplate.update(sql, params);

		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public boolean update(Autor autor) {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_autor", autor.getId_autor());
		params.put("nombre", autor.getNombre());
		params.put("nacionalidad", autor.getNacionalidad());
		params.put("bibliografia", autor.getBibliografia());
		params.put("fk_direccion", autor.getFk_direccion());

		String sql = "UPDATE autor SET nombre=:nombre, nacionalidad=:nacionalidad, bibliografia=:bibliografia, fk_direccion=:fk_direccion WHERE id_autor=:id_autor";

		int result = namedParameterJdbcTemplate.update(sql, params);

		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public boolean delete(Autor autor) {

		// Primero eliminamos los libros linkados
		Map<String, Object> paramsLink = new HashMap<String, Object>();

		paramsLink.put("id_autor", autor.getId_autor());

		String sqlLink = "DELETE FROM autor_libro WHERE fk_autor=:id_autor";

		namedParameterJdbcTemplate.update(sqlLink, paramsLink);

		Map<String, Object> params = new HashMap<String, Object>();

		StringBuffer sql = new StringBuffer("DELETE FROM autor WHERE 0=0");

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

		if (autor.getFk_direccion() != null) {
			params.put("bibliografia", autor.getBibliografia());
			sql.append(" and bibliografia=:bibliografia");
		}

		int result = namedParameterJdbcTemplate.update(sql.toString(), params);

		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public List<Autor> readAutoresByLibro(Libro libro) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id_libro", libro.getId_libro());

		StringBuffer sql = new StringBuffer(
				"SELECT A.* FROM autor A inner join autor_libro AL on A.id_autor=AL.fk_autor where AL.fk_libro=:id_libro");

		List<Autor> result = namedParameterJdbcTemplate.query(sql.toString(), params, new AutorMapper());

		direccionDao = context.getBean("direccionDao", DireccionDao.class);
		for (Autor autor : result) {
			autor.setDireccion(
					direccionDao.read(new Direccion(autor.getFk_direccion(), null, null, null, null, null)).get(0));
		}

		return result;
	}

	private static final class AutorMapper implements RowMapper<Autor> {

		public Autor mapRow(ResultSet rs, int rowNum) throws SQLException {
			Autor autor = new Autor();
			autor.setId_autor(rs.getInt("id_autor"));
			autor.setNombre(rs.getString("nombre"));
			autor.setNacionalidad(rs.getString("nacionalidad"));
			autor.setBibliografia(rs.getString("bibliografia"));
			autor.setFk_direccion(rs.getInt("fk_direccion"));
			return autor;
		}
	}

}
