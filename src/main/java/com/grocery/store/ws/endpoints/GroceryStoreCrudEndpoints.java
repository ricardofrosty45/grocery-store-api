package com.grocery.store.ws.endpoints;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/v1/store-product")
public class GroceryStoreCrudEndpoints {

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> createStoreProduct(@RequestBody String body) {
		return null;
	}

	@GetMapping
	public ResponseEntity<?> getAllProducDetails() {
		return null;
	}

	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> updateStoreProduct(@RequestBody String body) {
		return null;
	}

	@DeleteMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> deleteStoreProductDetails(@RequestBody String body) {
		return null;
	}

}
