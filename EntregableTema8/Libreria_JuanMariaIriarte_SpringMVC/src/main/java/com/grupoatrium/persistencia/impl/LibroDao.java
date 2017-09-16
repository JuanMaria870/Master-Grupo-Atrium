package com.grupoatrium.persistencia.impl;

import java.util.List;

import com.grupoatrium.modelo.Libro;

public interface LibroDao {
		
	List<Libro> read(Libro libro);
	
	List<Libro> readAll ();
	
	boolean create (Libro libro);
	
	boolean update (Libro libro);
	
	boolean delete (Libro libro);
}
