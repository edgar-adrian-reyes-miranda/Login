package com.logueo.spring;

import com.logueo.spring.Services.ActividadesServices;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LoginApplication implements CommandLineRunner {
	@Resource
	ActividadesServices actividadesServices;

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	actividadesServices.deleteall();
	actividadesServices.init();
	}
}
