package com.coinchange.currency.service;

public class InsufficientFundsException extends RuntimeException {
	public InsufficientFundsException(String message ) {
		super(message);
	}
}
