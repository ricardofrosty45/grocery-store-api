package com.grocery.store.ws.mongodb.entities;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "grocery-store")
@Data
@NoArgsConstructor
public class GroceryProductEntity {

	@Id
	private String id;

	private String productName;

	private BigDecimal productValue;

}
