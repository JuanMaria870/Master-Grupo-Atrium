package com.grupoatrium.modelo;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Editorial {

	@Value("Almixu")
	String nombre;

	@Resource(name = "direccionAlias")
	Direccion direccion;

	@Value("34567890A")
	String nif;

	/**
	 * 
	 */
	public Editorial() {
		super();
	}

	/**
	 * @param nombre
	 * @param direccion
	 * @param nif
	 */
	public Editorial(String nombre, Direccion direccion, String nif) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.nif = nif;
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
	 * @return the direccion
	 */
	public Direccion getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the nif
	 */
	public String getNif() {
		return nif;
	}

	/**
	 * @param nif
	 *            the nif to set
	 */
	public void setNif(String nif) {
		this.nif = nif;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Editorial [nombre=" + nombre + ", direccion=" + direccion + ", nif=" + nif + "]";
	}

}
