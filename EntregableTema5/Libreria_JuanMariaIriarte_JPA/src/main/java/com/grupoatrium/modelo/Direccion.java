package com.grupoatrium.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_direccion")
    private Integer id_direccion;
    @Column(name = "calle")
    private String calle;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "poblacion")
    private String poblacion;
    @Column(name = "cp")
    private Integer cp;
    @Column(name = "provincia")
    private String provincia;
    @OneToOne(mappedBy="direccion")
    private Autor autor;
	
	

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
