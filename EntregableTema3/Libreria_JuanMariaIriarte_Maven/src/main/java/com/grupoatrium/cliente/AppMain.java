package com.grupoatrium.cliente;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.grupoatrium.modelo.Autor;
import com.grupoatrium.modelo.Direccion;
import com.grupoatrium.modelo.Editorial;
import com.grupoatrium.modelo.Libro;
import com.grupoatrium.persistencia.impl.EditorialesDAO;
import com.grupoatrium.persistencia.impl.LibrosDAO;

public class AppMain {

	private static AbstractApplicationContext context;

	public static void main(String[] args) {

		// Levantar el contexto de Spring

		// Crear el contenedor de beans a partir del archivo

		context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Probar la creacion de los beans
		Autor autor = context.getBean("autor", Autor.class);
		System.out.println(autor);

		Direccion direccion = context.getBean("direccion", Direccion.class);
		System.out.println(direccion);

		Editorial editorial = context.getBean("editorial", Editorial.class);
		System.out.println(editorial);

		Libro libro = context.getBean("libro", Libro.class);
		System.out.println(libro);

		LibrosDAO librosDao = context.getBean("librosDAO", LibrosDAO.class);
		System.out.println(librosDao);

		EditorialesDAO editorialesDao = context.getBean("editorialesDAO", EditorialesDAO.class);
		System.out.println(editorialesDao);

	}

}
