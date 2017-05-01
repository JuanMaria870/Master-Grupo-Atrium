package com.grupoatrium.cliente;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.grupoatrium.modelo.Autor;
import com.grupoatrium.modelo.Direccion;
import com.grupoatrium.modelo.Editorial;
import com.grupoatrium.modelo.Libro;
import com.grupoatrium.modelo.extra.AutorExtra;
import com.grupoatrium.modelo.extra.DireccionExtra;
import com.grupoatrium.persistencia.impl.LibrosDAO;

public class AppMain {

	private static Scanner entradaEscaner;

	public static void main(String[] args) {

		// Levantar el contexto de Spring

		// Crear el contenedor de beans a partir del archivo

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(com.grupoatrium.config.ClaseConfig.class);


		// Escáner para recoger la opción seleccionada por consola
		entradaEscaner = new Scanner(System.in);
		String entradaTeclado = "";

		System.out.println("Seleccionar opción");
		System.out.println("0- Lanzar todos");
		System.out.println("1- Declaración de un bean simple");
		System.out.println("2- Declaración de un bean simple y su alias");
		System.out.println("3- Inyección de propiedades");
		System.out.println("4- Inyección de propiedades colección");
		System.out.println("5-7 Incluidos en los anteriores");
		System.out.println("8- Herencia y bean abstracto");
		System.out.println("9- Factorías");
		System.out.println("10- Ciclo de vida - 12- Cargas eager y lazy");
		System.out.println("11- Cargamos el archivo de propiedades base de datos");
		System.out.println("19- Conditional");
		System.out.println("20- Bean Principal");

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
		case "8":
			herenciaYAbstraccion(context);
			break;
		case "9":
			factorias(context);
			break;
		case "10":
			cicloVidaLazy(context);
			break;
		case "11":
			cargaPropiedadesBD(context);
			break;
		case "19":
			conditional(context);
			break;
		case "20":
			principal(context);
			break;
		default:
			declaracionBeanSimple(context);
			declaracionBeanSimpleYAlias(context);
			inyeccionPropiedades(context);
			inyeccionPropiedadesColeccion(context);
			herenciaYAbstraccion(context);
			factorias(context);
			cicloVidaLazy(context);
			cargaPropiedadesBD(context);
			conditional(context);
			principal(context);
			break;
		}

	}

	/**
	 * 1- Declaración de un bean simple
	 * 
	 * @param context
	 */
	public static void declaracionBeanSimple(ApplicationContext context) {
		System.out.println("1- Declaración de un bean simple");
		Autor autor = context.getBean("autor", Autor.class);

		autor.setComentarios("Comentario");
		autor.setNacionalidad("España");
		autor.setNombre("Juan");

		System.out.println(autor);

	}

	/**
	 * 2- Declaración de un bean simple y su alias
	 * 
	 * @param context
	 */
	public static void declaracionBeanSimpleYAlias(ApplicationContext context) {

		System.out.println("2- Declaración de un bean simple y su alias");
		Direccion direccion = context.getBean("direccionAlias", Direccion.class);

		direccion.setCalle("Pl/ Gafaut");
		direccion.setCp(46114);
		direccion.setNumero(666555444);
		direccion.setPoblacion("Vinalesa");
		direccion.setProvincia("Valencia");

		System.out.println(direccion);
	}

	/**
	 * 3- Inyección de propiedades
	 * 
	 * @param context
	 */
	public static void inyeccionPropiedades(ApplicationContext context) {

		System.out.println("3- Inyección de propiedades");
		Editorial editorial = context.getBean("editorial", Editorial.class);

		System.out.println(editorial);
	}

	/**
	 * 4- Inyección de propiedades colección
	 * 
	 * @param context
	 */
	public static void inyeccionPropiedadesColeccion(ApplicationContext context) {

		System.out.println("4- Inyección de propiedades colección");
		Libro libro = context.getBean("libro", Libro.class);

		System.out.println(libro);
	}


	/**
	 * 8- Herencia y bean abstracto
	 * 
	 * @param context
	 */
	public static void herenciaYAbstraccion(ApplicationContext context) {

		System.out.println("8- Herencia y bean abstracto");
		System.out.println("Con clase asociada");
		Autor autor = context.getBean("autor8", Autor.class);

		System.out.println(autor);

	}

	/**
	 * 9- Factoría
	 * 
	 * @param context
	 */
	public static void factorias(ApplicationContext context) {

		System.out.println("9- Factoría");
		System.out.println("Factoría estática");
		DireccionExtra direccion = context.getBean("direccionExtra9_1", DireccionExtra.class);

		System.out.println(direccion);

		System.out.println("Factoría dinámica");
		DireccionExtra direccion2 = context.getBean("direccionExtra9_2", DireccionExtra.class);

		System.out.println(direccion2);
	}

	/**
	 * 10- Ciclo de vida
	 * 12- Cargas eager y lazy
	 * 
	 * Vemos que los beans se cargan al invocar la función
	 * 
	 * @param context
	 */
	public static void cicloVidaLazy(AbstractApplicationContext context) {

		System.out.println("10- Ciclo de vida - 12- Cargas eager y lazy");
		System.out.println("Vemos que los beans se cargan al invocar la función");
		AutorExtra autor = context.getBean("autor_10_1", AutorExtra.class);

		System.out.println(autor);

		AutorExtra autor2 = context.getBean("autor_10_2", AutorExtra.class);

		System.out.println(autor2);

		// Destruye los beans
		context.registerShutdownHook();
	}

	/**
	 * 11 -Cargamos el archivo de propiedades base de datos
	 * 
	 * @param context
	 */
	public static void cargaPropiedadesBD(ApplicationContext context) {

		System.out.println("11 -Cargamos el archivo de propiedades base de datos");

		LibrosDAO librosDAO = context.getBean("librosDAO", LibrosDAO.class);

		System.out.println(librosDAO);


	}
	
	/**
	 * 19- Conditional
	 * 
	 * @param context
	 */
	public static void conditional(ApplicationContext context) {

		System.out.println("19- Conditional");

		Direccion direccion = context.getBean("direccion_19", Direccion.class);
		
		System.out.println(direccion);

	}
	
	/**
	 * 20- Bean Principal
	 * 
	 * @param context
	 */
	public static void principal(ApplicationContext context) {

		System.out.println("20- Bean Principal");

		Autor autor = context.getBean(Autor.class);
		
		System.out.println(autor);

	}
	

}
