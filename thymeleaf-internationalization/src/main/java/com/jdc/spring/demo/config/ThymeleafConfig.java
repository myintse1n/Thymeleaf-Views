package com.jdc.spring.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
@Configuration
public class ThymeleafConfig {

	@Bean
	SpringResourceTemplateResolver templateResolver() {
		var resolver = new SpringResourceTemplateResolver();
		resolver.setPrefix("classpath:/templates/");
		resolver.setSuffix(".html");
		resolver.setCacheable(false);
		return resolver;
	}
	
	@Bean
	SpringTemplateEngine templateEngine(SpringResourceTemplateResolver templateResolver) {
		var engine = new SpringTemplateEngine();
		engine.setTemplateResolver(templateResolver);
		return engine;
	}
	
	@Bean
	ThymeleafViewResolver viewResolver(SpringTemplateEngine engine) {
		var resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(engine);
		resolver.setContentType("text/html");
		return resolver;
	}
}


