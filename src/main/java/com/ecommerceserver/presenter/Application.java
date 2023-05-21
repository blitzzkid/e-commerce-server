package com.ecommerceserver.presenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.ecommerceserver.core.usecases", "com.ecommerceserver.presenter", "com.ecommerceserver.data.db.jpa"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
