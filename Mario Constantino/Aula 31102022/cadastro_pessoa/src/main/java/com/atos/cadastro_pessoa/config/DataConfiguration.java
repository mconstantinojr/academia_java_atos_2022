package com.atos.cadastro_pessoa.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {

	@Bean // Conexão com o banco de dados
	public DataSource dataSource() {
		
		DriverManagerDataSource driveBanco = new DriverManagerDataSource();
		driveBanco.setDriverClassName("org.postgresql.Driver");
		driveBanco.setUrl("jdbc:postgresql://bxi3dh8gkv3sdwuwiywo-postgresql.services.clever-cloud.com:5432/bxi3dh8gkv3sdwuwiywo");
		driveBanco.setUsername("umeq7dqtjsfxdxpvo1sg");
		driveBanco.setPassword("dxk9Iqdv2ry9gXRAhgmQ");
		return driveBanco;
	
	}
	@Bean // Parametros do Hibernate
	public JpaVendorAdapter jpaVendorAdapter() {
		
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.POSTGRESQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
		adapter.setPrepareConnection(true);
		
		
		return adapter;
		
	}
	
	
}
