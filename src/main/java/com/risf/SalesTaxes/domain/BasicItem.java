package com.risf.SalesTaxes.domain;

import com.risf.SalesTaxes.calculator.BasicTaxCalculator;
import jakarta.annotation.Resource;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Locale;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class BasicItem extends Item {

	public BasicItem(final String name, final double price, final boolean isExempt, final int quantity) {
		this.name = name;
		this.price = price;
		this.isExempt = isExempt;
		this.quantity = quantity;
		this.taxCalculator = new BasicTaxCalculator();
	}

	@Override
	public double getTax() {
		return taxCalculator.calculateTax(this);
	}

	@Override
	public String toString() {
		return String.format(Locale.US, "%d %s: %.2f", quantity, name, price + getTax());
	}
}
