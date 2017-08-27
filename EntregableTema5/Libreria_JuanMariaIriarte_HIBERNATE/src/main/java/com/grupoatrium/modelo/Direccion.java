package com.grupoatrium.modelo;

public class Direccion {

	Integer id_direccion;
	String calle;
	Integer numero;
	String poblacion;
	Integer cp;
	String provincia;
	Autor autor;

	/**
	 * 
	 */
	public Direccion() {
		super();
	}

	/**
	 * @param id_direccion
	 * @param calle
	 * @param numero
	 * @param poblacion
	 * @param cp
	 * @param provincia
	 */
	public Direccion(Integer id_direccion, String calle, Integer numero, String poblacion, Integer cp, String provincia) {
		super();
		this.id_direccion = id_direccion;
		this.calle = calle;
		this.numero = numero;
		this.poblacion = poblacion;
		this.cp = cp;
		this.provincia = provincia;
	}
	
	

	/**
	 * @return the autor
	 */
	public Autor getAutor() {
		return autor;
	}

	/**
	 * @param autor the autor to set
	 */
	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	/**
	 * @return the id_direccion
	 */
	public Integer getId_direccion() {
		return id_direccion;
	}

	/**
	 * @param id_direccion
	 *            the id_direccion to set
	 */
	public void setId_direccion(Integer id_direccion) {
		this.id_direccion = id_direccion;
	}

	/**
	 * @return the calle
	 */
	public String getCalle() {
		return calle;
	}

	/**
	 * @param calle
	 *            the calle to set
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}

	/**
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the poblacion
	 */
	public String getPoblacion() {
		return poblacion;
	}

	/**
	 * @param poblacion
	 *            the poblacion to set
	 */
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	/**
	 * @return the cp
	 */
	public Integer getCp() {
		return cp;
	}

	/**
	 * @param cp
	 *            the cp to set
	 */
	public void setCp(int cp) {
		this.cp = cp;
	}

	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia
	 *            the provincia to set
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Direccion [id_direccion=" + id_direccion + ", calle=" + calle + ", numero=" + numero + ", poblacion="
				+ poblacion + ", cp=" + cp + ", provincia=" + provincia + "]";
	}
	
	

}
