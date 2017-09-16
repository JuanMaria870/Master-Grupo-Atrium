package com.grupoatrium.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.grupoatrium.modelo.Libro;

@Component(value="miCarro")
@Scope("session")
public class Carrito implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double importe;
	private List<Libro> contenido = new ArrayList<Libro>();
	
	public void agregarProducto(Libro l){
		contenido.add(l);
		importe += l.getPrecio();
	}
	
	public void sacarProducto(Libro l){
		Libro eliminar = null;
		for (Libro libro : contenido) {
			if(l.getId_libro() == libro.getId_libro()){
				eliminar = libro;
				break;
			}
		}
		contenido.remove(eliminar);
		importe -= l.getPrecio();
	}
	
	public void vaciarCarro(){
		importe=0;
		contenido = new ArrayList<Libro>();
	}
	
	
	public double getImporte() {
		return importe;
	}
	
	public List<Libro> getContenido() {
		return contenido;
	}

}
