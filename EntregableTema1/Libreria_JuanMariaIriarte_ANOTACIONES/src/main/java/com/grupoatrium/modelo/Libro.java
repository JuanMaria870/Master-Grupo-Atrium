package com.grupoatrium.modelo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Libro {

	@Value("345678910-A-356-BT")
	String isbn;

	@Value("Almixuwanadu")
	String titulo;

	@Resource(name = "autores4")
	List<Autor> autores;

	@Resource(name = "editorial")
	Editorial editorial;

	@Value("3000")
	int publicacion;

	@Value("19.50")
	double precio;

	@Value("Chachiguay")
	String descripcion;

	/**
	 * 
	 */
	public Libro() {
		super();
	}

	/**
	 * @param isbn
	 * @param titulo
	 * @param autores
	 * @param editorial
	 * @param publicacion
	 * @param precio
	 * @param descripcion
	 */
	public Libro(String isbn, String titulo, List<Autor> autores, Editorial editorial, int publicacion, double precio,
			String descripcion) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autores = autores;
		this.editorial = editorial;
		this.publicacion = publicacion;
		this.precio = precio;
		this.descripcion = descripcion;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn
	 *            the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
	 * @return the editorial
	 */
	public Editorial getEditorial() {
		return editorial;
	}

	/**
	 * @param editorial
	 *            the editorial to set
	 */
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	/**
	 * @return the publicacion
	 */
	public int getPublicacion() {
		return publicacion;
	}

	/**
	 * @param publicacion
	 *            the publicacion to set
	 */
	public void setPublicacion(int publicacion) {
		this.publicacion = publicacion;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio
	 *            the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autores=" + autores + ", editorial=" + editorial
				+ ", publicacion=" + publicacion + ", precio=" + precio + ", descripcion=" + descripcion + "]";
	}

}
