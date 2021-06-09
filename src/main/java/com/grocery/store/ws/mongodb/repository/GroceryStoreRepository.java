package com.grocery.store.ws.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.grocery.store.ws.mongodb.entities.GroceryProductEntity;

@Repository
public interface GroceryStoreRepository extends MongoRepository<GroceryProductEntity, String> {

}
