package com.grupoatrium.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.grupoatrium.modelo.Autor;
import com.grupoatrium.modelo.Direccion;
import com.grupoatrium.modelo.extra.AutorExtra;
import com.grupoatrium.modelo.extra.DireccionExtra;
import com.grupoatrium.modelo.extra.ServicioDireccionExtra;
import com.grupoatrium.persistencia.impl.ConnectionMgr;
import com.grupoatrium.persistencia.impl.LibrosDAO;

@Configuration
@ComponentScan("com.grupoatrium")
@ImportResource("classpath:applicationContext.xml")
@PropertySource("classpath:config/data-source.properties") //11- Cargamos el archivo de propiedades base de datos
public class ClaseConfig2 {
	
	@Autowired
	private Environment env;
	
	//8- Herencia y bean abstracto
	
	//No existen Bean's abstractos como tal, pero se puede delcarar una función sin la anotación bean, y utilizarla en beans posteriores
	public Autor autorAbstracto(){
		Autor autor = new Autor();
		autor.setNacionalidad("Español");
		autor.setComentarios("Del director");
		
		return autor;
	}
	
	@Bean("autor8")
	public Autor autor8(){
		Autor autor = autorAbstracto();
		autor.setNombre("Pepe");
		return autor;
	}
	
	//9- Factorías
	@Bean("direccionExtra9_1")
	public DireccionExtra direccionExtra9_1(){
		DireccionExtra.getInstance().setCalle("Pl/ Gafaut");
		DireccionExtra.getInstance().setNumero(666555444);
		DireccionExtra.getInstance().setPoblacion("Vinalesa");
		DireccionExtra.getInstance().setCp(46114);
		DireccionExtra.getInstance().setProvincia("Estática");
		
		return DireccionExtra.getInstance();
	}
	
	@Bean("direccionExtra9_2")
    public DireccionExtra direccionExtra9_2() throws Exception {
		ServicioDireccionExtra servicio = new ServicioDireccionExtra();

        return servicio.getDirection();
    }
	
	//10- Ciclo de vida
	@Bean(name="autor_10_1", initMethod = "initMetodo", destroyMethod = "destroyMetodo")
	@Lazy
	public AutorExtra autor_10_1(){
		AutorExtra autor = new AutorExtra();
		autor.setNacionalidad("Español");
		autor.setComentarios("Del director");
		autor.setNombre("autor_10_1");
		
		return autor;
	}
	
	@Bean(name="autor_10_2", initMethod = "initMetodo2", destroyMethod = "destroyMetodo2")
	@Lazy
	public AutorExtra autor_10_2(){
		AutorExtra autor = new AutorExtra();
		autor.setNacionalidad("Español");
		autor.setComentarios("Del director");
		autor.setNombre("autor_10_1");
		return autor;
	}
	
	//11- Cargamos el archivo de propiedades base de datos
	@Bean 
	public ConnectionMgr connectionMgr(){
		return new ConnectionMgr(env.getProperty("driver"), env.getProperty("url"), env.getProperty("user"), env.getProperty("driver"));
	}
	
	@Bean 
	public LibrosDAO librosDAO(){
		return new LibrosDAO(connectionMgr());
	}
	
	//19- Conditional
	@Bean
	@Lazy
	@Conditional(MyCondition.class)
	public Direccion direccion_19(){
		return new Direccion("Pl/ Gafaut", 666555444, "Vinalesa", 46114, "Valencia");
	}
	
	//20- Bean Principal
	@Bean
	@Primary
	public Autor autorPrimary (){
		return new Autor("autorPrimary","autorPrimary","autorPrimary");
	}

}
