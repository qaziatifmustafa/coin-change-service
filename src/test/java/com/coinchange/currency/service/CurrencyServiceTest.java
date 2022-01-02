package com.coinchange.currency.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.coinchange.currency.bean.CoinsBean;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
class CurrencyServiceTest {

	@InjectMocks
	private CurrencyService currencyService;
	
//	@BeforeAll
//	void setup(){
//		
//	}
	@Test
	void testCoinConversion() {
		Integer value = Integer.valueOf(2);
		CoinsBean coinsResult = currencyService.coinChange(value);
		
		assertNotNull(coinsResult);
		assertEquals(0, coinsResult.getPenny());
		assertEquals(0, coinsResult.getNickel());
		assertEquals(8, coinsResult.getQuater());
	}


	@Test
	void testCoinConversionInsuffcientFunds() {
		//ReflectionTestUtils.setField(currencyService, "coinMap", new LinkedHashMap<Integer,Integer>());
		Integer value = Integer.valueOf(42);
		assertThrows(InsufficientFundsException.class, () -> currencyService.coinChange(value));

	}

}
