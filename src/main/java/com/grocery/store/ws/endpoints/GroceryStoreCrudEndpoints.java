package com.grocery.store.ws.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.grocery.store.ws.dto.request.GroceryStoreEndpointsRequestDTO;
import com.grocery.store.ws.dto.response.GroceryStoreResultsResponse;
import com.grocery.store.ws.mongodb.entities.GroceryProductEntity;
import com.grocery.store.ws.service.GroceryStoreCrudService;
import com.grocery.store.ws.util.GroceryStoreUtil;

@CrossOrigin
@RestController
@RequestMapping("/v1/store-product")
public class GroceryStoreCrudEndpoints {

	@Autowired
	private GroceryStoreCrudService service;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> createStoreProduct(@RequestBody GroceryStoreEndpointsRequestDTO request) {
		return new ResponseEntity<GroceryProductEntity>(service.createNewProductIntoGroceryStore(request),
				HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<?> getAllProducDetails() {
		return new ResponseEntity<GroceryStoreResultsResponse>(service.readAllProductData(), HttpStatus.OK);
	}

	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> updateStoreProduct(@RequestBody GroceryStoreEndpointsRequestDTO request) {
		GroceryStoreUtil.checkId(request);
		return new ResponseEntity<GroceryProductEntity>(service.updateGroceryProduct(request), HttpStatus.OK);
	}

	@DeleteMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> deleteStoreProductDetails(@RequestBody GroceryStoreEndpointsRequestDTO request) {
		GroceryStoreUtil.checkId(request);
		service.deleteGroceryStoreProduct(request);
		return new ResponseEntity<String>("Product Deleted!", HttpStatus.OK);
	}

}
