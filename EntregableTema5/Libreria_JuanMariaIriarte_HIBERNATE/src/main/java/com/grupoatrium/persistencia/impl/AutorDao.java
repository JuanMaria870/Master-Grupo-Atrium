package com.grupoatrium.persistencia.impl;

import java.util.List;

import com.grupoatrium.modelo.Autor;

public interface AutorDao {
	
	List<Autor> read(Autor autor);
	
	List<Autor> readAll ();
	
	boolean create (Autor autor);
	
	boolean update (Autor autor);
	
	boolean delete (Autor autor);

}
