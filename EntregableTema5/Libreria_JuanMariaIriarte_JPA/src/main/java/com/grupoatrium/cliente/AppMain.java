package com.grupoatrium.cliente;

import java.util.HashSet;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DireccionDao direccionDao = context.getBean("direccionDao", DireccionDao.class);
		AutorDao autorDao = context.getBean("autorDao", AutorDao.class);
		LibroDao libroDao = context.getBean("libroDao", LibroDao.class);
		EditorialDao editorialDao = context.getBean("editorialDao", EditorialDao.class);

		System.out.println("**************************************************************");
		System.out.println("************* TEST AUTOR_DAO - TEST DIRECCION_DAO*************");
		System.out.println("**************************************************************");

		System.out.println("--------------------------------------------------------------");
		System.out.println("CREATE AUTOR");
		Autor autorCreate = new Autor(null, "Jose Joaquin", "Italia", "Escritor de comics", null, null);
		System.out.println(autorCreate);
		System.out.println(autorDao.create(autorCreate));

		System.out.println("--------------------------------------------------------------");
		System.out.println("CREATE DIRECCION");
		Direccion direccionCreate = new Direccion(null, "Gandia", 10, "Moncada", 46002, "Valencia");
		direccionCreate.setAutor(autorCreate);
		System.out.println(direccionCreate);
		System.out.println(direccionDao.create(direccionCreate));

		System.out.println("--------------------------------------------------------------");
		System.out.println("CREATE AUTOR 2");
		Autor autorCreate2 = new Autor(null, "Alma Alegre", "España", "Escritora de cuentos", null, null);
		System.out.println(autorCreate2);
		System.out.println(autorDao.create(autorCreate2));

		System.out.println("--------------------------------------------------------------");
		System.out.println("CREATE DIRECCION 2");
		Direccion direccionCreate2 = new Direccion(null, "Enric Valor", 1, "Vinalesa", 46114, "Valencia");
		direccionCreate2.setAutor(autorCreate2);
		System.out.println(direccionCreate2);
		System.out.println(direccionDao.create(direccionCreate2));

		System.out.println("--------------------------------------------------------------");
		System.out.println("READ ALL AUTORES");
		for (Autor autor : autorDao.readAll()) {
			System.out.println(autor);
		}

		System.out.println("--------------------------------------------------------------");
		System.out.println("READ ALL DIRECCIONES");
		for (Direccion direccion : direccionDao.readAll()) {
			System.out.println(direccion);
		}

		System.out.println("--------------------------------------------------------------");
		System.out.println("READ 'ALMA ALEGRE'");
		Autor autorRead = new Autor();
		autorRead.setNombre("Alma Alegre");
		autorRead.setNacionalidad("España");
		System.out.println(new StringBuffer("Datos de búsqueda:").append(autorRead));
		for (Autor autor : autorDao.read(autorRead)) {
			System.out.println(autor);
		}

		System.out.println("--------------------------------------------------------------");
		System.out.println("UPDATE");
		Autor autorUpdate = autorDao.read(autorCreate2).get(0);
		System.out.println(new StringBuffer("Datos de actualización: ").append(" Originales: ").append(autorUpdate));
		autorUpdate.setBibliografia("Biografia Actualizada");
		direccionCreate = direccionDao.read(direccionCreate).get(0);
		autorUpdate.setDireccion(direccionCreate);
		System.out.println(
				new StringBuffer("Datos de actualización: ").append(" Actualización Biografia y dirección: ").append(autorUpdate));
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
		System.out.println(new StringBuffer("Datos de borrado:").append(autorDelte));
		System.out.println(autorDao.delete(autorDelte));

		System.out.println("--------------------------------------------------------------");
		System.out.println("READ ALL");
		for (Autor autor : autorDao.readAll()) {
			System.out.println(autor);
		}

		System.out.println("**************************************************************");
		System.out.println("*********************** TEST LIBRO_DAO ***********************");
		System.out.println("**************************************************************");

		System.out.println("--------------------------------------------------------------");
		System.out.println("CREATE LIBRO");
		Libro libroCreate = new Libro(null, "123456789CO", "Comic 1", null, 2017, 20.50, "Comic de supervillanos");
		System.out.println(libroCreate);
		System.out.println(libroDao.create(libroCreate));

		System.out.println("--------------------------------------------------------------");
		System.out.println("CREATE LIBRO 2");
		Libro libroCreate2 = new Libro(null, "88888888COT", "Novela", null, 2005, 10.50, "Novela grafia");
		System.out.println(libroCreate2);
		System.out.println(libroDao.create(libroCreate2));

		libroCreate2 = libroDao.read(libroCreate2).get(0);
		libroCreate2.getAutores().addAll(new HashSet<Autor>(autorDao.readAll()));
		libroDao.update(libroCreate2);

		System.out.println("--------------------------------------------------------------");
		System.out.println("READ '123456789CO'");
		System.out.println(new StringBuffer("Datos de búsqueda: ").append(libroCreate));
		for (Libro libro : libroDao.read(libroCreate)) {
			System.out.println(libro);
		}

		System.out.println("--------------------------------------------------------------");
		System.out.println("UPDATE LIBRO - LE INDICAMOS EL AUTOR");
		libroCreate = libroDao.read(libroCreate).get(0);
		libroCreate.getAutores().addAll(new HashSet<Autor>(autorDao.readAll()));
		libroDao.update(libroCreate);

		System.out.println("--------------------------------------------------------------");
		System.out.println("READ ALL");
		for (Libro libro : libroDao.readAll()) {
			System.out.println(libro);
		}

		System.out.println("--------------------------------------------------------------");
		System.out.println("DELETE '2'");
		Libro libroDelte = new Libro();
		libroDelte.setId_libro(6);
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

		System.out.println("--------------------------------------------------------------");
		System.out.println("CREATE EDITORIAL");
		Editorial editorialCreate = new Editorial(null, "Editorial Gandia", "123456789T", null);
		System.out.println(editorialCreate);
		System.out.println(editorialDao.create(editorialCreate));
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("UPDATE AÑADIMOS LIBROS");
		Editorial editorialUpdate = editorialDao.read(editorialCreate).get(0);
		System.out
				.println(new StringBuffer("Datos de actualización: ").append(" Originales: ").append(editorialUpdate));
		editorialUpdate.setLibros(libroDao.readAll());
		System.out.println(new StringBuffer("Datos de actualización: ").append(" Añadimos un libro: ")
				.append(editorialUpdate));
		System.out.println(editorialDao.update(editorialUpdate));
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("READ '123456789T'");
		Editorial editorialRead = new Editorial();
		editorialRead.setNif_cif("123456789T");
		System.out.println(new StringBuffer("Datos de búsqueda: ").append(editorialRead));
		for (Editorial editorial : editorialDao.read(editorialRead)) {
			System.out.println(editorial);
		}
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("CREATE EDITORIAL 2 CON UN NUEVO LIBRO");
		Editorial editorialCreate2 = new Editorial(null, "Editorial Vinalesa", "888888888AET", null);
		editorialDao.create(editorialCreate2);
		libroCreate2 = new Libro(null, "88888888COT", "Novela", null, 2005, 10.50, "Novela grafia");
		libroDao.create(libroCreate2);
		libroCreate2 = libroDao.read(libroCreate2).get(0);
		libroCreate2.getAutores().addAll(new HashSet<Autor>(autorDao.readAll()));
		libroDao.update(libroCreate2);
		editorialCreate2 = editorialDao.read(editorialCreate2).get(0);
		editorialCreate2.getLibros().add(libroCreate2);
		editorialDao.update(editorialCreate2);
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("READ ALL");
		for (Editorial editorial : editorialDao.readAll()) {
			System.out.println(editorial);
		}


		System.out.println("--------------------------------------------------------------");
		System.out.println("DELETE '2' Y VEMOS EL BORRADO EN CASCADA");
		Editorial editorialDelte = new Editorial();
		editorialDelte.setId_editorial(8);
		System.out.println(new StringBuffer("Datos de borrado: ").append(editorialDelte));
		System.out.println(editorialDao.delete(editorialDelte));

		System.out.println("--------------------------------------------------------------");
		System.out.println("READ ALL");
		for (Editorial editorial : editorialDao.readAll()) {
			System.out.println(editorial);
		}

	}

}
