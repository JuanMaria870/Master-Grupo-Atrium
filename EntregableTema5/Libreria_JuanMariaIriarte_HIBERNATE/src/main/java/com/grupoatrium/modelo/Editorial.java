package com.grupoatrium.modelo;

import java.util.Set;

public class Editorial {

	Integer id_editorial;
	String nombre;
	String nif_cif;
	Set<Libro> libros;

	/**
	 * 
	 */
	public Editorial() {
		super();
	}

	/**
	 * @param id_editorial
	 * @param nombre
	 * @param nif_cif
	 * @param libros
	 */
	public Editorial(Integer id_editorial, String nombre, String nif_cif, Set<Libro> libros) {
		super();
		this.id_editorial = id_editorial;
		this.nombre = nombre;
		this.nif_cif = nif_cif;
		this.libros = libros;
	}

	/**
	 * @return the id_editorial
	 */
	public Integer getId_editorial() {
		return id_editorial;
	}

	/**
	 * @param id_editorial the id_editorial to set
	 */
	public void setId_editorial(Integer id_editorial) {
		this.id_editorial = id_editorial;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the nif_cif
	 */
	public String getNif_cif() {
		return nif_cif;
	}

	/**
	 * @param nif_cif the nif_cif to set
	 */
	public void setNif_cif(String nif_cif) {
		this.nif_cif = nif_cif;
	}

	/**
	 * @return the libros
	 */
	public Set<Libro> getLibros() {
		return libros;
	}

	/**
	 * @param libros the libros to set
	 */
	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {	
		StringBuffer toString = new StringBuffer ("Editorial [id_editorial=" + id_editorial + ", nombre=" + nombre + ", nif_cif=" + nif_cif + ", \n      libros= ");
		
		if (libros != null && libros.size()>0) {
			toString.append("\n");
			for (Libro libro : libros) {
				toString.append(libro.toStringEditorial());
			}
		}else{
			toString.append("null \n");
		}
		
		
		return toString.toString();
	}
	
	public String toStringLibro() {
		return "Editorial [id_editorial=" + id_editorial + ", nombre=" + nombre + ", nif_cif=" + nif_cif + "]";
	}

	


}
