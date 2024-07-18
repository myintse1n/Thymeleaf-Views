package com.jdc.spring.demo.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class InternationalizationConfig {

	@Bean
	MessageSource messageSource() {
		var messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("inter/app_labels");
		return messageSource;
	}
	
	@Bean
	LocaleResolver localeResolver() {
		return new SessionLocaleResolver();
	}
	
	@Bean
	LocaleChangeInterceptor localeChangeInterceptor() {
		var interceptor =  new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}
}
