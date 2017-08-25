package com.grupoatrium.persistencia.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.grupoatrium.modelo.Direccion;

@Repository
public class DireccionDaoImpl implements DireccionDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public Integer readMaxID() {
		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT MAX(id_direccion) FROM direccion";
		Integer result = namedParameterJdbcTemplate.queryForObject(sql, params, Integer.class);

		return result;
	}

	@Override
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public List<Direccion> read(Direccion direccion) {
		Map<String, Object> params = new HashMap<String, Object>();

		StringBuffer sql = new StringBuffer("SELECT * FROM direccion WHERE 0=0");

		if (direccion.getId_direccion() != null) {
			params.put("id_direccion", direccion.getId_direccion());
			sql.append(" and id_direccion=:id_direccion");
		}

		if (direccion.getCalle() != null) {
			params.put("calle", direccion.getCalle());
			sql.append(" and calle=:calle");
		}

		if (direccion.getPoblacion() != null) {
			params.put("poblacion", direccion.getPoblacion());
			sql.append(" and poblacion=:poblacion");
		}

		if (direccion.getProvincia() != null) {
			params.put("provincia", direccion.getProvincia());
			sql.append(" and provincia=:provincia");
		}

		if (direccion.getCp() != null) {
			params.put("cp", direccion.getCp());
			sql.append(" and cp=:cp");
		}

		if (direccion.getNumero() != null) {
			params.put("numero", direccion.getNumero());
			sql.append(" and numero=:numero");
		}

		List<Direccion> result = namedParameterJdbcTemplate.query(sql.toString(), params, new DireccionMapper());

		return result;
	}

	@Override
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public List<Direccion> readAll() {
		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT * FROM direccion";

		List<Direccion> result = namedParameterJdbcTemplate.query(sql, params, new DireccionMapper());

		return result;
	}

	@Override
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public boolean create(Direccion direccion) {
		Map<String, Object> params = new HashMap<String, Object>();

		// Leemos el ID mas alto y le sumamos 1
		int id_direccion = readMaxID() + 1;
		params.put("id_direccion", id_direccion);
		params.put("calle", direccion.getCalle());
		params.put("poblacion", direccion.getPoblacion());
		params.put("provincia", direccion.getProvincia());
		params.put("cp", direccion.getCp());
		params.put("numero", direccion.getNumero());

		String sql = "INSERT INTO direccion (id_direccion, calle, poblacion, provincia, cp, numero) VALUES (:id_direccion, :calle, :poblacion, :provincia, :cp, :numero)";

		int result = namedParameterJdbcTemplate.update(sql, params);

		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public boolean update(Direccion direccion) {

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("id_direccion", direccion.getId_direccion());
		params.put("calle", direccion.getCalle());
		params.put("poblacion", direccion.getPoblacion());
		params.put("provincia", direccion.getProvincia());
		params.put("cp", direccion.getCp());
		params.put("numero", direccion.getNumero());

		String sql = "UPDATE direccion SET calle=:calle, poblacion=:poblacion, provincia=:provincia, cp=:cp, numero=:numero WHERE id_direccion=:id_direccion";

		int result = namedParameterJdbcTemplate.update(sql, params);

		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public boolean delete(Direccion direccion) {
		Map<String, Object> params = new HashMap<String, Object>();

		StringBuffer sql = new StringBuffer("DELETE FROM direccion WHERE 0=0");

		if (direccion.getId_direccion() != null) {
			params.put("id_direccion", direccion.getId_direccion());
			sql.append(" and id_direccion=:id_direccion");
		}

		if (direccion.getCalle() != null) {
			params.put("calle", direccion.getCalle());
			sql.append(" and calle=:calle");
		}

		if (direccion.getPoblacion() != null) {
			params.put("poblacion", direccion.getPoblacion());
			sql.append(" and poblacion=:poblacion");
		}

		if (direccion.getProvincia() != null) {
			params.put("provincia", direccion.getProvincia());
			sql.append(" and provincia=:provincia");
		}

		if (direccion.getCp() != null) {
			params.put("cp", direccion.getCp());
			sql.append(" and cp=:cp");
		}

		if (direccion.getNumero() != null) {
			params.put("numero", direccion.getNumero());
			sql.append(" and numero=:numero");
		}

		int result = namedParameterJdbcTemplate.update(sql.toString(), params);

		if (result > 0) {
			return true;
		}
		return false;
	}

	private static final class DireccionMapper implements RowMapper<Direccion> {

		public Direccion mapRow(ResultSet rs, int rowNum) throws SQLException {
			Direccion direccion = new Direccion();
			direccion.setId_direccion(rs.getInt("id_direccion"));
			direccion.setCalle(rs.getString("calle"));
			direccion.setPoblacion(rs.getString("poblacion"));
			direccion.setProvincia(rs.getString("provincia"));
			direccion.setCp(rs.getInt("cp"));
			direccion.setNumero(rs.getInt("numero"));
			return direccion;
		}
	}

}
