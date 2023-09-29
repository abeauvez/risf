package com.risf.SalesTaxes.domain;

import com.risf.SalesTaxes.calculator.TaxCalculator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Item implements Taxable {

	String name;

	int quantity;

	double price;

	boolean isExempt;

	TaxCalculator taxCalculator;

}
