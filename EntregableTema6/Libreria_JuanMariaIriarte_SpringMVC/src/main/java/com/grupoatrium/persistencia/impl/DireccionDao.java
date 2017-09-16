package com.grupoatrium.persistencia.impl;

import java.util.List;

import com.grupoatrium.modelo.Direccion;

public interface DireccionDao {
	
	
	public List<Direccion> read(Direccion direccion);
	
	List<Direccion> readAll ();
	
	boolean create (Direccion direccion);
	
	boolean update (Direccion direccion);
	
	boolean delete (Direccion direccion);

}
