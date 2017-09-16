package com.grupoatrium.modelo;

import java.util.Set;

public class Autor {

	private Integer id_autor;
	private String nombre;
	private String nacionalidad;
	private String bibliografia;
	private Set<Libro> libros;
	private Direccion direccion;

	/**
	 * 
	 */
	public Autor() {
		super();
	}

	/**
	 * @param id_autor
	 * @param nombre
	 * @param nacionalidad
	 * @param bibliografia
	 * @param libros
	 * @param fk_direccion
	 * @param direccion
	 */
	public Autor(Integer id_autor, String nombre, String nacionalidad, String bibliografia, Set<Libro> libros, Direccion direccion) {
		super();
		this.id_autor = id_autor;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.bibliografia = bibliografia;
		this.libros = libros;
		this.direccion = direccion;
	}

	/**
	 * @return the id_autor
	 */
	public Integer getId_autor() {
		return id_autor;
	}

	/**
	 * @param id_autor
	 *            the id_autor to set
	 */
	public void setId_autor(Integer id_autor) {
		this.id_autor = id_autor;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the nacionalidad
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}

	/**
	 * @param nacionalidad
	 *            the nacionalidad to set
	 */
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	/**
	 * @return the bibliografia
	 */
	public String getBibliografia() {
		return bibliografia;
	}

	/**
	 * @param bibliografia
	 *            the bibliografia to set
	 */
	public void setBibliografia(String bibliografia) {
		this.bibliografia = bibliografia;
	}

	/**
	 * @return the libros
	 */
	public Set<Libro> getLibros() {
		return libros;
	}

	/**
	 * @param libros
	 *            the libros to set
	 */
	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}

	/**
	 * @return the direccion
	 */
	public Direccion getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer toString = new StringBuffer ("Autor [id_autor=" + id_autor + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad
				+ ", bibliografia=" + bibliografia + ", direccion=" + direccion + "]" +", \n      libros= ");
		if (libros != null && libros.size()>0) {
			toString.append("\n");
			for (Libro libro : libros) {
				toString.append(libro.toStringAutor());
			}
		}else{
			toString.append("null \n");
		}
		
		return toString.toString();
	}
	
	public String toStringLibro() {
		StringBuffer toString = new StringBuffer ("      Autor [id_autor=" + id_autor + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad
				+ ", bibliografia=" + bibliografia);
		toString .append(", \n      direccion=" + direccion + "] \n");
		return toString.toString();
	}

}
