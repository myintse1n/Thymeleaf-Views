package com.ms.thymeleaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.ms.thymeleaf.controller")
public class WebMvcConfig implements WebMvcConfigurer {

	@Bean
	SpringResourceTemplateResolver templateResolver() {
		var templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setPrefix("/templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setCacheable(false);
		return templateResolver;
	}

	@Bean
	SpringTemplateEngine engine() {
		var engine = new SpringTemplateEngine();
		engine.setTemplateResolver(templateResolver());
		return engine;
	}

	@Bean
	ThymeleafViewResolver viewResolver(SpringTemplateEngine engine) {
		var viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(engine);
		return viewResolver;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "home");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/**");
	}
}
