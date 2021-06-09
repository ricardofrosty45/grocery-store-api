package com.grocery.store.ws.advice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.grocery.store.ws.exception.DataBaseException;
import com.grocery.store.ws.exception.RequestIsWrongException;

@ControllerAdvice
public class GroceryStoreControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RequestIsWrongException.class)
	public ResponseEntity<Object> requestIsWrong(RequestIsWrongException ex) {
		Map<String, Object> bodyResponde = new LinkedHashMap<>();
		bodyResponde.put("timestamp", LocalDateTime.now());
		bodyResponde.put("message", ex.getMessage());
		return new ResponseEntity<>(bodyResponde, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<Object> didNotFindResultsIntoDatabase(DataBaseException ex) {
		Map<String, Object> bodyResponde = new LinkedHashMap<>();
		bodyResponde.put("timestamp", LocalDateTime.now());
		bodyResponde.put("message", ex.getMessage());
		return new ResponseEntity<>(bodyResponde, HttpStatus.NOT_FOUND);
	}

}
