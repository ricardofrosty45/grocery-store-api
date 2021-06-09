package com.grocery.store.ws.repository.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.grocery.store.ws.mongodb.entities.GroceryProductEntity;
import com.grocery.store.ws.mongodb.repository.GroceryStoreRepository;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureDataMongo
@Slf4j
public class GroceryStoreRepositoryTest {

	@Autowired
	private GroceryStoreRepository repository;

	private GroceryProductEntity deleteEntity = new GroceryProductEntity();

	@Before
	public void setUp() throws Exception {
		repository.save(new GroceryProductEntity().withProductName("TestName").withProductValue(BigDecimal.ZERO)
				.withProductDescription("DescriptionTest").withTypeOfProduct("TypeTest").build());
	}

	@Test
	public void shouldCreate() {

		assertThat(
				repository.save(new GroceryProductEntity().withProductName("TestName").withProductValue(BigDecimal.ZERO)
						.withProductDescription("DescriptionTest").withTypeOfProduct("TypeTest").build()));
	}

	@Test
	public void shouldBeNotEmpty() {
		List<GroceryProductEntity> listProduct = repository.findAll();
		GroceryProductEntity entityTest = listProduct.get(0);
		deleteEntity = listProduct.get(0);
		log.info("Entity Test Id:" + entityTest.getId());
		log.info("Entity Name:" + entityTest.getProductName());

		assertThat(listProduct).isNotEmpty();
	}

	@Test
	@Order(2)
	public void shouldRead() {
		assertThat(repository.findAll()).isNotEmpty();
	}

	@Test
	@Order(3)
	public void shouldDelete() {
		deleteEntity = repository.findByProductName("TestName");
		repository.delete(deleteEntity);
	}

}
