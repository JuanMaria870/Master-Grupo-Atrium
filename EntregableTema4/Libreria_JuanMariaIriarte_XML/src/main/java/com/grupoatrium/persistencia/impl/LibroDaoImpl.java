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
import com.grupoatrium.modelo.Editorial;
import com.grupoatrium.modelo.Libro;

public class LibroDaoImpl implements LibroDao, ApplicationContextAware {

	EditorialDao editorialDao;
	AutorDao autorDao;

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

		String sql = "SELECT MAX(id_libro) FROM libro";
		Integer result = namedParameterJdbcTemplate.queryForObject(sql, params, Integer.class);

		return result;
	}

	@Override
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public List<Libro> read(Libro libro) {
		Map<String, Object> params = new HashMap<String, Object>();

		StringBuffer sql = new StringBuffer("SELECT * FROM libro WHERE 0=0");

		if (libro.getId_libro() != null) {
			params.put("id_libro", libro.getId_libro());
			sql.append(" and id_libro=:id_libro");
		}

		if (libro.getIsbn() != null) {
			params.put("isbn", libro.getIsbn());
			sql.append(" and isbn=:isbn");
		}

		if (libro.getTitulo() != null) {
			params.put("titulo", libro.getTitulo());
			sql.append(" and titulo=:titulo");
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

		if (libro.getFk_editorial() != null) {
			params.put("fk_editorial", libro.getFk_editorial());
			sql.append(" and fk_editorial=:fk_editorial");
		}

		List<Libro> result = namedParameterJdbcTemplate.query(sql.toString(), params, new LibroMapper());

		editorialDao = context.getBean("editorialDao", EditorialDao.class);
		for (Libro lib : result) {
			lib.setEditorial(editorialDao.readEditorialByLibro(lib).get(0));
		}

		autorDao = context.getBean("autorDao", AutorDao.class);
		for (Libro lib : result) {
			lib.setAutores(autorDao.readAutoresByLibro(lib));
		}

		return result;
	}

	@Override
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public List<Libro> readLibrosByAutor(Autor autor) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id_autor", autor.getId_autor());

		StringBuffer sql = new StringBuffer(
				"SELECT L.* FROM libro L inner join autor_libro AL on L.id_libro=AL.fk_libro where AL.fk_autor=:id_autor");

		List<Libro> result = namedParameterJdbcTemplate.query(sql.toString(), params, new LibroMapper());

		editorialDao = context.getBean("editorialDao", EditorialDao.class);
		for (Libro libro : result) {
			libro.setEditorial(editorialDao.readEditorialByLibro(libro).get(0));
		}

		return result;
	}

	@Override
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public List<Libro> readLibrosByEditorial(Editorial editorial) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id_editorial", editorial.getId_editorial());

		StringBuffer sql = new StringBuffer("SELECT * FROM libro where fk_editorial=:id_editorial");

		List<Libro> result = namedParameterJdbcTemplate.query(sql.toString(), params, new LibroMapper());
		
		autorDao = context.getBean("autorDao", AutorDao.class);
		for (Libro lib : result) {
			lib.setAutores(autorDao.readAutoresByLibro(lib));
		}

		return result;
	}

	@Override
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public List<Libro> readAll() {
		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT * FROM libro";

		List<Libro> result = namedParameterJdbcTemplate.query(sql, params, new LibroMapper());

		editorialDao = context.getBean("editorialDao", EditorialDao.class);
		for (Libro libro : result) {
			libro.setEditorial(editorialDao.readEditorialByLibro(libro).get(0));
		}

		autorDao = context.getBean("autorDao", AutorDao.class);
		for (Libro lib : result) {
			lib.setAutores(autorDao.readAutoresByLibro(lib));
		}

		return result;
	}

	@Override
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public boolean create(Libro libro) {
		Map<String, Object> params = new HashMap<String, Object>();

		// Leemos el ID mas alto y le sumamos 1
		int id_libro = readMaxID() + 1;
		params.put("id_libro", id_libro);
		params.put("titulo", libro.getTitulo());
		params.put("isbn", libro.getIsbn());
		params.put("fk_editorial", libro.getFk_editorial());
		params.put("precio", libro.getPrecio());
		params.put("descripcion", libro.getDescripcion());
		params.put("publicacion", libro.getPublicacion());

		String sql = "INSERT INTO libro (id_libro, titulo, isbn, fk_editorial, precio, descripcion, publicacion) VALUES (:id_libro, :titulo, :isbn, :fk_editorial, :precio, :descripcion, :publicacion)";

		int result = namedParameterJdbcTemplate.update(sql, params);

		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public boolean update(Libro libro) {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_libro", libro.getId_libro());
		params.put("titulo", libro.getTitulo());
		params.put("isbn", libro.getIsbn());
		params.put("fk_editorial", libro.getFk_editorial());
		params.put("precio", libro.getPrecio());
		params.put("descripcion", libro.getDescripcion());
		params.put("publicacion", libro.getPublicacion());

		String sql = "UPDATE libro SET titulo=:titulo, isbn=:isbn, fk_editorial=:fk_editorial, precio=:precio, descripcion=:descripcion, publicacion=:publicacion WHERE id_libro=:id_libro";

		int result = namedParameterJdbcTemplate.update(sql, params);

		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public boolean delete(Libro libro) {
		// Primero eliminamos los autores linkados
		Map<String, Object> paramsLink = new HashMap<String, Object>();

		paramsLink.put("id_libror", libro.getId_libro());

		String sqlLink = "DELETE FROM autor_libro WHERE fk_libro=:id_libror";

		namedParameterJdbcTemplate.update(sqlLink, paramsLink);

		Map<String, Object> params = new HashMap<String, Object>();

		StringBuffer sql = new StringBuffer("DELETE FROM libro WHERE 0=0");

		if (libro.getId_libro() != null) {
			params.put("id_libro", libro.getId_libro());
			sql.append(" and id_libro=:id_libro");
		}

		if (libro.getIsbn() != null) {
			params.put("isbn", libro.getIsbn());
			sql.append(" and isbn=:isbn");
		}

		if (libro.getTitulo() != null) {
			params.put("titulo", libro.getTitulo());
			sql.append(" and titulo=:titulo");
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

		if (libro.getFk_editorial() != null) {
			params.put("fk_editorial", libro.getFk_editorial());
			sql.append(" and fk_editorial=:fk_editorial");
		}

		int result = namedParameterJdbcTemplate.update(sql.toString(), params);

		if (result > 0) {
			return true;
		}
		return false;
	}

	private static final class LibroMapper implements RowMapper<Libro> {

		public Libro mapRow(ResultSet rs, int rowNum) throws SQLException {
			Libro libro = new Libro();

			libro.setId_libro(rs.getInt("id_libro"));
			libro.setPublicacion(rs.getInt("publicacion"));
			libro.setIsbn(rs.getString("isbn"));
			libro.setTitulo(rs.getString("titulo"));
			libro.setDescripcion(rs.getString("descripcion"));
			libro.setPrecio(rs.getDouble("precio"));
			libro.setFk_editorial(rs.getInt("fk_editorial"));
			return libro;
		}
	}

}
