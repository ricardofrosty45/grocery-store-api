package com.grocery.store.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.store.ws.mongodb.repository.GroceryStoreRepository;
import com.grocery.store.ws.util.GroceryStoreUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GroceryStoreCrudService {

	@Autowired
	private GroceryStoreRepository repository;

	public void createNewProductIntoGroceryStore() {
		log.info("Creating New Product Into Store . . .");
		
		repository.insert(GroceryStoreUtil.fromDtoToEntiyProduct(request))

	}

}
