package com.grupoatrium.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Editorial")
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_editorial")
	private Integer id_editorial;
    @Column(name = "nombre")
	private String nombre;
    @Column(name = "nif_cif")
	private String nif_cif;
	@OneToMany(mappedBy = "editorial", cascade = CascadeType.ALL)
	private List<Libro> libros = new ArrayList<Libro>();

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
	public Editorial(Integer id_editorial, String nombre, String nif_cif, List<Libro> libros) {
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
	public List<Libro> getLibros() {
		return libros;
	}

	/**
	 * @param libros the libros to set
	 */
	public void setLibros(List<Libro> libros) {
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
