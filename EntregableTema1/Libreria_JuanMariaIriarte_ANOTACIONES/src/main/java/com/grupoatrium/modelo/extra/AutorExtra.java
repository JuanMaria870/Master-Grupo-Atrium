package com.grupoatrium.modelo.extra;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * Clase test con INTERFACES INITIALIZINGBEAN Y DISPOSABLEBEAN
 *
 */

@Component
public class AutorExtra {

	@Value("Juane")
	String nombre;

	@Value("Español")
	String nacionalidad;

	@Value("del director EXTRA")
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

	// Init y Destroy manera
	@PostConstruct
	public void postConstruct() {
		System.out.println("Init (justo despues de inicializar), añadiendo anotación @PostConstruct");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("Previo a detruir, añadiendo anotación @PreDestroy");
	}

}
