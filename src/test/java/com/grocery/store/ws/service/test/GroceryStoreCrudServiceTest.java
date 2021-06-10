package com.grocery.store.ws.service.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.grocery.store.ws.dto.request.GroceryStoreEndpointsRequestDTO;
import com.grocery.store.ws.exception.DataBaseException;
import com.grocery.store.ws.mongodb.entities.GroceryProductEntity;
import com.grocery.store.ws.mongodb.repository.GroceryStoreRepository;
import com.grocery.store.ws.service.GroceryStoreCrudService;

@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureDataMongo
public class GroceryStoreCrudServiceTest {

	@Autowired
	private GroceryStoreCrudService service;

	@Autowired
	private GroceryStoreRepository repository;

	@Test
	public void shouldCreateNewProduct() {
		GroceryStoreEndpointsRequestDTO request = new GroceryStoreEndpointsRequestDTO();
		request.setProductDescription("123");
		request.setProductName("123");
		request.setProductValue(BigDecimal.ZERO);
		request.setTypeOfProduct("123");

		GroceryProductEntity returnService = service.createNewProductIntoGroceryStore(request);

		assertNotNull(returnService);

	}

	@Test
	public void shouldReadAllData() {
		repository.save(new GroceryProductEntity().withProductName("TestName").withProductValue(BigDecimal.ZERO)
				.withProductDescription("DescriptionTest").withTypeOfProduct("TypeTest").build());

		assertThat(service.readAllProductData()).isNotNull();

	}

	@Test
	public void shouldNotReadAllDatabaseException() {
		repository.deleteAll();

		assertThrows(DataBaseException.class, () -> service.readAllProductData());

	}

	@Test
	public void shouldNotUpdateDatabaseException() {
		repository.deleteAll();

		GroceryStoreEndpointsRequestDTO request = new GroceryStoreEndpointsRequestDTO();
		request.setId("123");
		request.setProductDescription("123");
		request.setProductName("123");
		request.setProductValue(BigDecimal.ZERO);
		request.setTypeOfProduct("123");

		assertThrows(DataBaseException.class, () -> service.updateGroceryProduct(request));

	}

	@Test
	public void shouldUpdate() {

		GroceryStoreEndpointsRequestDTO request = new GroceryStoreEndpointsRequestDTO();
		request.setProductDescription("Des");
		request.setId("99999");

		request.setProductName("233");
		request.setProductValue(BigDecimal.ZERO);
		request.setTypeOfProduct("1232131233");

		GroceryProductEntity entity = new GroceryProductEntity();
		entity.setId("99999");
		repository.insert(entity);
		assertThat(service.updateGroceryProduct(request)).isNotNull();

	}

	@Test
	public void shouldDelete() {

		GroceryStoreEndpointsRequestDTO request = new GroceryStoreEndpointsRequestDTO();
		request.setId("11111111");

		GroceryProductEntity entity = new GroceryProductEntity();
		entity.setId("11111111");
		repository.insert(entity);
		service.deleteGroceryStoreProduct(request);

	}

	@Test
	public void shouldNotDelete() {

		GroceryStoreEndpointsRequestDTO request = new GroceryStoreEndpointsRequestDTO();
		request.setId("11111111");

		repository.deleteAll();
		assertThrows(DataBaseException.class, () -> service.deleteGroceryStoreProduct(request));

	}

}
