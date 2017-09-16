package com.grupoatrium.modelo;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Editorial {

	private Integer id_editorial;
	private String nombre;
	private String nif_cif;
	

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
	public Editorial(Integer id_editorial, String nombre, String nif_cif) {
		super();
		this.id_editorial = id_editorial;
		this.nombre = nombre;
		this.nif_cif = nif_cif;
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




	public String toString() {
		return "Editorial [id_editorial=" + id_editorial + ", nombre=" + nombre + ", nif_cif=" + nif_cif + "]";
	}

	


}
