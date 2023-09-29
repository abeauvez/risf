package com.risf.SalesTaxes.calculator;

import com.risf.SalesTaxes.domain.Item;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class BasicTaxCalculator implements TaxCalculator {

	static final double BASIC_TAX_RATE = 10;

	@Override
	public double calculateTax(Item item) {
		return item.isExempt() ? 0 : Math.round((item.getPrice() * BASIC_TAX_RATE / 100) * 20.0) / 20.0;
	}

}
