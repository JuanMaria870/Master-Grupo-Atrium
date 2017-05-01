package com.grupoatrium.config;

import java.util.List;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import com.grupoatrium.modelo.Autor;
import com.grupoatrium.modelo.Direccion;
import com.grupoatrium.modelo.Editorial;
import com.grupoatrium.modelo.Libro;


@Configuration
@ComponentScan("com.grupoatrium")
@ImportResource("classpath:applicationContext.xml")
@PropertySource("classpath:config/data-source.properties") //11- Cargamos el archivo de propiedades base de datos
public class ClaseConfig1 {

	//1- Declaración de un bean simple
	@Bean
	public Autor autor(){
		return new Autor();
	}

	//2- Declaración de un bean simple y su alia
	@Bean(name="direccionAlias")
	public Direccion direccionAlias(){
		return new Direccion();
	}
	
	//3- Inyección de propiedades
	@Bean
	public Direccion direccion(){
		return new Direccion("Pl/ Gafaut", 666555444, "Vinalesa", 46114, "Valencia");
	}
	@Bean
	public Editorial editorial(){
		return new Editorial("Almixu",direccion(),"34567890A");
	}
	
	//4- Inyección de propiedades colección
	@Bean
	public Libro libro(){
		Libro libro = new Libro();
		
		List<Autor> autores = new ArrayList<Autor>();
		autores.add(autor());
		autores.add(new Autor("Pedro", "Español", "Del Director"));
		autores.add(new Autor("Anónimo", "Español", "Anónimo"));
		libro.setAutores(autores);
		
		libro.setDescripcion("Chachiguay");
		libro.setEditorial(editorial());
		libro.setIsbn("345678910-A-356-BT");
		libro.setPrecio(19.50);
		libro.setPublicacion(3000);
		libro.setTitulo("Almixuwanadu");
		return libro;
	}

}
