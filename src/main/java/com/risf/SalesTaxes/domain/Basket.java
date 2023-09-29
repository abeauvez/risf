package com.risf.SalesTaxes.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Basket {

	List<Item> items;

	double totalAmount;

	double totalTaxes;

	public Basket(List<Item> items) {
		this.items = items;
	}

}
