package com.coinchange.currency.controller;

import javax.validation.ConstraintViolationException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.coinchange.currency.service.InsufficientFundsException;

@RestControllerAdvice
public class CurrencyExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleConstraintException(Exception ex) {
		return ResponseEntity.internalServerError().body(ex.getMessage());
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> handleConstraintException(ConstraintViolationException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
	
	@ExceptionHandler(InsufficientFundsException.class)
	public ResponseEntity<String> handleInsufficientFundsException(InsufficientFundsException ex) {
		return ResponseEntity.badRequest().body("Insufficient Funds.");
	}
}
