package com.grocery.store.ws.util;

import com.grocery.store.ws.dto.request.GroceryStoreEndpointsRequestDTO;
import com.grocery.store.ws.exception.RequestIsWrongException;

import lombok.experimental.UtilityClass;

@UtilityClass
public class GroceryStoreUtil {

	public void checkRequest(GroceryStoreEndpointsRequestDTO request) {
		if (request.getProductName() == null) {
			throw new RequestIsWrongException("Please, Inform The Product Name!", "productName");
		}
	}
}
