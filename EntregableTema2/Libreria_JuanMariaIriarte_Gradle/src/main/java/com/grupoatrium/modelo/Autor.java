package com.grupoatrium.modelo;

public class Autor {

	String nombre;
	String nacionalidad;
	String comentarios;

	/**
	 * 
	 */
	public Autor() {
		super();
	}

	/**
	 * @param nombre
	 * @param nacionalidad
	 * @param comentarios
	 */
	public Autor(String nombre, String nacionalidad, String comentarios) {
		super();
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.comentarios = comentarios;
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
	 * @return the comentarios
	 */
	public String getComentarios() {
		return comentarios;
	}

	/**
	 * @param comentarios
	 *            the comentarios to set
	 */
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Autor [nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", comentarios=" + comentarios + "]";
	}

}
