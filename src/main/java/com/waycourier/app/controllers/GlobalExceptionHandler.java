package com.waycourier.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;

import com.waycourier.app.to.ErrorMessage;

@RestControllerAdvice
public class GlobalExceptionHandler {

	 	@ExceptionHandler(HttpClientErrorException.class)
	    public ResponseEntity<ErrorMessage> handleStatusCodeException(HttpStatusCodeException e) {
		 ErrorMessage errorMessage = new ErrorMessage(e.getStatusCode().value(), e.getStatusCode().toString(), e.getStatusText());
			return ResponseEntity.status(e.getStatusCode()).body(errorMessage);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<ErrorMessage> handleException(Exception e) {
	    	ErrorMessage errorMessage = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error",	e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
	    }
}
