package com.grupoatrium.modelo.extra;

/**
 * 
 * Clase extra con el patrón singleton implementado
 *
 */
public class DireccionExtra {

	String calle;
	int numero;
	String poblacion;
	int cp;
	String provincia;

	private static DireccionExtra instance = new DireccionExtra();

	/**
	 * 
	 */
	private DireccionExtra() {

	}

	public static DireccionExtra getInstance() {
		return instance;
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
	public int getNumero() {
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
	public int getCp() {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", numero=" + numero + ", poblacion=" + poblacion + ", cp=" + cp
				+ ", provincia=" + provincia + "]";
	}

}
