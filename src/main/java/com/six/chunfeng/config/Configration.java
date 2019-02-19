package com.six.chunfeng.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class Configration extends WebMvcConfigurerAdapter {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//registry.addResourceHandler("/user/**").addResourceLocations("file:D:/userfile/");
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

		super.addResourceHandlers(registry);
	}
}