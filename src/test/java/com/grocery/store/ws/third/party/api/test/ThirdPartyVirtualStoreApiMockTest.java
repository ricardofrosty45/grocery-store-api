package com.grocery.store.ws.third.party.api.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;
import com.grocery.store.ws.third.party.api.test.request.CreateUserRequest;
import com.grocery.store.ws.third.party.api.test.response.CreatedUserResponse;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class ThirdPartyVirtualStoreApiMockTest {

	@Autowired
	private TestRestTemplate restTemplate;

	private String endpointTest = "https://virtual-store-project-back-end.herokuapp.com/v1/user";

	@Test
	public void shouldCreateNewUser() throws Exception {

		CreateUserRequest createUserRequest = new Gson().fromJson("{\r\n" + "  \"birthDate\": \"1998-04-15\",\r\n"
				+ "  \"documentNumber\": \"10821107445\",\r\n" + "  \"email\": \"11123333.com\",\r\n"
				+ "  \"name\": \"Luan Ricardo De Luna Vieira Venancio\"\r\n" + "}", CreateUserRequest.class);
		createUserRequest.setEmail(UUID.randomUUID().toString());
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<CreateUserRequest> entity = new HttpEntity<>(createUserRequest, headers);

		ResponseEntity<CreatedUserResponse> rest = restTemplate.exchange(endpointTest, HttpMethod.POST, entity,
				CreatedUserResponse.class);

		log.info("Result:" + rest.getBody().toString());
		createUserRequest.setEmail(UUID.randomUUID().toString());
		assertThat(restTemplate.postForEntity(endpointTest, new Gson().toJson(createUserRequest),
				CreatedUserResponse.class));
	}

}
