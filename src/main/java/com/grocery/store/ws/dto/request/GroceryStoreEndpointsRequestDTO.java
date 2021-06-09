package com.grocery.store.ws.dto.request;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GroceryStoreEndpointsRequestDTO {

	private String id;

	private String productName;

	private BigDecimal productValue;

	private String productDescription;

	private String typeOfProduct;

}
