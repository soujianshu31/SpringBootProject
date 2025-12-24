package com.pg.accommodation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.test.model")
@EnableJpaRepositories(basePackages = "com.test.repository")
@ComponentScan(basePackages = {
        "com.pg.accommodation",
        "com.test.controller",
        "com.test.service",
        "com.test.service.impl"
})
public class PgAccommodationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PgAccommodationApplication.class, args);
	}

}
