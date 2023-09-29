package com.risf.SalesTaxes.printer;

import com.risf.SalesTaxes.domain.Basket;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import static java.util.Locale.US;


@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReceiptPrinter {

	public static final char NEW_LINE = '\n';

	public static final String TAX_FORMAT = "Saled Taxes: %.2f Total: %.2f";

	Basket basket;

	public void print() {
		StringBuilder receiptBuilder = new StringBuilder();

		this.basket
			.getItems()
			.forEach(item -> {
				receiptBuilder.append(item.toString()).append(NEW_LINE);
			});

		receiptBuilder.append(String.format(US, TAX_FORMAT, basket.getTotalTaxes(), basket.getTotalAmount()));
		System.out.println(receiptBuilder);
	}
}
