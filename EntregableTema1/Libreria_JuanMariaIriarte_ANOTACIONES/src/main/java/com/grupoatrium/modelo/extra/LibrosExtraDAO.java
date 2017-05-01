package com.grupoatrium.modelo.extra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.grupoatrium.persistencia.impl.ConnectionMgr;

@Component
public class LibrosExtraDAO {

	@Autowired
	private ConnectionMgr connMgr;

	/**
	 * 
	 */
	public LibrosExtraDAO() {
		super();
	}

	/**
	 * @param connMgr
	 */
	public LibrosExtraDAO(ConnectionMgr connMgr) {
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
		return "LibrosExtraDAO [connMgr=" + connMgr + "]";
	}

}
