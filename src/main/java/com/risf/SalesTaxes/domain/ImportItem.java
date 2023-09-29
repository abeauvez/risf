package com.risf.SalesTaxes.domain;

import com.risf.SalesTaxes.calculator.ImportTaxCalculator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Locale;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImportItem extends Item {

	public ImportItem(final String name, final double price, final boolean isExempt, final int quantity) {
		this.name = name;
		this.price = price;
		this.isExempt = isExempt;
		this.quantity = quantity;
		this.taxCalculator = new ImportTaxCalculator();
	}

	@Override
	public double getTax() {
		return taxCalculator.calculateTax(this);
	}

	@Override
	public String toString() {
		return String.format(Locale.US, "%d imported %s: %.2f", quantity, name, price + getTax());
	}
}
