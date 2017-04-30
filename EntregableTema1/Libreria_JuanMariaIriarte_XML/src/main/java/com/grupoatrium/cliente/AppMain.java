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
import com.grupoatrium.modelo.extra.EditorialExtra;
import com.grupoatrium.persistencia.impl.EditorialesDAO;
import com.grupoatrium.persistencia.impl.LibrosDAO;

public class AppMain {

	private static Scanner entradaEscaner;

	public static void main(String[] args) {

		// Levantar el contexto de Spring

		// Crear el contenedor de beans a partir del archivo

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Trabajar con mas de un fichero de configuración declarándolos en la
		// variable contexto

		// AbstractApplicationContext context = new
		// ClassPathXmlApplicationContext("applicationContext-1-6.xml",
		// "applicationContext-7-12.xml", "applicationContext-13-17.xml");

		// Crear el contenedor a partir de un fichero que importa los demás
		// AbstractApplicationContext context = new
		// ClassPathXmlApplicationContext("applicationContext-imports.xml");

		// Escaner para recoger la opción seleccionada por consola
		entradaEscaner = new Scanner(System.in);
		String entradaTeclado = "";

		System.out.println("Seleccionar opción");
		System.out.println("0- Lanzar todos");
		System.out.println("1- Declaración de un bean simple");
		System.out.println("2- Declaración de un bean simple y su alias");
		System.out.println("3- Inyección de propiedades");
		System.out.println("4- Inyección de propiedades colección");
		System.out.println("5- Inyección de dependencias a través del constructor");
		System.out.println("6- Bean Anónimo");
		System.out.println("7- Bean Interno");
		System.out.println("8- Herencia y bean abstracto");
		System.out.println("9- Factorías");
		System.out.println("10- Ciclo de vida");
		System.out.println("11 -Cargamos el archivo de propiedades base de datos");
		System.out.println("12-Cargas eager y lazy");
		System.out.println("13- Ámbitos de un bean");
		System.out.println("14- Espacio de nombre c");
		System.out.println("15- Espacio de nombre p");
		System.out.println("16- Espacio de nombre útils");
		System.out.println("17- Autowire");

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
		case "5":
			inyeccionDeDependenciaConstructor(context);
			break;
		case "6":
			beanAnonimo(context);
			break;
		case "7":
			beanInterno(context);
			break;
		case "8":
			herenciaYAbstraccion(context);
			break;
		case "9":
			factorias(context);
			break;
		case "10":
			cicloVida(context);
			break;
		case "11":
			cargaPropiedadesBD(context);
			break;
		case "12":
			cargaLazy(context);
			break;
		case "13":
			ambitosBean(context);
			break;
		case "14":
			espacioNombresC(context);
			break;
		case "15":
			espacioNombresP(context);
			break;
		case "16":
			espacioNombresUtils(context);
			break;
		case "17":
			autowire(context);
			break;
		default:
			declaracionBeanSimple(context);
			declaracionBeanSimpleYAlias(context);
			inyeccionPropiedades(context);
			inyeccionPropiedadesColeccion(context);
			inyeccionDeDependenciaConstructor(context);
			beanAnonimo(context);
			beanInterno(context);
			herenciaYAbstraccion(context);
			factorias(context);
			cicloVida(context);
			cargaPropiedadesBD(context);
			cargaLazy(context);
			ambitosBean(context);
			espacioNombresC(context);
			espacioNombresP(context);
			espacioNombresUtils(context);
			autowire(context);
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
	 * 5- Inyección de dependencias a través del constructor
	 * 
	 * @param context
	 */
	public static void inyeccionDeDependenciaConstructor(ApplicationContext context) {

		System.out.println("5- Inyección de dependencias a través del constructor");
		System.out.println("sin argumentos");
		Autor autor1 = context.getBean("autor5.1", Autor.class);
		System.out.println(autor1 + "\n");

		System.out.println("con argumentos");
		Autor autor2 = context.getBean("autor5.2", Autor.class);
		System.out.println(autor2 + "\n");

		System.out.println("resolver ambigüedad del tipo, lo especificamos");
		Autor autor3 = context.getBean("autor5.3", Autor.class);
		System.out.println(autor3 + "\n");

		System.out.println("resolver ambigüedad indicando la posición del argumento en el constructor");
		Editorial editorial4 = context.getBean("editorial5.4", Editorial.class);
		System.out.println(editorial4 + "\n");

		System.out.println("resolver ambigüedad indicando el nombre del argumento");
		Direccion direccion5 = context.getBean("direccion5.5", Direccion.class);
		System.out.println(direccion5 + "\n");
	}

	/**
	 * 6- Bean Anónimo
	 * 
	 * @param context
	 */
	public static void beanAnonimo(ApplicationContext context) {

		System.out.println("6- Bean Anónimo");
		Autor autor = context.getBean("com.grupoatrium.modelo.Autor#0", Autor.class);

		System.out.println(autor);
	}

	/**
	 * 7- Bean Interno
	 * 
	 * @param context
	 */
	public static void beanInterno(ApplicationContext context) {

		System.out.println("7- Bean Interno");
		Libro libro = context.getBean("libro2", Libro.class);

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
		Autor autor = context.getBean("autor8.2", Autor.class);

		System.out.println(autor);

		System.out.println("Sin clase asociada");
		Autor autor2 = context.getBean("autor8.4", Autor.class);

		System.out.println(autor2);
	}

	/**
	 * 9- Factoría
	 * 
	 * @param context
	 */
	public static void factorias(ApplicationContext context) {

		System.out.println("9- Factoría");
		System.out.println("Factoría estática");
		DireccionExtra direccion = context.getBean("direccionExtra9.1", DireccionExtra.class);

		System.out.println(direccion);

		System.out.println("Factoría dinámica");
		DireccionExtra direccion2 = context.getBean("direccionExtra9.2", DireccionExtra.class);

		System.out.println(direccion2);
	}

	/**
	 * 10- Ciclo de vida
	 * 
	 * @param context
	 */
	public static void cicloVida(AbstractApplicationContext context) {

		System.out.println("10- Ciclo de vida");
		System.out.println("Init y destroy por defecto declarados en el contexto");
		AutorExtra autor = context.getBean("autor10.1", AutorExtra.class);

		System.out.println(autor);

		System.out.println("Init y destroy especificos declarados en el bean");
		AutorExtra autor2 = context.getBean("autor10.2", AutorExtra.class);

		System.out.println(autor2);

		// Destruye los beans
		// context.registerShutdownHook();
	}

	/**
	 * 11 -Cargamos el archivo de propiedades base de datos
	 * 
	 * @param context
	 */
	public static void cargaPropiedadesBD(ApplicationContext context) {

		System.out.println("11 -Cargamos el archivo de propiedades base de datos");

		LibrosDAO librosDao = context.getBean("librosDao", LibrosDAO.class);

		System.out.println(librosDao);

		EditorialesDAO editorialesDao = context.getBean("editorialesDao", EditorialesDAO.class);

		System.out.println(editorialesDao);

	}

	/**
	 * 12-Cargas eager y lazy
	 * 
	 * Vemos que se carga al invocar la función
	 * 
	 * @param context
	 */
	public static void cargaLazy(ApplicationContext context) {

		System.out.println("12-Cargas eager y lazy");
		System.out.println("Vemos que la función que se lanza al crear el bean se lanza al invocar la función");

		AutorExtra autor = context.getBean("autor12", AutorExtra.class);

		System.out.println(autor);

	}

	/**
	 * 13- Ámbitos de un bean
	 * 
	 * @param context
	 */
	public static void ambitosBean(ApplicationContext context) {

		System.out.println("13- Ámbitos de un bean");

		System.out.println("Singleton");
		AutorExtra autor = context.getBean("autor13.1", AutorExtra.class);
		AutorExtra autor2 = context.getBean("autor13.1", AutorExtra.class);
		System.out.println("Comprobamos si son el mismo bean, además solo vemos la creación de un unico bean");
		System.out.println("Es la misma instancia ? " + (autor == autor2));

		System.out.println("Prototype");
		AutorExtra autor3 = context.getBean("autor13.2", AutorExtra.class);
		AutorExtra autor4 = context.getBean("autor13.2", AutorExtra.class);
		System.out.println("Comprobamos si son el mismo bean, además vemos dos creaciones bean");
		System.out.println("Es la misma instancia ? " + (autor3 == autor4));

	}

	/**
	 * 14- Espacio de nombre c
	 * 
	 * @param context
	 */
	public static void espacioNombresC(ApplicationContext context) {

		System.out.println("14- Espacio de nombre c");

		Autor autor = context.getBean("autor14.1", Autor.class);
		System.out.println(autor);

		Autor autor2 = context.getBean("autor14.2", Autor.class);
		System.out.println(autor2);

		EditorialesDAO editorialesDao = context.getBean("editorialesDao14.3", EditorialesDAO.class);
		System.out.println(editorialesDao);

	}

	/**
	 * 15- Espacio de nombre p
	 * 
	 * @param context
	 */
	public static void espacioNombresP(ApplicationContext context) {

		System.out.println("15- Espacio de nombre p");

		Autor autor = context.getBean("autor15.1", Autor.class);
		System.out.println(autor);

	}

	/**
	 * 16- Espacio de nombres útil
	 * 
	 * @param context
	 */
	public static void espacioNombresUtils(ApplicationContext context) {

		System.out.println("16- Espacio de nombres util");

		EditorialExtra editorial = context.getBean("editorial16.1", EditorialExtra.class);
		System.out.println(editorial);

		EditorialExtra editorial2 = context.getBean("editorial16.2", EditorialExtra.class);
		System.out.println(editorial2);

	}

	/**
	 * 17- Autowire
	 * 
	 * @param context
	 */
	public static void autowire(ApplicationContext context) {

		System.out.println("17- Autowire");

		EditorialesDAO editorialDao = context.getBean("editorialesDaoAutorwire", EditorialesDAO.class);
		System.out.println(editorialDao);

	}

}
