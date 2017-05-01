package com.grupoatrium.modelo.extra;

/**
 * 
 * Clase test con INTERFACES INITIALIZINGBEAN Y DISPOSABLEBEAN
 *
 */
public class AutorExtra {

	String nombre;
	String nacionalidad;
	String comentarios;

	/**
	 * 
	 */
	public AutorExtra() {
		super();
	}

	/**
	 * @param nombre
	 * @param nacionalidad
	 * @param comentarios
	 */
	public AutorExtra(String nombre, String nacionalidad, String comentarios) {
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


	// Tercera manera
	public void initMetodo() {
		System.out.println("Init metodo (justo despues de inicializar), añadiendo en el contexto"
				+ "default-init-method='init' default-destroy-method='destroyMetodo'"
				+ "o en la creación del mismo bean");
	}

	public void destroyMetodo() {
		System.out.println("Previo a detruir metodo (justo despues de inicializar), añadiendo en el contexto"
				+ "default-init-method='init' default-destroy-method='destroyMetodo'"
				+ "o en la creación del mismo bean");
	}

	public void initMetodo2() {
		System.out.println("Init metodo (justo despues de inicializar), añadiendo en el contexto"
				+ "default-init-method='init' default-destroy-method='destroyMetodo'"
				+ "o en la creación del mismo bean");
	}

	public void destroyMetodo2() {
		System.out.println("Previo a detruir metodo (justo despues de inicializar), añadiendo en el contexto"
				+ "default-init-method='init' default-destroy-method='destroyMetodo'"
				+ "o en la creación del mismo bean");
	}

}
