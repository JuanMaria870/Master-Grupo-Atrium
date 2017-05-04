package com.grupoatriumtest.cliente;

import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.grupoatrium.modelo.Autor;
import com.grupoatrium.modelo.Direccion;
import com.grupoatrium.modelo.Editorial;
import com.grupoatrium.modelo.Libro;
import com.grupoatrium.persistencia.impl.EditorialesDAO;
import com.grupoatrium.persistencia.impl.LibrosDAO;

public class AppTest {
	private static AbstractApplicationContext context;

	final static Logger logger = Logger.getLogger(AppTest.class);

	@Test
	public void test() {
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

		assertNotNull(autor);
		assertNotNull(direccion);
		assertNotNull(editorial);
		assertNotNull(libro);
		assertNotNull(librosDao);
		assertNotNull(editorialesDao);
		logger.info(autor);
		logger.info(direccion);
		logger.info(editorial);
		logger.info(libro);
		logger.info(librosDao);
		logger.info(editorialesDao);
	}

}
