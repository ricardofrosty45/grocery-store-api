package com.grocery.store.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableMongoRepositories("com.grocery.store.ws.mongodb.repository")
@EnableRetry
public class GroceryStoreApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroceryStoreApiApplication.class, args);
	}

}
