package com.grupoatrium.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.grupoatrium.negocio.Carrito;
import com.grupoatrium.persistencia.impl.LibroDao;

@Controller
//@RequestMapping
@Scope("session")
public class ComprarController {
	
	@Autowired
	private LibroDao libroDao;
	
	@Autowired
	private Carrito miCarro;
//	
//	@RequestMapping(method = RequestMethod.GET, value="/comprar")
//	public String addProducto(@RequestParam("id") int codigo){
//		Libro l = new Libro();
//		l.setId_libro(codigo);
//		miCarro.agregarProducto(libroDao.read(l).get(0));
//		return "mostrarCarrito";
//	}
//	
//	@RequestMapping(method = RequestMethod.GET, value="/eliminar")
//	public String sacarProducto(@RequestParam("id") int codigo){
//		Libro l = new Libro();
//		l.setId_libro(codigo);
//		miCarro.sacarProducto(libroDao.read(l).get(0));
//		return "mostrarCarrito";
//	}
//	
//	@RequestMapping(method = RequestMethod.GET, value="/limpiar")
//	public String vaciarCarro(){
//		miCarro.vaciarCarro();
//		return "mostrarCarrito";
//	}
//	
//	@RequestMapping(method = RequestMethod.GET, value="/mostrarCarro")
//	public String mostrarCarro(){
//		return "mostrarCarrito";
//	}
//
//
//	
	
	
}
