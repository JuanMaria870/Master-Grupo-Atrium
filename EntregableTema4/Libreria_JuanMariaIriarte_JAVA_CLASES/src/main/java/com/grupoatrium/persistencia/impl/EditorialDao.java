package com.grupoatrium.persistencia.impl;

import java.util.List;

import com.grupoatrium.modelo.Editorial;
import com.grupoatrium.modelo.Libro;

public interface EditorialDao {
	
	Integer readMaxID();
	
	List<Editorial> read(Editorial editorial);
	
	List<Editorial> readEditorialByLibro(Libro libro);
		
	List<Editorial> readAll ();
	
	boolean create (Editorial editorial);
	
	boolean update (Editorial editorial);
	
	boolean delete (Editorial editorial);

}
