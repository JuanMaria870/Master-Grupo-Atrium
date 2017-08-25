package com.grupoatrium.persistencia.impl;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.grupoatrium.modelo.Editorial;
import com.grupoatrium.modelo.Libro;

public class EditorialDaoTestImpl {

	private ApplicationContext context;

	@Test
	public void testEditorialDao() {

		context = new ClassPathXmlApplicationContext("applicationContext-test-db.xml");

		LibroDao libroDao = context.getBean("libroDao", LibroDao.class);
		EditorialDao editorialDao = context.getBean("editorialDao", EditorialDao.class);

		System.out.println("**************************************************************");
		System.out.println("********************* TEST EDITORIAL_DAO *********************");
		System.out.println("**************************************************************");

		System.out.println("MAX ID");
		System.out.println(editorialDao.readMaxID());

		System.out.println("--------------------------------------------------------------");
		System.out.println("READ ALL");
		for (Editorial editorial : editorialDao.readAll()) {
			System.out.println(editorial);
		}

		System.out.println("--------------------------------------------------------------");
		System.out.println("READ '123456789S'");
		Editorial editorialRead = new Editorial();
		editorialRead.setNif_cif("123456789S");
		System.out.println(new StringBuffer("Datos de búsqueda: ").append(editorialRead));
		for (Editorial editorial : editorialDao.read(editorialRead)) {
			System.out.println(editorial);
		}

		System.out.println("--------------------------------------------------------------");
		System.out.println("CREATE EDITORIAL");
		Editorial editorialCreate = new Editorial(null, "Editorial Gandia", "123456789T", null);
		System.out.println(editorialCreate);
		System.out.println(editorialDao.create(editorialCreate));

		System.out.println("--------------------------------------------------------------");
		System.out.println("UPDATE LIBRO 2 A NUEVA EDITORIAL");
		editorialCreate = editorialDao.read(editorialCreate).get(0);
		Libro libroUpdate = libroDao.read(new Libro(2, null, null, null, null, null, null, null, null)).get(0);
		libroUpdate.setFk_editorial(editorialCreate.getId_editorial());
		libroDao.update(libroUpdate);

		System.out.println("--------------------------------------------------------------");
		System.out.println("READ ALL");
		for (Editorial editorial : editorialDao.readAll()) {
			System.out.println(editorial);
		}

		System.out.println("--------------------------------------------------------------");
		System.out.println("UPDATE 3");
		Editorial editorialUpdate = editorialDao.read(editorialCreate).get(0);
		System.out
				.println(new StringBuffer("Datos de actualización: ").append(" Originales: ").append(editorialUpdate));
		editorialUpdate.setNombre("Nomre Actualizado");
		System.out.println(
				new StringBuffer("Datos de actualización: ").append(" Canvio de nombre: ").append(editorialUpdate));
		System.out.println(editorialDao.update(editorialUpdate));

		System.out.println("--------------------------------------------------------------");
		System.out.println("READ ALL");
		for (Editorial editorial : editorialDao.readAll()) {
			System.out.println(editorial);
		}

		System.out.println("--------------------------------------------------------------");
		System.out.println("DELETE '3'");
		Editorial editorialDelte = new Editorial();
		editorialDelte.setId_editorial(3);
		System.out.println(new StringBuffer("Datos de borrado: ").append(editorialDelte));
		System.out.println(editorialDao.delete(editorialDelte));

		System.out.println("--------------------------------------------------------------");
		System.out.println("READ ALL");
		for (Editorial editorial : editorialDao.readAll()) {
			System.out.println(editorial);
		}

		assertNotNull(editorialDao.readAll());
	}

}
