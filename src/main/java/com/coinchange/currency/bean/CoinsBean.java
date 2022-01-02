package com.coinchange.currency.bean;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@NotNull
public class CoinsBean {
	private Integer penny;
	private Integer nickel;
	private Integer dime;
	private Integer quater;
	
}
