package com.grupoatrium.controller;

import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.grupoatrium.modelo.Editorial;
import com.grupoatrium.modelo.Libro;
import com.grupoatrium.modelo.formularios.FormLibro;
import com.grupoatrium.persistencia.impl.LibroDao;

@Controller
//@RequestMapping
public class AnadirLibroController {
	
	@Autowired
	private LibroDao libroDao;
	

	//@RequestMapping(method = RequestMethod.POST, value = "/alta")
	public String anadirLibro(@Valid FormLibro formLibro, BindingResult resultado,Model modelo) {
		if (resultado.hasErrors()) {
			//modelo.addAttribute("libroForm",libroForm);
			return "formularioAlta";
		} else {
			Editorial editorial = new Editorial();
			editorial.setNombre(formLibro.getEditorial());
			editorial.setNif_cif("formularioAlta");
			Libro libro = new Libro();
			libro.setEditorial(editorial);
			libro.setDescripcion(formLibro.getDescripcion());
			libro.setIsbn("formularioAlta");
			libro.setPrecio(formLibro.getPrecio());
			libro.setPublicacion(Calendar.getInstance().get(Calendar.YEAR));
			libro.setTitulo(formLibro.getTitulo());
			libroDao.create(libro);
			modelo.addAttribute("lista", libroDao.readAll());
			return "mostrarLibros";
		}

	}
		
	//@RequestMapping(method=RequestMethod.GET, value = "/alta")
	public String anadirLibro(Model modelo) {
		modelo.addAttribute("formLibro",new FormLibro());
		return "formularioAlta";

	}
}
