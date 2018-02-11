package com.fcb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@ComponentScan(basePackages="com.fcb.controller")
public class WebConfig extends WebMvcConfigurerAdapter{

	@Bean
	public InternalResourceViewResolver createViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setSuffix(".jsp");
		resolver.setPrefix("/pages/");
		//resolver.setOrder(2);
		resolver.setViewClass(JstlView.class);
		return resolver;

	}
	
	
/*	@Bean
	public ViewResolver urlBasedViewResolver() {
		UrlBasedViewResolver vr = new UrlBasedViewResolver();
		vr.setPrefix("/pages/");
		vr.setSuffix(".html");
		vr.setViewClass(InternalResourceView.class);
		vr.setOrder(1);
		return vr;
	}*/
	
	 @Override
	   public void addResourceHandlers(ResourceHandlerRegistry registry) {  
	    registry.addResourceHandler("/images/").addResourceLocations("/images/");
	   }
		  
}
