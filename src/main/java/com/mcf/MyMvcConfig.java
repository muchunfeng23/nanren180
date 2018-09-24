package com.mcf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mcf.filter.SessionInterceptor;

@Configuration
@EnableWebMvc
public class MyMvcConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public SessionInterceptor sessionInterceptor(){
		return new SessionInterceptor();
	}
	
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(sessionInterceptor());
	}
	
}
