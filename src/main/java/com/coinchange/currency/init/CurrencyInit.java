package com.coinchange.currency.init;

import java.util.LinkedHashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CurrencyInit {

	@Value("${count.of.coins}")
	private Integer countOfCoins;

	public static LinkedHashMap<Integer, Integer> coinMap = new LinkedHashMap<>();

	@PostConstruct
	public void init() {
		fillMap();
	}

	private void fillMap() {
		coinMap.put(1, countOfCoins);
		coinMap.put(5, countOfCoins);
		coinMap.put(10, countOfCoins);
		coinMap.put(25, countOfCoins);
	}

}
