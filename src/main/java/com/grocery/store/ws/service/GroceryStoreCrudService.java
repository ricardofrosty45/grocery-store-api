package com.grocery.store.ws.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import com.grocery.store.ws.dto.request.GroceryStoreEndpointsRequestDTO;
import com.grocery.store.ws.dto.response.GroceryStoreResultsResponse;
import com.grocery.store.ws.exception.DataBaseException;
import com.grocery.store.ws.mongodb.entities.GroceryProductEntity;
import com.grocery.store.ws.mongodb.repository.GroceryStoreRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GroceryStoreCrudService {

	@Autowired
	private GroceryStoreRepository repository;

	public GroceryProductEntity createNewProductIntoGroceryStore(GroceryStoreEndpointsRequestDTO request) {
		log.info("Creating New Product Into Store . . .");
		return repository.insert(new GroceryProductEntity().withProductName(request.getProductName())
				.withProductValue(request.getProductValue()).withProductDescription(request.getProductDescription())
				.withTypeOfProduct(request.getTypeOfProduct()).build());
	}

	@Retryable(value = DataBaseException.class, maxAttempts = 5, backoff = @Backoff(delay = 2000))
	public GroceryStoreResultsResponse readAllProductData() {
		log.info("Consulting Product Into Database . . .");
		List<GroceryProductEntity> listProduct = repository.findAll();
		GroceryStoreResultsResponse response = new GroceryStoreResultsResponse();
		if (listProduct.isEmpty()) {
			log.error("Didn't Have Results!");
			throw new DataBaseException("Didn't Find Any Results Into Database!");
		}
		response.setAllProducts(listProduct);
		return response;

	}

	@Retryable(value = DataBaseException.class, maxAttempts = 5, backoff = @Backoff(delay = 2000))
	public GroceryProductEntity updateGroceryProduct(GroceryStoreEndpointsRequestDTO request) {
		log.info("Consulting Product Into Database . . .");
		Optional<GroceryProductEntity> resultDataBase = repository.findById(request.getId());

		if (resultDataBase.isEmpty()) {
			log.error("Didn't Have Results!");
			throw new DataBaseException(
					"Didn't Find Any Results Into Database! Can't Update Item, Please Inform an Valid Id!");
		}

		GroceryProductEntity entity = resultDataBase.get();

		entity.setProductName(request.getProductName());
		entity.setProductValue(request.getProductValue());
		entity.setProductDescription(request.getProductDescription());
		entity.setTypeOfProduct(request.getTypeOfProduct());

		return repository.insert(entity);
	}

	@Retryable(value = DataBaseException.class, maxAttempts = 5, backoff = @Backoff(delay = 2000))
	public void deleteGroceryStoreProduct(GroceryStoreEndpointsRequestDTO request) {
		log.info("Consulting Product Into Database . . .");
		Optional<GroceryProductEntity> resultDataBase = repository.findById(request.getId());

		if (resultDataBase.isEmpty()) {
			log.error("Didn't Have Results!");
			throw new DataBaseException(
					"Didn't Find Any Results Into Database! Can't Update Item, Please Inform an Valid Id!");
		}
		log.info("Deleting Product Into Database . . .");
		repository.delete(resultDataBase.get());
	}

}
