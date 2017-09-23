package com.grupoatrium.web;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupoatrium.modelo.Autor;
import com.grupoatrium.modelo.Editorial;
import com.grupoatrium.modelo.Libro;
import com.grupoatrium.negocio.Carrito;
import com.grupoatrium.persistencia.impl.LibroDao;

@Component
public class LibroBean {

	private Integer id_libro;
	private String isbn;
	private String titulo;
	private Set<Autor> autores;
	private Integer publicacion;
	private Double precio;
	private String descripcion;
	private Editorial editorial;
	private String nombreEditorial;

	@Autowired
	private LibroDao libroDao;

	@Autowired
	Carrito miCarro;

	public String altaLibro() {

		Editorial editorial = new Editorial();
		editorial.setNombre(nombreEditorial);
		editorial.setNif_cif("formularioAlta");
		Libro libro = new Libro();
		libro.setEditorial(editorial);
		libro.setDescripcion(descripcion);
		libro.setIsbn("formularioAlta");
		libro.setPrecio(precio);
		libro.setPublicacion(Calendar.getInstance().get(Calendar.YEAR));
		libro.setTitulo(titulo);
		libroDao.create(libro);
		return "mostrarLibros";
	}

	public String limpiarAlta() {
		descripcion = null;
		precio = null;
		titulo = null;
		nombreEditorial = null;

		return "introducirLibro";
	}

	public String limpiarTitulo() {
		titulo = null;
		return "buscarPorTitulo";
	}
	
	public String limpiarId() {
		id_libro=null;
		return "buscarPorId";
	}

	public List<Libro> listarLibros() {
		List<Libro> libros = libroDao.readAll();
		return libros;
	}

	public String agregarCarrito(int id) {
		Libro l = new Libro();
		l.setId_libro(id);
		miCarro.agregarProducto(libroDao.read(l).get(0));
		return "mostrarCarrito";
	}

	public List<Libro> mostrarCarrito() {
		return miCarro.getContenido();
	}

	public double mostrarTotal() {
		return miCarro.getImporte();
	}

	public List<Libro> eliminarProducto(int id) {
		Libro l = new Libro();
		l.setId_libro(id);
		miCarro.sacarProducto(l);
		return miCarro.getContenido();
	}

	public List<Libro> vaciarCarrito() {
		miCarro.vaciarCarro();

		return miCarro.getContenido();
	}

	public String busquedaId() {
		return "mostrarLibrosBusquedaId";
	}

	public List<Libro> listaBusquedaId() {
		Libro l = new Libro();
		l.setId_libro(id_libro);
		return libroDao.read(l);
	}

	public String busquedaTitulo() {
		return "mostrarLibrosBusquedaTitulo";
	}

	public List<Libro> listaBusquedaTitulo() {
		Libro l = new Libro();
		l.setTitulo(titulo);
		return libroDao.read(l);
	}

	/**
	 * 
	 */
	public LibroBean() {
		super();
	}

	/**
	 * @param id_libro
	 * @param isbn
	 * @param titulo
	 * @param autores
	 * @param publicacion
	 * @param precio
	 * @param descripcion
	 * @param editorial
	 */
	public LibroBean(Integer id_libro, String isbn, String titulo, Set<Autor> autores, Integer publicacion,
			Double precio, String descripcion, Editorial editorial) {
		super();
		this.id_libro = id_libro;
		this.isbn = isbn;
		this.titulo = titulo;
		this.autores = autores;
		this.publicacion = publicacion;
		this.precio = precio;
		this.descripcion = descripcion;
		this.editorial = editorial;
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
	 * @return the id_libro
	 */
	public Integer getId_libro() {
		return id_libro;
	}

	/**
	 * @param id_libro
	 *            the id_libro to set
	 */
	public void setId_libro(Integer id_libro) {
		this.id_libro = id_libro;
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
	public Set<Autor> getAutores() {
		return autores;
	}

	/**
	 * @param autores
	 *            the autores to set
	 */
	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}

	/**
	 * @return the publicacion
	 */
	public Integer getPublicacion() {
		return publicacion;
	}

	/**
	 * @param publicacion
	 *            the publicacion to set
	 */
	public void setPublicacion(Integer publicacion) {
		this.publicacion = publicacion;
	}

	/**
	 * @return the precio
	 */
	public Double getPrecio() {
		return precio;
	}

	/**
	 * @param precio
	 *            the precio to set
	 */
	public void setPrecio(Double precio) {
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

		StringBuffer toString = new StringBuffer("Libro [id_libro=" + id_libro + ", isbn=" + isbn + ", titulo=" + titulo
				+ ", editorial=" + (editorial != null ? editorial.toString() : null) + ", publicacion=" + publicacion
				+ ", precio=" + precio + ", descripcion=" + descripcion + ", \n      autores= ");
		if (autores != null && autores.size() > 0) {
			toString.append("\n");
			for (Autor autor : autores) {
				toString.append(autor.toString());
			}
		} else {
			toString.append("null \n");
		}

		return toString.toString();
	}

	public String toStringAutor() {
		return "      Libro [id_libro=" + id_libro + ", isbn=" + isbn + ", titulo=" + titulo + ", editorial="
				+ editorial.toString() + ", publicacion=" + publicacion + ", precio=" + precio + ", descripcion="
				+ descripcion + "] \n";
	}

	public String toStringEditorial() {

		StringBuffer toString = new StringBuffer("      Libro [id_libro=" + id_libro + ", isbn=" + isbn + ", titulo="
				+ titulo + ", publicacion=" + publicacion + ", precio=" + precio + ", descripcion=" + descripcion + "]"
				+ ", \n      autores= ");
		if (autores != null && autores.size() > 0) {
			toString.append("\n");
			for (Autor autor : autores) {
				toString.append(autor.toString());
			}
		} else {
			toString.append("null \n");
		}

		return toString.toString();
	}

	public String getNombreEditorial() {
		return nombreEditorial;
	}

	public void setNombreEditorial(String nombreEditorial) {
		this.nombreEditorial = nombreEditorial;
	}

}
