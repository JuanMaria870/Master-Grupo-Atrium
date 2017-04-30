package com.grupoatrium.modelo.extra;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.grupoatrium.modelo.Autor;
import com.grupoatrium.modelo.Libro;

public class EditorialExtra {

	private String nombre;
	private List<Autor> autores;
	private Set<String> delegaciones;
	private Libro[] libros;
	private Map<String, Autor> responsable;
	private Properties emails;

	/**
	 * 
	 */
	public EditorialExtra() {
		super();
	}

	/**
	 * @param autores
	 * @param delegaciones
	 * @param libros
	 * @param responsable
	 * @param emails
	 */
	public EditorialExtra(String nombre, List<Autor> autores, Set<String> delegaciones, Libro[] libros,
			Map<String, Autor> responsable, Properties emails) {
		super();
		this.nombre = nombre;
		this.autores = autores;
		this.delegaciones = delegaciones;
		this.libros = libros;
		this.responsable = responsable;
		this.emails = emails;
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
	 * @return the autores
	 */
	public List<Autor> getAutores() {
		return autores;
	}

	/**
	 * @param autores
	 *            the autores to set
	 */
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	/**
	 * @return the delegaciones
	 */
	public Set<String> getDelegaciones() {
		return delegaciones;
	}

	/**
	 * @param delegaciones
	 *            the delegaciones to set
	 */
	public void setDelegaciones(Set<String> delegaciones) {
		this.delegaciones = delegaciones;
	}

	/**
	 * @return the libros
	 */
	public Libro[] getLibros() {
		return libros;
	}

	/**
	 * @param libros
	 *            the libros to set
	 */
	public void setLibros(Libro[] libros) {
		this.libros = libros;
	}

	/**
	 * @return the responsable
	 */
	public Map<String, Autor> getResponsable() {
		return responsable;
	}

	/**
	 * @param responsable
	 *            the responsable to set
	 */
	public void setResponsable(Map<String, Autor> responsable) {
		this.responsable = responsable;
	}

	/**
	 * @return the emails
	 */
	public Properties getEmails() {
		return emails;
	}

	/**
	 * @param emails
	 *            the emails to set
	 */
	public void setEmails(Properties emails) {
		this.emails = emails;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EditorialExtra [nombre=" + nombre + ", autores=" + autores + ", delegaciones=" + delegaciones
				+ ", libros=" + Arrays.toString(libros) + ", responsable=" + responsable + ", emails=" + emails + "]";
	}

}
