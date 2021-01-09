package com.akshay.av.AvYT;

/*************** Copyright@2020 Yeppie Technologies..... ***************/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(value = "com.akshay.av.*")
@EnableJpaRepositories(value = "com.akshay.av.repository")
@EntityScan(value = "com.akshay.av.model")
//@EnableWebMvc
public class AvYtApplication {
	public static void main(String[] args) {
		SpringApplication.run(AvYtApplication.class, args);
	}

}
