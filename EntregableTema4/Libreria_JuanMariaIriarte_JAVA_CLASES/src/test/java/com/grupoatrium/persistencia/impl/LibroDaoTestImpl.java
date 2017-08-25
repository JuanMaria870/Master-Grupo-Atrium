package com.grupoatrium.persistencia.impl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.grupoatrium.config.ClaseConfigTest;
import com.grupoatrium.modelo.Autor;
import com.grupoatrium.modelo.Libro;

public class LibroDaoTestImpl {
	
	private ApplicationContext context;

	@Test
	public void testLibroDao() {
		
		//context = new ClassPathXmlApplicationContext("applicationContext-test-db.xml");
		context = new AnnotationConfigApplicationContext(ClaseConfigTest.class);

		LibroDao libroDao = context.getBean("libroDao", LibroDao.class);
		AutorDao autorDao = context.getBean("autorDao", AutorDao.class);
		
		System.out.println("**************************************************************");
		System.out.println("*********************** TEST LIBRO_DAO ***********************");
		System.out.println("**************************************************************");

		System.out.println("MAX ID");
		System.out.println(libroDao.readMaxID());
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("READ ALL");
		for (Libro libro : libroDao.readAll()) {
			System.out.println(libro);
		}

		System.out.println("--------------------------------------------------------------");
		System.out.println("READ '123456789NO'");
		Libro libroRead = new Libro();
		libroRead.setIsbn("123456789NO");
		System.out.println(new StringBuffer("Datos de búsqueda: ").append(libroRead));
		for (Libro libro : libroDao.read(libroRead)) {
			System.out.println(libro);
		}
		

		System.out.println("--------------------------------------------------------------");
		System.out.println("CREATE LIBRO");
		Libro libroCreate = new Libro(null,  "123456789CO", "Comic 1", null, null, 2017, 20.50, "Comic de supervillanos", 2);
		System.out.println(libroCreate);
		System.out.println(libroDao.create(libroCreate));
				
		System.out.println("--------------------------------------------------------------");
		System.out.println("READ '123456789CO'");
		System.out.println(new StringBuffer("Datos de búsqueda: ").append(libroCreate));
		for (Libro libro : libroDao.read(libroCreate)) {
			System.out.println(libro);
		}
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("LINKAR LIBRO '123456789CO' A 'AUTOR 2'");
		Autor autor2 = new Autor(2, null, null, null, null, null, null);
		libroCreate =  libroDao.read(libroCreate).get(0);
		System.out.println(autorDao.linkarLibroAutor(autor2, libroCreate));
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("READ ALL");
		for (Libro libro : libroDao.readAll()) {
			System.out.println(libro);
		}
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("UPDATE 5");
		Libro libroUpdate = libroDao.read(libroCreate).get(0);
		System.out
				.println(new StringBuffer("Datos de actualización: ").append(" Originales: ").append(libroUpdate));
		libroUpdate.setTitulo("Titulo Actualizado");
		System.out.println(
				new StringBuffer("Datos de actualización: ").append(" Canvio de titulo: ").append(libroUpdate));
		System.out.println(libroDao.update(libroUpdate));

		System.out.println("--------------------------------------------------------------");
		System.out.println("READ ALL");
		for (Libro libro : libroDao.readAll()) {
			System.out.println(libro);
		}
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("DELETE '3'");
		Libro libroDelte = new Libro();
		libroDelte.setId_libro(3);
		System.out.println(new StringBuffer("Datos de borrado: ").append(libroDelte));
		System.out.println(libroDao.delete(libroDelte));

		System.out.println("--------------------------------------------------------------");
		System.out.println("READ ALL");
		for (Libro libro : libroDao.readAll()) {
			System.out.println(libro);
		}
		
	}

	

}
