package com.coinchange.currency.service;

import org.springframework.stereotype.Service;

import com.coinchange.currency.bean.CoinsBean;
import com.coinchange.currency.init.CurrencyInit;

@Service
public class CurrencyService {


	private final int[] currencies = new int[] { 1, 5, 10, 25 };

	public CoinsBean coinChange(int amount) throws InsufficientFundsException{
		int dime = 0;
		int penny = 0;
		int nickel = 0;
		int quater = 0;
		
		amount *= 100;

		int totalAvaliable = getTotalAvailableCents(currencies);
		if (amount > totalAvaliable) {
			throw new InsufficientFundsException("InSufficient Funds");
		}

		for(int count=currencies.length-1; count>=0;count--) {
			for(;(amount>0) && amount >= currencies[count] && CurrencyInit.coinMap.get(currencies[count]) > 0;) {
				amount -= currencies[count];
				switch (currencies[count]) {
				case 1:
					penny++;
					CurrencyInit.coinMap.put(new Integer(currencies[count]), CurrencyInit.coinMap.get(new Integer(currencies[count])) - 1);
					break;
				case 5:
					nickel++;
					CurrencyInit.coinMap.put(new Integer(currencies[count]), CurrencyInit.coinMap.get(new Integer(currencies[count])) - 1);
					break;
				case 10:
					dime++;
					CurrencyInit.coinMap.put(new Integer(currencies[count]), CurrencyInit.coinMap.get(new Integer(currencies[count])) - 1);
					break;
				case 25:
					quater++;
					CurrencyInit.coinMap.put(new Integer(currencies[count]), CurrencyInit.coinMap.get(new Integer(currencies[count])) - 1);
					break;
				}
			}//while(amount>0);
			
		}
		CoinsBean coinBean = new CoinsBean(penny, nickel, dime, quater);
		return coinBean;
	}
	
	private int getTotalAvailableCents(int arr[]) {
		int availableCount = 0;
		for (int i = 0; i < arr.length; i++) {
			int actualCoin = arr[i];// ew Double(arr[i]/100);
			// actualCoin = new BigDecimal(arr[i]).doubleValue();
			availableCount += (actualCoin * CurrencyInit.coinMap.get(actualCoin));
		}
		return availableCount;
	}
	
}
