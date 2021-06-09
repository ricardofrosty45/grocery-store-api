package com.grocery.store.ws.dto.response;

import java.util.List;

import com.grocery.store.ws.mongodb.entities.GroceryProductEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GroceryStoreResultsResponse {

	private List<GroceryProductEntity> allProducts;

}
