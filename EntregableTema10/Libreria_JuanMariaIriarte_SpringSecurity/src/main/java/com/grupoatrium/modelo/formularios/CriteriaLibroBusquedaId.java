package com.grupoatrium.modelo.formularios;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class CriteriaLibroBusquedaId {

	@NotNull
	@Digits(integer = 4, fraction = 0)
	private int id;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

}
