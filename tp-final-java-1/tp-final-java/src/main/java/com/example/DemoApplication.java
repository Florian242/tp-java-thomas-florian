package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.example.service" })
@ComponentScan(basePackages = { "com.example.controller" })


public class DemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
        AnnotationConfigApplicationContext actx = new AnnotationConfigApplicationContext(com.example.initializer.Initializer.class);
        SpringApplication.run(DemoApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(DemoApplication.class);

	}




}
