package com.ms.book.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.mysql.cj.jdbc.Driver;

import jakarta.persistence.EntityManagerFactory;


@Configuration
@ComponentScan(basePackages = "com.ms.book.root")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.ms.book.root.repo")
public class DatabaseConfig {

	@Bean
	DataSource dataSource() {
		var ds = new BasicDataSource();
		ds.setDriverClassName(Driver.class.getName());
		ds.setUrl("jdbc:mysql://localhost:3306/books_db_ms");
		ds.setUsername("ms");
		ds.setPassword("msadmin");
		return ds;
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) throws IOException {
		var bean = new  LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource);
		bean.setPackagesToScan("com.ms.book.root.entity");
		bean.setJpaProperties(properties());
		bean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		return bean;
	}
	
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	
	@Bean
	ReloadableResourceBundleMessageSource messageSource() {
		var source= new ReloadableResourceBundleMessageSource();
		source.setBasenames("classpath:messages");
		source.setDefaultEncoding("UTF-8");
		return source;
	}
	
	@Bean
	Validator validator() {
		var validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(messageSource());
		return validator;
	}
	
	private Properties properties() throws IOException {
		var prop = new Properties();
		prop.load(getClass().getResourceAsStream("/jpa.properties"));
		return prop;
	}
}
