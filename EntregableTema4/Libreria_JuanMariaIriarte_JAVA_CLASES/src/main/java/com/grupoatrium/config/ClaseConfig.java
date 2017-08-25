package com.grupoatrium.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.grupoatrium.persistencia.impl.AutorDao;
import com.grupoatrium.persistencia.impl.AutorDaoImpl;
import com.grupoatrium.persistencia.impl.DireccionDao;
import com.grupoatrium.persistencia.impl.DireccionDaoImpl;
import com.grupoatrium.persistencia.impl.EditorialDao;
import com.grupoatrium.persistencia.impl.EditorialDaoImpl;
import com.grupoatrium.persistencia.impl.LibroDao;
import com.grupoatrium.persistencia.impl.LibroDaoImpl;

@Configuration
@ComponentScan("com.grupoatrium")
@ImportResource("classpath:applicationContext.xml")
public class ClaseConfig {

	@Bean
	public DataSource dataSource() {

		// no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.DERBY).ignoreFailedDrops(true)
				.addScript("com/grupoatrium/db/create-db.sql").addScript("com/grupoatrium/db/insert-data.sql").build();

		return db;
	}

	@Bean
	public NamedParameterJdbcTemplate jdbcTemplate() {

		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource());

		return jdbcTemplate;
	}

	@Bean
	public DireccionDao direccionDao() {
		return new DireccionDaoImpl();
	}

	@Bean
	public AutorDao autorDao() {
		return new AutorDaoImpl();
	}

	@Bean
	public LibroDao libroDao() {
		return new LibroDaoImpl();
	}

	@Bean
	public EditorialDao editorialDao() {
		return new EditorialDaoImpl();
	}

	@Bean
	public DataSourceTransactionManager txManager() {
		DataSourceTransactionManager txManager = new DataSourceTransactionManager(dataSource());

		return txManager;
	}
}
