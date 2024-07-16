package com.ms.thymeleaf.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@ComponentScan("com.ms.thymeleaf.model.service")
@EnableJpaRepositories("com.ms.thymeleaf.model.repo")
@EnableTransactionManagement
public class DatabaseConfig {

	@Bean
	DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.build();
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() throws IOException {
		var emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan("com.ms.thymeleaf.model.entity");
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		emf.setJpaProperties(properties());
		return emf;
	}
	
	
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return  new JpaTransactionManager(emf);
	}
	
	private Properties properties() throws IOException {
		var prop = new Properties();
		prop.load(getClass().getResourceAsStream("/jpa.properties"));
		return prop;
	}
	
}
