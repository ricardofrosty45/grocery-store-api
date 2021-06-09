package com.grocery.store.ws.endpoints.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.grocery.store.ws.dto.request.GroceryStoreEndpointsRequestDTO;
import com.grocery.store.ws.endpoints.GroceryStoreCrudEndpoints;
import com.grocery.store.ws.mongodb.entities.GroceryProductEntity;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class GroceryStoreCrudEndpointsTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private GroceryStoreCrudEndpoints controller;

	private GroceryStoreEndpointsRequestDTO request = new GroceryStoreEndpointsRequestDTO();

	@Before
	public void before() throws Exception {
		request.setProductDescription("Description");
		request.setProductName("Name");
		request.setProductValue(BigDecimal.ONE);
		request.setTypeOfProduct("Type");
	}

	@Test
	public void shouldLoadContext() throws Exception {
		assertThat(controller).isNotNull();
	}

	@Test
	public void shouldReturnNewCreatedEntity() throws Exception {

		ResponseEntity<GroceryProductEntity> response = restTemplate
				.postForEntity("http://localhost:" + port + "/v1/store-product", request, GroceryProductEntity.class);
		log.info(response.getBody().toString());

		assertThat(restTemplate.postForEntity("http://localhost:" + port + "/v1/store-product", request,
				GroceryProductEntity.class));
	}

}
