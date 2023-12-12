package com.todolist.todolistmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TodolistmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistmanagerApplication.class, args);
	}

	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
					.addMapping("/**")
					.allowedOrigins("*")
					.allowedMethods("GET", "POST","PUT", "DELETE");
            }
        };
    }

}
