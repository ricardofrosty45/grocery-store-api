package com.grocery.store.ws.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.store.ws.dto.request.GroceryStoreEndpointsRequestDTO;
import com.grocery.store.ws.service.GroceryStoreCrudService;

@CrossOrigin
@RestController
@RequestMapping("/v1/store-product")
public class GroceryStoreCrudEndpoints {

	@Autowired
	private GroceryStoreCrudService service;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	@Retryable(value = Exception.class, maxAttempts = 5, backoff = @Backoff(delay = 2000))
	public ResponseEntity<?> createStoreProduct(@RequestBody GroceryStoreEndpointsRequestDTO request) {

		try {

			return new ResponseEntity<String>("", HttpStatus.CREATED);
		} catch (Exception e) {
			return null;

		}

	}

	@GetMapping
	@Retryable(value = Exception.class, maxAttempts = 5, backoff = @Backoff(delay = 2000))
	public ResponseEntity<?> getAllProducDetails() {
		return null;
	}

	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	@Retryable(value = Exception.class, maxAttempts = 5, backoff = @Backoff(delay = 2000))
	public ResponseEntity<?> updateStoreProduct(@RequestBody GroceryStoreEndpointsRequestDTO request) {
		return null;
	}

	@DeleteMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	@Retryable(value = Exception.class, maxAttempts = 5, backoff = @Backoff(delay = 2000))
	public ResponseEntity<?> deleteStoreProductDetails(@RequestBody GroceryStoreEndpointsRequestDTO request) {
		return null;
	}

}
