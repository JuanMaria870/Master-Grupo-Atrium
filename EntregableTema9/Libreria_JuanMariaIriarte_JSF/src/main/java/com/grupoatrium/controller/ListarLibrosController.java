package com.grupoatrium.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.grupoatrium.persistencia.impl.LibroDao;

@Controller
//@RequestMapping
public class ListarLibrosController {

	@Autowired
	private LibroDao dao;

//	@RequestMapping(method = RequestMethod.GET, value = "/todos")
//	public String listarLibros(Model modelo) {
//		System.out.println("-----------------" + dao.readAll());
//		modelo.addAttribute("lista", dao.readAll());
//		return "mostrarLibros";
//	}
//
//	@RequestMapping(method = RequestMethod.POST, value = "/buscarPorId")
//	public String buscarPorId(@Valid CriteriaLibroBusquedaId criteriaLibroBusquedaId, BindingResult resultado,
//			Model modelo) {
//		if (resultado.hasErrors()) {
//			return "formularioBusquedaId";
//		} else {
//			Libro libro = new Libro();
//			libro.setId_libro(criteriaLibroBusquedaId.getId());
//			modelo.addAttribute("lista", dao.read(libro));
//			return "mostrarLibros";
//		}
//
//	}
//		
//	@RequestMapping(method=RequestMethod.GET, value = "/buscarPorId")
//	public String buscarPorId(Model modelo) {
//		modelo.addAttribute("criteriaLibroBusquedaId",new CriteriaLibroBusquedaId());
//		return "formularioBusquedaId";
//	}
//	
//	@RequestMapping(method = RequestMethod.POST, value = "/buscarPorTitulo")
//	public String buscarPorTitulo(@Valid CriteriaLibroBusquedaTitulo criteriaLibroBusquedaTitulo, BindingResult resultado,
//			Model modelo) {
//		if (resultado.hasErrors()) {
//			return "formularioBusquedaTitulo";
//		} else {
//			Libro libro = new Libro();
//			libro.setTitulo(criteriaLibroBusquedaTitulo.getTitulo());
//			modelo.addAttribute("lista", dao.read(libro));
//			return "mostrarLibros";
//		}
//
//	}
//		
//	@RequestMapping(method=RequestMethod.GET, value = "/buscarPorTitulo")
//	public String buscarPorTitulo(Model modelo) {
//		modelo.addAttribute("criteriaLibroBusquedaTitulo",new CriteriaLibroBusquedaTitulo());
//		return "formularioBusquedaTitulo";
//
//	}
//	
	
	

}
