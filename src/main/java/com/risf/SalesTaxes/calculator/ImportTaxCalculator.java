package com.risf.SalesTaxes.calculator;

import com.risf.SalesTaxes.domain.Item;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImportTaxCalculator implements TaxCalculator {

	static final double IMPORT_TAX_RATE = 5;

	static final double BASIC_TAX_RATE = 10;

	@Override
	public double calculateTax(final Item item) {
		final double basicTax = item.isExempt() ? 0 : Math.round((item.getPrice() * BASIC_TAX_RATE / 100) * 20.0) / 20.0;
		final double importTax = Math.ceil((item.getPrice() * IMPORT_TAX_RATE / 100) * 20.0) / 20.0;
		return basicTax + importTax;
	}

}
