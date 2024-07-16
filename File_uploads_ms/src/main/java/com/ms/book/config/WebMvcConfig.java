package com.ms.book.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

import com.ms.book.mvc.formatter.CategoryFormatter;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ms.book.mvc")
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Autowired
	private CategoryFormatter categoryFormatter;
	
	@Autowired
	private Validator validator;

	@Bean
	SpringResourceTemplateResolver resourceTemplateResolver() {
		var resolver = new SpringResourceTemplateResolver();
		resolver.setPrefix("/templates/");
		resolver.setSuffix(".html");
		resolver.setCacheable(false);
		return resolver;
	}
	
	@Bean
	SpringTemplateEngine engine(SpringResourceTemplateResolver resolver) {
		var engine = new SpringTemplateEngine();
		engine.setTemplateResolver(resolver);
		return engine;
	}
	
	@Bean
	ThymeleafViewResolver viewResolver(SpringTemplateEngine engine) {
		var resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(engine);
		return resolver;
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/home");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/**");
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(categoryFormatter);
	}
	
	@Override
	public Validator getValidator() {
		return validator;
	}
}
