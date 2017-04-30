package com.grupoatrium.persistencia.impl;

import org.springframework.beans.factory.annotation.Required;

public class LibrosDAO {

	ConnectionMgr connMgr;

	/**
	 * 
	 */
	public LibrosDAO() {
		super();
	}

	/**
	 * @param connMgr
	 */
	public LibrosDAO(ConnectionMgr connMgr) {
		super();
		this.connMgr = connMgr;
	}

	/**
	 * @return the connMgr
	 */
	public ConnectionMgr getConnMgr() {
		return connMgr;
	}

	/**
	 * @param connMgr
	 *            the connMgr to set
	 */
	@Required
	public void setConnMgr(ConnectionMgr connMgr) {
		this.connMgr = connMgr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LibrosDAO [connMgr=" + connMgr + "]";
	}

}
