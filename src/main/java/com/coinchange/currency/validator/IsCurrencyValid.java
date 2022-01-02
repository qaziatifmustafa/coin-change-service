package com.coinchange.currency.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
@Constraint(validatedBy = CurrencyValidator.class)
public @interface IsCurrencyValid {
	String message() default "Invalid value for currency conversion";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
