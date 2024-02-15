package com.lecoded.secureBankSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
public class SecureBankSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecureBankSystemApplication.class, args);
	}

}