package com.grupoatrium.persistencia.impl;

import java.util.List;

import com.grupoatrium.modelo.Autor;
import com.grupoatrium.modelo.Editorial;
import com.grupoatrium.modelo.Libro;

public interface LibroDao {
	
	Integer readMaxID();
	
	List<Libro> read(Libro libro);
	
	List<Libro> readLibrosByAutor(Autor autor);
	
	List<Libro> readLibrosByEditorial(Editorial editorial);
	
	List<Libro> readAll ();
	
	boolean create (Libro libro);
	
	boolean update (Libro libro);
	
	boolean delete (Libro libro);
}
