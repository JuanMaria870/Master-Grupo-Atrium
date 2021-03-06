package com.grupoatrium.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_libro")
    private Integer id_libro;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "titulo")
    private String titulo;
    @ManyToMany(mappedBy="libros", cascade=CascadeType.ALL)
    private List<Autor> autores = new ArrayList<Autor>();
    @Column(name = "publicacion")
    private Integer publicacion;
    @Column(name = "precio")
    private Double precio;
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "fk_editorial")
    Editorial editorial;
	

	    
		@ManyToMany(cascade=CascadeType.ALL)
		@JoinColumn(name="fk_libro",referencedColumnName="id_libro")
	    List<Libro> libros;

	/**
	 * 
	 */
	public Libro() {
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
	public Libro(Integer id_libro, String isbn, String titulo, List<Autor> autores, Integer publicacion, Double precio,
			String descripcion) {
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
	 * @param editorial the editorial to set
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

		StringBuffer toString = new StringBuffer(
				"Libro [id_libro=" + id_libro + ", isbn=" + isbn + ", titulo=" + titulo + ", editorial="
				 + (editorial!=null ? editorial.toStringLibro():null)
						+ ", publicacion=" + publicacion + ", precio=" + precio + ", descripcion=" + descripcion
						+ ", \n      autores= ");
		if (autores != null && autores.size() > 0) {
			toString.append("\n");
			for (Autor autor : autores) {
				toString.append(autor.toStringLibro());
			}
		} else {
			toString.append("null \n");
		}

		return toString.toString();
	}

	public String toStringAutor() {
		return "      Libro [id_libro=" + id_libro + ", isbn=" + isbn + ", titulo=" + titulo
		 + ", editorial=" + editorial.toStringLibro()
				+ ", publicacion=" + publicacion + ", precio=" + precio + ", descripcion=" + descripcion + "] \n";
	}

	public String toStringEditorial() {

		StringBuffer toString = new StringBuffer("      Libro [id_libro=" + id_libro + ", isbn=" + isbn + ", titulo="
				+ titulo + ", publicacion=" + publicacion + ", precio=" + precio + ", descripcion=" + descripcion + "]"
				+ ", \n      autores= ");
		if (autores != null && autores.size() > 0) {
			toString.append("\n");
			for (Autor autor : autores) {
				toString.append(autor.toStringLibro());
			}
		} else {
			toString.append("null \n");
		}

		return toString.toString();
	}

}
