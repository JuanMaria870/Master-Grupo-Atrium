package com.grupoatrium.persistencia.impl;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.grupoatrium.config.ClaseConfigTest;
import com.grupoatrium.modelo.Autor;
import com.grupoatrium.modelo.Libro;

public class AutorDaoTestImpl {

	private ApplicationContext context;

	@Test
	public void testAutorDao() {
		
		//context = new ClassPathXmlApplicationContext("applicationContext-test-db.xml");
		context = new AnnotationConfigApplicationContext(ClaseConfigTest.class);
		AutorDao autorDao = context.getBean("autorDao", AutorDao.class);


		System.out.println("**************************************************************");
		System.out.println("*********************** TEST AUTOR_DAO ***********************");
		System.out.println("**************************************************************");

		System.out.println("MAX ID");
		System.out.println(autorDao.readMaxID());

		System.out.println("--------------------------------------------------------------");
		System.out.println("READ ALL");
		for (Autor autor : autorDao.readAll()) {
			System.out.println(autor);
		}

		System.out.println("--------------------------------------------------------------");
		System.out.println("READ 'JUAN'");
		Autor autorRead = new Autor();
		autorRead.setNombre("Juan");
		autorRead.setNacionalidad("España");
		System.out.println(new StringBuffer("Datos de búsqueda: ").append(autorRead));
		for (Autor autor : autorDao.read(autorRead)) {
			System.out.println(autor);
		}
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("CREATE AUTOR");
		Autor autorCreate = new Autor(null, "Jose Joaquin", "Italia", "Escritor de comics", null, 1, null);
		System.out.println(autorCreate);
		System.out.println(autorDao.create(autorCreate));
				
		System.out.println("--------------------------------------------------------------");
		System.out.println("READ 'JOSE JOAQUIN'");
		System.out.println(new StringBuffer("Datos de búsqueda: ").append(autorCreate));
		for (Autor autor : autorDao.read(autorCreate)) {
			System.out.println(autor);
		}
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("LINKAR LIBRO 'JOSE JOAQUIN' A 'LIBRO 2'");
		Libro libro2 = new Libro(2,null, null, null, null, null, null, null, null);
		autorCreate =  autorDao.read(autorCreate).get(0);
		System.out.println(autorDao.linkarLibroAutor(autorCreate, libro2));
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("READ ALL");
		for (Autor autor : autorDao.readAll()) {
			System.out.println(autor);
		}
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("UPDATE");
		Autor autorUpdate = autorDao.read(autorCreate).get(0);
		System.out
				.println(new StringBuffer("Datos de actualización: ").append(" Originales: ").append(autorUpdate));
		autorUpdate.setBibliografia("Biografia Actualizada");
		System.out.println(
				new StringBuffer("Datos de actualización: ").append(" Canvio de biografia: ").append(autorUpdate));
		System.out.println(autorDao.update(autorUpdate));

		System.out.println("--------------------------------------------------------------");
		System.out.println("READ ALL");
		for (Autor autor : autorDao.readAll()) {
			System.out.println(autor);
		}
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("DELETE '3'");
		Autor autorDelte = new Autor();
		autorDelte.setId_autor(3);
		System.out.println(new StringBuffer("Datos de borrado: ").append(autorDelte));
		System.out.println(autorDao.delete(autorDelte));

		System.out.println("--------------------------------------------------------------");
		System.out.println("READ ALL");
		for (Autor autor : autorDao.readAll()) {
			System.out.println(autor);
		}
		
		assertNotNull(autorDao.readAll());
	}

}
