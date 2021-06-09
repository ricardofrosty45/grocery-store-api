package com.grocery.store.ws.mongodb.entities;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.grocery.store.ws.util.Builder;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "grocery-store")
@Data
@NoArgsConstructor
public class GroceryProductEntity extends Builder {

	@Id
	private String id;

	private String productName;

	private BigDecimal productValue;

	private String productDescription;

	private String typeOfProduct;

}
