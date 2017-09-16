package com.grupoatrium.modelo.formularios;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CriteriaLibroBusquedaTitulo {

	@NotNull
	@Size(min=3, max=20)
	private String titulo;

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


}
