package com.coinchange.currency.validator;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CurrencyValidator implements ConstraintValidator<IsCurrencyValid, Integer>{

	List<Integer> bills = Arrays.asList(new Integer[] {1, 2, 5, 10, 20, 50, 100});
	
	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		System.out.println("*********************************" + value);
		return bills.contains(value);
	}

}
