package com.grupoatrium.persistencia.impl;

import java.util.List;

import com.grupoatrium.modelo.Autor;
import com.grupoatrium.modelo.Libro;

public interface AutorDao {
	
	Integer readMaxID();
	
	List<Autor> read(Autor autor);
	
	List<Autor> readAutoresByLibro(Libro libro);
	
	List<Autor> readAll ();
	
	boolean create (Autor autor);
	
	boolean linkarLibroAutor (Autor autor, Libro libro);
	
	boolean update (Autor autor);
	
	boolean delete (Autor autor);

}
