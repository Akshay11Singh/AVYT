package com.akshay.av.AvYT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/***Code Done for Yeppie Technologies...***/
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

/*@Component
@ConfigurationProperties
@Validated
 class GlobalProperties {
	 @Value(spring.jpa.properties.hibernate.jdbc.batch_size)
    private int batchSize;

	public int getThreadPool() {
		return threadPool;
	}

	public void setThreadPool(int threadPool) {
		this.threadPool = threadPool;
	}

    //getters and setters
}

*/