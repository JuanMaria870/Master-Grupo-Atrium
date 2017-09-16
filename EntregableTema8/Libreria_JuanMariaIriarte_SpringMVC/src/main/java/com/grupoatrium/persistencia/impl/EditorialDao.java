package com.grupoatrium.persistencia.impl;

import java.util.List;

import com.grupoatrium.modelo.Editorial;

public interface EditorialDao {
	
	
	List<Editorial> read(Editorial editorial);
			
	List<Editorial> readAll ();
	
	boolean create (Editorial editorial);
	
	boolean update (Editorial editorial);
	
	boolean delete (Editorial editorial);

}
