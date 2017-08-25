package com.grupoatrium.cliente;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.grupoatrium.config.ClaseConfig;
import com.grupoatrium.modelo.Autor;
import com.grupoatrium.modelo.Direccion;
import com.grupoatrium.modelo.Editorial;
import com.grupoatrium.modelo.Libro;
import com.grupoatrium.persistencia.impl.AutorDao;
import com.grupoatrium.persistencia.impl.DireccionDao;
import com.grupoatrium.persistencia.impl.EditorialDao;
import com.grupoatrium.persistencia.impl.LibroDao;

public class AppMain {

	private static AbstractApplicationContext context;

	public static void main(String[] args) {
		//context = new ClassPathXmlApplicationContext("applicationContext.xml");
		context = new AnnotationConfigApplicationContext(ClaseConfig.class);

		DireccionDao direccionDao = context.getBean("direccionDao", DireccionDao.class);
		AutorDao autorDao = context.getBean("autorDao", AutorDao.class);
		LibroDao libroDao = context.getBean("libroDao", LibroDao.class);
		EditorialDao editorialDao = context.getBean("editorialDao", EditorialDao.class);

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
		libroUpdate = libroDao.read(new Libro(2,null,null,null,null,null,null, null, null)).get(0);
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
		

	}

}
