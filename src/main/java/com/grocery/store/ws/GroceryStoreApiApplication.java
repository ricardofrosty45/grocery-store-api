package com.grocery.store.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.grocery")
public class GroceryStoreApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroceryStoreApiApplication.class, args);
	}

}
