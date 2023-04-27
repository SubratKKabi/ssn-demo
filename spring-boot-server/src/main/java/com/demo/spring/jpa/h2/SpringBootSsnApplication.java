package com.demo.spring.jpa.h2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.demo.spring"})
public class SpringBootSsnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSsnApplication.class, args);
	}

}
