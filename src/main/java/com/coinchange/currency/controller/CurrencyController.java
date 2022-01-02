package com.coinchange.currency.controller;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.coinchange.currency.bean.CoinsBean;
import com.coinchange.currency.service.CurrencyService;
import com.coinchange.currency.service.InsufficientFundsException;
import com.coinchange.currency.validator.IsCurrencyValid;


@Validated
@RestController
public class CurrencyController {
	
	@Autowired
	private CurrencyService currenctService;
	
	@GetMapping(path = "/{bill}/dollar/coin-convertor")
	public ResponseEntity<?> getTotalCombination(@PathVariable @IsCurrencyValid Integer bill) {
		ResponseEntity response = null;
		try {
			response = new ResponseEntity(currenctService.coinChange(bill), HttpStatus.OK);
		} catch (InsufficientFundsException e) {
			response = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return response;
		
	}
	
}
