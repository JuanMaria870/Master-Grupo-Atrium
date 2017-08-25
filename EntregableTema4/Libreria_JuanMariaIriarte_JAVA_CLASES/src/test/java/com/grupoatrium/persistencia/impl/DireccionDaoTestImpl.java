package com.grupoatrium.persistencia.impl;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.grupoatrium.config.ClaseConfigTest;
import com.grupoatrium.modelo.Direccion;

public class DireccionDaoTestImpl {

	private ApplicationContext context;

	@Test
	public void testDireccionDao() {

		//context = new ClassPathXmlApplicationContext("applicationContext-test-db.xml");
		context = new AnnotationConfigApplicationContext(ClaseConfigTest.class);

		DireccionDao direccionDao = context.getBean("direccionDao", DireccionDao.class);

		System.out.println("**************************************************************");
		System.out.println("********************* TEST DIRECCION_DAO *********************");
		System.out.println("**************************************************************");

		System.out.println("MAX ID");
		System.out.println(direccionDao.readMaxID());

		System.out.println("READ ALL");
		for (Direccion direccion : direccionDao.readAll()) {
			System.out.println(direccion);
		}

		System.out.println("--------------------------------------------------------------");
		System.out.println("READ 'GAFAUT'");
		Direccion direccionRead = new Direccion();
		direccionRead.setCalle("Gafaut");
		direccionRead.setCp(46114);
		System.out.println(new StringBuffer("Datos de búsqueda: ").append(direccionRead));
		for (Direccion direccionGafaut : direccionDao.read(direccionRead)) {
			System.out.println(direccionGafaut);
		}

		System.out.println("--------------------------------------------------------------");
		System.out.println("CREATE DIRECCION");
		Direccion direccionCreate = new Direccion(null, "Gandia", 10, "Valencia", 46002, "Valencia");
		System.out.println(direccionCreate);
		System.out.println(direccionDao.create(direccionCreate));

		System.out.println("--------------------------------------------------------------");
		System.out.println("READ ALL");
		for (Direccion direccion : direccionDao.readAll()) {
			System.out.println(direccion);
		}

		System.out.println("--------------------------------------------------------------");
		System.out.println("UPDATE");
		Direccion direccionuUpdate = direccionDao.read(direccionCreate).get(0);
		System.out
				.println(new StringBuffer("Datos de actualización: ").append(" Originales: ").append(direccionuUpdate));
		direccionuUpdate.setNumero(12);
		System.out.println(
				new StringBuffer("Datos de actualización: ").append(" Canvio de número: ").append(direccionuUpdate));
		System.out.println(direccionDao.update(direccionuUpdate));

		System.out.println("--------------------------------------------------------------");
		System.out.println("READ ALL");
		for (Direccion direccion : direccionDao.readAll()) {
			System.out.println(direccion);
		}

		System.out.println("--------------------------------------------------------------");
		System.out.println("DELETE 'GAFAUT'");
		Direccion direccionDelete = new Direccion();
		direccionDelete.setId_direccion(3);
		System.out.println(new StringBuffer("Datos de borrado: ").append(direccionDelete));
		System.out.println(direccionDao.delete(direccionDelete));

		System.out.println("--------------------------------------------------------------");
		System.out.println("READ ALL");
		for (Direccion direccion : direccionDao.readAll()) {
			System.out.println(direccion);
		}

		assertNotNull(direccionDao.readAll());
	}

}
