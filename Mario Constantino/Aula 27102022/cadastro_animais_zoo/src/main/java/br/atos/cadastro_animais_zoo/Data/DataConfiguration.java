package br.atos.cadastro_animais_zoo.Data;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {

	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource driveBanco = new DriverManagerDataSource();
		driveBanco.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driveBanco.setUrl("jdbc:mysql://bc2907vvsrno7lhoy8di-mysql.services.clever-cloud.com/bc2907vvsrno7lhoy8di?useTimezone=true&serverTimezone=UTC");
		driveBanco.setUsername("uxkqgehuklhxhjel");
		driveBanco.setPassword("BD5pyBlQlhirSphn6PkW");
		return driveBanco;
	
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL8Dialect");
		adapter.setPrepareConnection(true);
		
		
		return adapter;
		
	}
}
