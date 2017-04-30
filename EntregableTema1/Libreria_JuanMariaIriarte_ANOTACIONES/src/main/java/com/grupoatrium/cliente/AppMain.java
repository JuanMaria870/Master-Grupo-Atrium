package com.grupoatrium.cliente;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.grupoatrium.modelo.Autor;
import com.grupoatrium.modelo.Direccion;
import com.grupoatrium.modelo.Editorial;
import com.grupoatrium.modelo.Libro;
import com.grupoatrium.modelo.extra.AutorExtra;
import com.grupoatrium.modelo.extra.DireccionExtra;
import com.grupoatrium.modelo.extra.LibrosExtraDAO;
import com.grupoatrium.modelo.qualifed.UsaObjetoQImplementaInt;
import com.grupoatrium.persistencia.impl.EditorialesDAO;
import com.grupoatrium.persistencia.impl.LibrosDAO;

public class AppMain {

	private static Scanner entradaEscaner;

	public static void main(String[] args) {

		// Levantar el contexto de Spring

		// Crear el contenedor de beans a partir del archivos

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Escaner para recoger la opci�n seleccionada por consola
		entradaEscaner = new Scanner(System.in);
		String entradaTeclado = "";

		System.out.println("Seleccionar opci�n");
		System.out.println("0- Lanzar todos");
		System.out.println("1- Declaraci�n de un bean simple");
		System.out.println("2- Declaraci�n de un bean simple y su alias");
		System.out.println("3- Inyecci�n de propiedades");
		System.out.println("4- Inyecci�n de propiedades colecci�n");
		System.out.println("5-9 Estos ejercicios no tienen versi�n en anotaci�n");
		System.out.println("10- Ciclo de vida");
		System.out.println("11- Cargamos el archivo de propiedades base de datos - Required");
		System.out.println("12-Cargas eager y lazy");
		System.out.println("14-16 Estos ejercicios no tienen versi�n en anotaci�n");
		System.out.println("17- Autowire");
		System.out.println("18- Qualified");

		entradaTeclado = entradaEscaner.nextLine();
		switch (entradaTeclado) {
		case "1":
			declaracionBeanSimple(context);
			break;
		case "2":
			declaracionBeanSimpleYAlias(context);
			break;
		case "3":
			inyeccionPropiedades(context);
			break;
		case "4":
			inyeccionPropiedadesColeccion(context);
			break;
		case "10":
			cicloVida(context);
			break;
		case "11":
			cargaPropiedadesBD_Required(context);
			break;
		case "12":
			cargaLazy(context);
			break;
		case "17":
			autowire(context);
			break;
		case "18":
			qualified(context);
			break;

		default:
			declaracionBeanSimple(context);
			declaracionBeanSimpleYAlias(context);
			inyeccionPropiedades(context);
			inyeccionPropiedadesColeccion(context);
			cicloVida(context);
			cargaPropiedadesBD_Required(context);
			cargaLazy(context);
			autowire(context);
			qualified(context);
			break;
		}

	}

	/**
	 * 1- Declaraci�n de un bean simple
	 * 
	 * @param context
	 */
	public static void declaracionBeanSimple(ApplicationContext context) {
		System.out.println("1- Declaraci�n de un bean simple");
		Autor autor = context.getBean("autor", Autor.class);

		autor.setComentarios("Comentario");
		autor.setNacionalidad("Espa�a");
		autor.setNombre("Juan");

		System.out.println(autor);

	}

	/**
	 * 2- Declaraci�n de un bean simple y su alias
	 * 
	 * @param context
	 */
	public static void declaracionBeanSimpleYAlias(ApplicationContext context) {

		System.out.println("2- Declaraci�n de un bean simple y su alias");
		Direccion direccion = context.getBean("direccionAlias", Direccion.class);

		direccion.setCalle("Pl/ Gafaut");
		direccion.setCp(46114);
		direccion.setNumero(666555444);
		direccion.setPoblacion("Vinalesa");
		direccion.setProvincia("Valencia");

		System.out.println(direccion);
	}

	/**
	 * 3- Inyecci�n de propiedades
	 * 
	 * @param context
	 */
	public static void inyeccionPropiedades(ApplicationContext context) {

		System.out.println("3- Inyecci�n de propiedades");
		Editorial editorial = context.getBean("editorial", Editorial.class);

		System.out.println(editorial);
	}

	/**
	 * 4- Inyecci�n de propiedades colecci�n
	 * 
	 * @param context
	 */
	public static void inyeccionPropiedadesColeccion(ApplicationContext context) {

		System.out.println("4- Inyecci�n de propiedades colecci�n");
		Libro libro = context.getBean("libro", Libro.class);

		System.out.println(libro);
	}

	/**
	 * 10- Ciclo de vida
	 * 
	 * @param context
	 */
	public static void cicloVida(AbstractApplicationContext context) {

		System.out.println("10- Ciclo de vida");
		System.out.println("Init y destroy por defecto declarados en el contexto");
		AutorExtra autor = context.getBean("autorExtra", AutorExtra.class);

		System.out.println(autor);

		// Destruye los beans
		// context.registerShutdownHook();
	}

	/**
	 * 11 -Cargamos el archivo de propiedades base de datos
	 * 
	 * 13 -Obligamos a que tengan las conexi�n a BD
	 * 
	 * @param context
	 */
	public static void cargaPropiedadesBD_Required(ApplicationContext context) {

		System.out.println("11 -Cargamos el archivo de propiedades base de datos");

		LibrosDAO librosDao = context.getBean("librosDAO", LibrosDAO.class);

		System.out.println(librosDao);

		EditorialesDAO editorialesDao = context.getBean("editorialesDAO", EditorialesDAO.class);

		System.out.println(editorialesDao);

	}

	/**
	 * 12-Cargas eager y lazy
	 * 
	 * Vemos que se carga al invocar la funci�n
	 * 
	 * @param context
	 */
	public static void cargaLazy(ApplicationContext context) {

		System.out.println("12-Cargas eager y lazy");
		System.out.println("Vemos que la funci�n que se lanza al crear el bean se lanza al invocar la funci�n");

		DireccionExtra direccionExtra = context.getBean("direccionExtra", DireccionExtra.class);

		System.out.println(direccionExtra);

	}

	/**
	 * 17- Autowire
	 * 
	 * @param context
	 */
	public static void autowire(ApplicationContext context) {

		System.out.println("17- Autowire");

		LibrosExtraDAO librosExtraDAO = context.getBean("librosExtraDAO", LibrosExtraDAO.class);
		System.out.println(librosExtraDAO);

	}

	/**
	 * 18- Qualified
	 * 
	 * @param context
	 */
	public static void qualified(ApplicationContext context) {

		System.out.println("18- Qualified");

		UsaObjetoQImplementaInt usaObjetoQImplementaInt = context.getBean("usaObjetoQImplementaInt",
				UsaObjetoQImplementaInt.class);
		usaObjetoQImplementaInt.getTest().metodo1();
		usaObjetoQImplementaInt.getTest2().metodo1();

	}

}
