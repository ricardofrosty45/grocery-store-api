package com.grocery.store.ws.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.grocery.store.ws.mongodb.entities.GroceryProductEntity;

@Repository
public interface GroceryStoreRepository extends MongoRepository<GroceryProductEntity, String> {

	@Query(value = "{ 'productName' : ?0 }")
	GroceryProductEntity findByProductName(String productName);
}
