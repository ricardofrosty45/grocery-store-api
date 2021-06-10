package com.grocery.store.ws.third.party.api.test.request;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateUserRequest {

	private String email;

	private String name;

	private String documentNumber;

	private Date birthDate;

}
