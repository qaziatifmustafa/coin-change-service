package com.coinchange.currency.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.coinchange.currency.bean.CoinsBean;
import com.coinchange.currency.service.CurrencyService;

@ExtendWith(MockitoExtension.class)
class CurrencyControllerTest {

	@Mock
	private CurrencyService currenctService;
	
	@InjectMocks
	private CurrencyController controller;
	
	@Test
	void testCoinConversion() {
		Integer value = Integer.valueOf(2);
		CoinsBean coins = new CoinsBean();
		coins.setPenny(100);
		coins.setNickel(50);
		when(currenctService.coinChange(value)).thenReturn(coins);
		ResponseEntity<?> response = controller.getTotalCombination(value);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(coins, response.getBody());
		verify(currenctService).coinChange(value);
	}

	@Test
	void testCoinConversionInsuffcientFunds() {
		Integer value = Integer.valueOf(2);
		CoinsBean coins = new CoinsBean();
		when(currenctService.coinChange(value)).thenReturn(coins);
		ResponseEntity<?> response = controller.getTotalCombination(value);
		
		//TODO change status code
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(coins, response.getBody());
		verify(currenctService).coinChange(value);
	}

}
