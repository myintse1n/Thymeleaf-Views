package com.ms.thymeleaf.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration.Dynamic;

public class ApplicationLoader extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {
			WebMvcConfig.class,
			DatabaseConfig.class
		};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/home"};
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setLoadOnStartup(1);
		registration.setMultipartConfig(new MultipartConfigElement(""));
	}
}
