package com.springboot.web.springbootfirstwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.springboot.web")

public class UserInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserInfoApplication.class, args);
	}
}
